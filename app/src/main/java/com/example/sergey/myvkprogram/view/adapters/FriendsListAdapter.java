package com.example.sergey.myvkprogram.view.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.model.pojo.User;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.ArrayList;
import java.util.List;

public class FriendsListAdapter extends RecyclerView.Adapter<FriendsListAdapter.ViewHolder> {

    private List<User> users = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_friends_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (holder == null || position < 0 || position >= users.size()) {
            return;
        }

        User user = users.get(position);
        holder.bindViewHolder(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public void updateData(List<User> users) {
        this.users.clear();
        this.users.addAll(users);
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

        void bindViewHolder(User user) {
            title.setText(user.getAllName());

            String subtitleText = user.isOnline()
                    ? itemView.getContext().getString(R.string.fragment_friends_user_online)
                    : itemView.getContext().getString(R.string.fragment_friends_user_offline);
            subtitle.setText(subtitleText);

            Glide.with(itemView.getContext())
                    .load(user.getPhotoUrl())
                    .into(photoView);
        }
    }
}
