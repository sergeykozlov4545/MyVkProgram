package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.managers.DataManager.PhotosDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.presenter.main.PhotosFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.ListAdapter;
import com.example.sergey.myvkprogram.view.adapters.PhotosListAdapter;

public class PhotosFragment extends BaseListFragment<Photo> {

    private PhotosFragmentPresenterImpl presenter;

    private RecyclerView photosListView;
    private PhotosListAdapter photosListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new PhotosFragmentPresenterImpl(new PhotosDataManager());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        addView(R.layout.fragment_photos);
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
    protected ListAdapter<Photo> getListAdapter() {
        return photosListAdapter;
    }

    @NonNull
    @Override
    protected RecyclerView getListView() {
        return photosListView;
    }

    private void initViews(@Nullable View view) {
        if (view == null) {
            return;
        }

        photosListView = view.findViewById(R.id.photosList);
        photosListView.setHasFixedSize(true);

        photosListView.setLayoutManager(
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));

        photosListAdapter = new PhotosListAdapter();
        photosListView.setAdapter(photosListAdapter);
    }
}
