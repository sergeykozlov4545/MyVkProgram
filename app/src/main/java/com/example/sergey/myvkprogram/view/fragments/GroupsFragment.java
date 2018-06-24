package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.contracts.GroupsFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.GroupsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceManager.GroupsQueryServiceManager;
import com.example.sergey.myvkprogram.presenter.main.GroupsFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.GroupsListAdapter;

import java.util.List;

public class GroupsFragment extends BaseFragment implements GroupsFragmentContract.GroupsFragmentView {

    private View content;

    private RecyclerView groupsListView;
    private GroupsListAdapter groupsListAdapter;

    private GroupsQueryServiceManager serviceManager;
    private GroupsFragmentContract.GroupsFragmentPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        GroupsQueryParams params = new GroupsQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setUserId(Constants.MOCK_USER_ID);

        serviceManager = new GroupsQueryServiceManager(params);
        presenter = new GroupsFragmentPresenterImpl(serviceManager);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        addView(R.layout.fragment_groups);
        initViews();

        presenter.attachView(this);
        presenter.viewIsReady();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        presenter.detachView();
    }

    @Override
    public void showGroups(@NonNull List<Group> groups) {
        if (groupsListAdapter != null) {
            groupsListAdapter.updateData(groups);
        }
        content.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        content = getContentView().findViewById(R.id.content);

        groupsListView = content.findViewById(R.id.groupsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        groupsListView.setLayoutManager(layoutManager);
        groupsListAdapter = new GroupsListAdapter();
        groupsListView.setAdapter(groupsListAdapter);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        groupsListView.addItemDecoration(dividerItemDecoration);
    }
}
