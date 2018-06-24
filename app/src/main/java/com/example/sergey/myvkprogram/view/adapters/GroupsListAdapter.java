package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class GroupsListAdapter extends RecyclerView.Adapter<GroupsListAdapter.ViewHolder> {

    private List<Group> groups = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.roundedimageview_title_subtile_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position >= groups.size()) {
            return;
        }

        holder.bindViewHolder(groups.get(position));
    }

    @Override
    public int getItemCount() {
        return groups.size();
    }

    public void updateData(@NonNull List<Group> groups) {
        this.groups.clear();
        this.groups.addAll(groups);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RoundedImageView photoView;
        private TextView title;
        private TextView subtitle;

        ViewHolder(View itemView) {
            super(itemView);

            photoView = itemView.findViewById(R.id.photo);
            title = itemView.findViewById(R.id.title);
            subtitle = itemView.findViewById(R.id.subtitle);
        }

        void bindViewHolder(Group group) {
            Glide.with(itemView.getContext())
                    .load(group.getPhotoUrl())
                    .into(photoView);

            title.setText(group.getName());

            @StringRes int subtitleRes = 0;
            if (Group.GROUP.equals(group.getType())) {
                subtitleRes = R.string.fragment_groups_type_group;
            } else if (Group.PAGE.equals(group.getType())) {
                subtitleRes = R.string.fragment_groups_type_page;
            } else if (Group.EVENT.equals(group.getType())) {
                subtitleRes = R.string.fragment_groups_type_event;
            }

            if (subtitleRes != 0) {
                subtitle.setText(itemView.getContext().getString(subtitleRes));
                subtitle.setVisibility(View.VISIBLE);
            }
        }
    }
}
