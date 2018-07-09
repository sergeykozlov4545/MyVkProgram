package com.example.sergey.myvkprogram.view.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sergey.myvkprogram.model.managers.DataManager.GroupsDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.presenter.main.GroupsFragmentPresenter;
import com.example.sergey.myvkprogram.view.adapters.BaseListAdapter;
import com.example.sergey.myvkprogram.view.adapters.GroupsListAdapter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public class GroupsFragment extends SwipeRefreshListFragment<Group> {

    @NonNull
    @Override
    protected Presenter<FragmentView<Group>> getPresenter() {
        return new GroupsFragmentPresenter(new GroupsDataManager());
    }

    @NonNull
    @Override
    protected BaseListAdapter<Group> getListAdapter() {
        return new GroupsListAdapter();
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
