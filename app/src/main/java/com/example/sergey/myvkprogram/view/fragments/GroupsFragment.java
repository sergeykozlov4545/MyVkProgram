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

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.managers.DataManager.GroupsDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.presenter.main.GroupsFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.GroupsListAdapter;
import com.example.sergey.myvkprogram.view.adapters.ListAdapter;

public class GroupsFragment extends BaseListFragment<Group> {

    private RecyclerView groupsListView;
    private GroupsListAdapter groupsListAdapter;

    private GroupsFragmentPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new GroupsFragmentPresenterImpl(new GroupsDataManager());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        addView(R.layout.fragment_groups);
        initViews(view);

        presenter.attachView(this);
        presenter.viewIsReady();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        presenter.detachView();
    }

    @NonNull
    @Override
    protected ListAdapter<Group> getListAdapter() {
        return groupsListAdapter;
    }

    @NonNull
    @Override
    protected RecyclerView getListView() {
        return groupsListView;
    }

    private void initViews(@Nullable View view) {
        if (view == null) {
            return;
        }

        groupsListView = view.findViewById(R.id.groupsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        groupsListView.setLayoutManager(layoutManager);
        groupsListAdapter = new GroupsListAdapter();
        groupsListView.setAdapter(groupsListAdapter);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        groupsListView.addItemDecoration(dividerItemDecoration);
    }
}
