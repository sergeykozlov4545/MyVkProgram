package com.example.sergey.myvkprogram.view.holders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.pojo.object.User;

public class FriendsListViewHolder extends TitleSubTitleViewHolder<User> {

    public FriendsListViewHolder(View itemView) {
        super(itemView);
    }

    @NonNull
    @Override
    protected String getPhotoUrl(@NonNull User user) {
        return user.getPhotoUrl();
    }

    @Nullable
    @Override
    protected String getTitle(@NonNull User user) {
        return user.getAllName();
    }

    @Nullable
    @Override
    protected String getSubTitleId(@NonNull User user) {
        return user.isOnline()
                ? itemView.getContext().getString(R.string.fragment_friends_user_online)
                : itemView.getContext().getString(R.string.fragment_friends_user_offline);
    }
}
