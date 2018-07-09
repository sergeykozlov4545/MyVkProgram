package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.view.holders.BaseViewHolder;
import com.example.sergey.myvkprogram.view.holders.VideosListViewHolder;
import com.example.sergey.myvkprogram.view.utils.VideoDescriptionManager;
import com.example.sergey.myvkprogram.view.utils.VideoDescriptionManagerImpl;


public class VideosListAdapter extends BaseListAdapter<Video> {

    private VideoDescriptionManager videoDescriptionManager = new VideoDescriptionManagerImpl();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_videos_item;
    }

    @NonNull
    @Override
    protected BaseViewHolder<Video> getViewHolder(@NonNull View view) {
        return new VideosListViewHolder(view, videoDescriptionManager);
    }
}
