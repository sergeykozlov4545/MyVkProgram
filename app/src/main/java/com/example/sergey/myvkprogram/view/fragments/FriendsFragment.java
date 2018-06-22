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
import com.example.sergey.myvkprogram.contracts.FriendsFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.User;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.FriendsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceManager.FriendsQueryServiceManager;
import com.example.sergey.myvkprogram.presenter.main.FriendsFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.FriendsListAdapter;

import java.util.List;

public class FriendsFragment extends BaseFragment implements FriendsFragmentContract.FriendsFragmentView {

    private FriendsQueryServiceManager serviceManager;
    private FriendsFragmentContract.FriendsFragmentPresenter presenter;

    private View content;

    private RecyclerView friendsListView;
    private FriendsListAdapter friendsListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FriendsQueryParams params = new FriendsQueryParams()
                .setAccessToken(Constants.ACCESS_TOKEN)
                .setVersionApi(Constants.API_VERSION)
                .setUserId(Constants.MOCK_USER_ID)
                .setOrder(Constants.ORDER)
                .setFields(Constants.USER_FIELDS.PHOTO_50);
        serviceManager = new FriendsQueryServiceManager(params);
        presenter = new FriendsFragmentPresenterImpl(serviceManager);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        addView(R.layout.fragment_friends);
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
    public void showFriends(List<User> users) {
        if (friendsListAdapter != null) {
            friendsListAdapter.updateData(users);
        }
        content.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        content = getContentView().findViewById(R.id.content);

        friendsListView = content.findViewById(R.id.friendsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        friendsListView.setLayoutManager(layoutManager);
        friendsListAdapter = new FriendsListAdapter();
        friendsListView.setAdapter(friendsListAdapter);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        friendsListView.addItemDecoration(dividerItemDecoration);
    }
}
