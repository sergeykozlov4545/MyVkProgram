package com.example.sergey.myvkprogram.view.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.sergey.myvkprogram.model.managers.DataManager.PhotosDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.presenter.main.PhotosFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.BaseListAdapter;
import com.example.sergey.myvkprogram.view.adapters.PhotosListAdapter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public class PhotosFragment extends SwipeRefreshListFragment<Photo> {

    @NonNull
    @Override
    public Presenter<FragmentView<Photo>> getPresenter() {
        return new PhotosFragmentPresenterImpl(new PhotosDataManager());
    }

    @NonNull
    @Override
    protected BaseListAdapter<Photo> getListAdapter() {
        return new PhotosListAdapter();
    }

    @NonNull
    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
    }

    @Override
    protected boolean isWithDividers() {
        return false;
    }
}
