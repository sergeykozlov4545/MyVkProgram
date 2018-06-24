package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.contracts.VideosFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.VideosQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceManager.VideosQueryServiceManager;
import com.example.sergey.myvkprogram.presenter.main.VideosFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.VideosListAdapter;

import java.util.List;

public class VideosFragment extends BaseFragment implements VideosFragmentContract.VideosFragmentView {

    private View content;

    private RecyclerView videosListView;
    private VideosListAdapter videosListAdapter;

    private VideosQueryServiceManager serviceManager;
    private VideosFragmentPresenterImpl presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        VideosQueryParams params = new VideosQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setOwnerId(Constants.MOCK_USER_ID);
        serviceManager = new VideosQueryServiceManager(params);
        presenter = new VideosFragmentPresenterImpl(serviceManager);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        addView(R.layout.fragment_videos);
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
    public void showVideos(@NonNull List<Video> videos) {
        if (videosListAdapter != null) {
            videosListAdapter.updateData(videos);
        }

        content.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        content = getContentView().findViewById(R.id.content);

        videosListView = content.findViewById(R.id.videoList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        videosListView.setLayoutManager(layoutManager);

        videosListAdapter = new VideosListAdapter();
        videosListView.setAdapter(videosListAdapter);
    }
}
