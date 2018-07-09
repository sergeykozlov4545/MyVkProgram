package com.example.sergey.myvkprogram.view.holders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.glide.GlideApp;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.model.pojo.object.PhotoSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhotosListViewHolder extends BaseViewHolder<Photo> {

    private ImageView photoView;

    public PhotosListViewHolder(View itemView) {
        super(itemView);

        photoView = itemView.findViewById(R.id.photo);
    }

    @Override
    public void bindViewHolder(@NonNull Photo photo, int position) {
        List<PhotoSize> sizes = photo.getSizes();
        PhotoSize photoSize = getMaxGoodPhotoUrl(sizes);

        if (isValidPhotoSize(photoSize)) {
            GlideApp.with(itemView.getContext())
                    .load(photoSize.getUrl())
                    .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                    .format(DecodeFormat.PREFER_RGB_565)
                    .placeholder(R.drawable.ic_placeholder_grey)
                    .override(photoSize.getWidth(), photoSize.getHeight())
                    .into(photoView);
        }
    }

    @Nullable
    private PhotoSize getMaxGoodPhotoUrl(@NonNull List<PhotoSize> sizes) {
        List<PhotoSize> sortedSizes = new ArrayList<>(sizes);
        Collections.sort(sortedSizes, (ps1, ps2) -> ps2.getType().compareTo(ps1.getType()));

        for (int i = 0; i < sortedSizes.size(); i++) {
            PhotoSize photoSize = sortedSizes.get(i);
            if (isValidPhotoSize(photoSize)) {
                return photoSize;
            }
        }

        return null;
    }

    private boolean isValidPhotoSize(@Nullable PhotoSize photoSize) {
        return photoSize != null
                && !TextUtils.isEmpty(photoSize.getType())
                && !TextUtils.isEmpty(photoSize.getUrl());
    }
}
