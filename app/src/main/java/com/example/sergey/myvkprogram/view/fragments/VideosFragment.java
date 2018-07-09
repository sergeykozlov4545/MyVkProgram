package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.managers.DataManager.VideosDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.presenter.main.VideosFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.ListAdapter;
import com.example.sergey.myvkprogram.view.adapters.VideosListAdapter;

public class VideosFragment extends BaseListFragment<Video> {

    private RecyclerView videosListView;
    private VideosListAdapter videosListAdapter;

    private VideosFragmentPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new VideosFragmentPresenterImpl(new VideosDataManager());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        addView(R.layout.fragment_videos);
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
    protected ListAdapter<Video> getListAdapter() {
        return videosListAdapter;
    }

    @NonNull
    @Override
    protected RecyclerView getListView() {
        return videosListView;
    }

    private void initViews(@Nullable View view) {
        if (view == null) {
            return;
        }

        videosListView = view.findViewById(R.id.videoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        videosListView.setLayoutManager(layoutManager);

        videosListAdapter = new VideosListAdapter();
        videosListView.setAdapter(videosListAdapter);
    }
}
