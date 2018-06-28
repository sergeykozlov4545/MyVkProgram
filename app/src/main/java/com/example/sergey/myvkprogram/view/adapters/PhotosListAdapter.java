package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.glide.GlideApp;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.model.pojo.object.PhotoSize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhotosListAdapter extends RecyclerView.Adapter<PhotosListAdapter.ViewHolder> {

    private List<Photo> photos = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_photos_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position >= photos.size()) {
            return;
        }

        holder.bindViewHolder(photos.get(position));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public void updateData(@NonNull List<Photo> photos) {
        this.photos.clear();
        this.photos.addAll(photos);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView photoView;

        ViewHolder(View itemView) {
            super(itemView);

            photoView = itemView.findViewById(R.id.photo);
        }

        void bindViewHolder(@NonNull Photo photo) {
            List<PhotoSize> sizes = photo.getSizes();
            PhotoSize photoSize = getMaxGoodPhotoUrl(sizes);

            if (isValidPhotoSize(photoSize)) {
                GlideApp.with(itemView.getContext())
                        .load(photoSize.getUrl())
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
}
