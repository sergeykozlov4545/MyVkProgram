package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.NonNull;
import android.view.View;

import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.view.holders.BaseViewHolder;
import com.example.sergey.myvkprogram.view.holders.GroupsListViewHolder;

public class GroupsListAdapter extends TitleSubTitleListAdapter<Group> {

    @NonNull
    @Override
    protected BaseViewHolder<Group> getViewHolder(@NonNull View view) {
        return new GroupsListViewHolder(view);
    }
}
