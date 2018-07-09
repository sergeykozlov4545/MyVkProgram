package com.example.sergey.myvkprogram.view.holders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sergey.myvkprogram.R;
import com.makeramen.roundedimageview.RoundedImageView;

public abstract class TitleSubTitleViewHolder<T> extends BaseViewHolder<T> {

    private RoundedImageView photoView;
    private TextView title;
    private TextView subtitle;

    TitleSubTitleViewHolder(View itemView) {
        super(itemView);

        photoView = itemView.findViewById(R.id.photo);
        title = itemView.findViewById(R.id.title);
        subtitle = itemView.findViewById(R.id.subtitle);
    }

    @Override
    public void bindViewHolder(@NonNull T value, int position) {
        Glide.with(itemView.getContext())
                .load(getPhotoUrl(value))
                .into(photoView);

        title.setText(getTitle(value));

        if (getSubTitleId(value) != null) {
            subtitle.setText(getSubTitleId(value));
            subtitle.setVisibility(View.VISIBLE);
        }
    }

    @NonNull
    protected abstract String getPhotoUrl(@NonNull T value);

    @Nullable
    protected abstract String getTitle(@NonNull T value);

    @Nullable
    protected abstract String getSubTitleId(@NonNull T value);
}
