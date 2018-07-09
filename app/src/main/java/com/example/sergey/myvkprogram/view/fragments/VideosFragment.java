package com.example.sergey.myvkprogram.view.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sergey.myvkprogram.model.managers.DataManager.VideosDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.presenter.main.VideosFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.BaseListAdapter;
import com.example.sergey.myvkprogram.view.adapters.VideosListAdapter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public class VideosFragment extends SwipeRefreshListFragment<Video> {

    @NonNull
    @Override
    protected Presenter<FragmentView<Video>> getPresenter() {
        return new VideosFragmentPresenterImpl(new VideosDataManager());
    }

    @NonNull
    @Override
    protected BaseListAdapter<Video> getListAdapter() {
        return new VideosListAdapter();
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
    }

    @Override
    protected boolean isWithDividers() {
        return false;
    }
}
