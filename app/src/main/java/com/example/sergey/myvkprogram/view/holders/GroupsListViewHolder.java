package com.example.sergey.myvkprogram.view.holders;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.View;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.pojo.object.Group;

public class GroupsListViewHolder extends TitleSubTitleViewHolder<Group> {

    public GroupsListViewHolder(View itemView) {
        super(itemView);
    }

    @NonNull
    @Override
    protected String getPhotoUrl(@NonNull Group group) {
        return group.getPhotoUrl();
    }

    @Nullable
    @Override
    protected String getTitle(@NonNull Group group) {
        return group.getName();
    }

    @Nullable
    @Override
    protected String getSubTitleId(@NonNull Group group) {
        @StringRes int subtitleRes = 0;
        if (Group.GROUP.equals(group.getType())) {
            subtitleRes = R.string.fragment_groups_type_group;
        } else if (Group.PAGE.equals(group.getType())) {
            subtitleRes = R.string.fragment_groups_type_page;
        } else if (Group.EVENT.equals(group.getType())) {
            subtitleRes = R.string.fragment_groups_type_event;
        }

        return (subtitleRes == 0) ? null : itemView.getContext().getString(subtitleRes);
    }
}
