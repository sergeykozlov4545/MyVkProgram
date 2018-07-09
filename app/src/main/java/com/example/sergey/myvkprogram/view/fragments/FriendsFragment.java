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
import com.example.sergey.myvkprogram.model.managers.DataManager.FriendsDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.presenter.main.FriendsFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.FriendsListAdapter;
import com.example.sergey.myvkprogram.view.adapters.ListAdapter;

public class FriendsFragment extends BaseListFragment<User> {

    private FriendsFragmentPresenterImpl presenter;

    private RecyclerView friendsListView;
    private FriendsListAdapter friendsListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new FriendsFragmentPresenterImpl(new FriendsDataManager());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        addView(R.layout.fragment_friends);
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
    protected ListAdapter<User> getListAdapter() {
        return friendsListAdapter;
    }

    @NonNull
    @Override
    protected RecyclerView getListView() {
        return friendsListView;
    }

    private void initViews(@Nullable View view) {
        if (view == null) {
            return;
        }

        friendsListView = view.findViewById(R.id.friendsList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        friendsListView.setLayoutManager(layoutManager);
        friendsListAdapter = new FriendsListAdapter();
        friendsListView.setAdapter(friendsListAdapter);

        DividerItemDecoration dividerItemDecoration =
                new DividerItemDecoration(getContext(), layoutManager.getOrientation());
        friendsListView.addItemDecoration(dividerItemDecoration);
    }
}
