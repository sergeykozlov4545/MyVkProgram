package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.view.holders.BaseViewHolder;
import com.example.sergey.myvkprogram.view.holders.FriendsListViewHolder;

public class FriendsListAdapter extends TitleSubTitleListAdapter<User> {

    @NonNull
    @Override
    protected BaseViewHolder<User> getViewHolder(@NonNull View view) {
        return new FriendsListViewHolder(view);
    }
}