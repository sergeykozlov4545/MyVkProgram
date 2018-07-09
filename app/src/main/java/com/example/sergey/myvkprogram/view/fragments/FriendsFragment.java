package com.example.sergey.myvkprogram.view.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sergey.myvkprogram.model.managers.DataManager.FriendsDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.presenter.main.FriendsFragmentPresenter;
import com.example.sergey.myvkprogram.view.adapters.BaseListAdapter;
import com.example.sergey.myvkprogram.view.adapters.FriendsListAdapter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public class FriendsFragment extends SwipeRefreshListFragment<User> {

    @NonNull
    @Override
    protected Presenter<FragmentView<User>> getPresenter() {
        return new FriendsFragmentPresenter(new FriendsDataManager());
    }

    @NonNull
    @Override
    protected BaseListAdapter<User> getListAdapter() {
        return new FriendsListAdapter();
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    protected boolean isWithDividers() {
        return true;
    }
}
