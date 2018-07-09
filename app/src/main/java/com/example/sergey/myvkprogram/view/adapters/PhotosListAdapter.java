package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.view.holders.BaseViewHolder;
import com.example.sergey.myvkprogram.view.holders.PhotosListViewHolder;

public class PhotosListAdapter extends BaseListAdapter<Photo> {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_photos_list_item;
    }

    @NonNull
    @Override
    protected BaseViewHolder<Photo> getViewHolder(@NonNull View view) {
        return new PhotosListViewHolder(view);
    }
}
