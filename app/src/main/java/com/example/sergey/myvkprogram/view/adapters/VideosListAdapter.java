package com.example.sergey.myvkprogram.view.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.glide.GlideApp;
import com.example.sergey.myvkprogram.model.pojo.object.Video;

import java.util.ArrayList;
import java.util.List;

public class VideosListAdapter extends RecyclerView.Adapter<VideosListAdapter.ViewHolder> {

    private List<Video> videos = new ArrayList<>();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_videos_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position >= videos.size()) {
            return;
        }

        holder.bindViewHolder(videos.get(position));
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void updateData(@NonNull List<Video> videos) {
        this.videos.clear();
        this.videos.addAll(videos);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView photoPreview;
        private TextView durationView;
        private TextView videoNameView;
        private TextView countViewsView;

        private ImageView likeIconView;
        private TextView countLikesView;

        private ImageView commentIconView;
        private TextView countCommentsView;

        private ImageView repostIconView;
        private TextView countRepostsView;

        ViewHolder(View itemView) {
            super(itemView);

            photoPreview = itemView.findViewById(R.id.photoPreview);
            durationView = itemView.findViewById(R.id.duration);
            videoNameView = itemView.findViewById(R.id.videoName);
            countViewsView = itemView.findViewById(R.id.countViews);

            likeIconView = itemView.findViewById(R.id.likeIcon);
            countLikesView = itemView.findViewById(R.id.countLikes);

            commentIconView = itemView.findViewById(R.id.commentIcon);
            countCommentsView = itemView.findViewById(R.id.countComments);

            repostIconView = itemView.findViewById(R.id.repostIcon);
            countRepostsView = itemView.findViewById(R.id.countReposts);
        }

        void bindViewHolder(@NonNull Video video) {
            updatePhotoView(video);

            videoNameView.setText(video.getTitle());

            updateCountersBlock(video);
        }

        private void updatePhotoView(@NonNull Video video) {
            String photoUrl = null;
            if (!TextUtils.isEmpty(video.getBigPhotoUrl())) {
                photoUrl = video.getBigPhotoUrl();
            } else if (!TextUtils.isEmpty(video.getMiddlePhotoUrl())) {
                photoUrl = video.getMiddlePhotoUrl();
            } else if (!TextUtils.isEmpty(video.getSmallPhotoUrl())) {
                photoUrl = video.getSmallPhotoUrl();
            }
            if (!TextUtils.isEmpty(photoUrl)) {
                GlideApp.with(itemView.getContext())
                        .load(photoUrl)
                        .placeholder(R.drawable.ic_placeholder_black)
                        .into(photoPreview);
            }

            durationView.setText(getDurationString(video.getDuration()));
        }

        @NonNull
        private String getDurationString(long duration) {
            int hours = (int) (duration / 3600);
            int minutes = (int) (duration % 3600 / 60);
            int seconds = (int) (duration % 3600 % 60);

            if (hours == 0 && minutes == 0 && seconds == 0) {
                return "";
            }

            String hoursString = String.valueOf(hours);

            String minutesString = String.valueOf(minutes);
            if (hours > 0 && minutes < 10) {
                minutesString = "0" + String.valueOf(minutes);
            }

            String secondsString = String.valueOf(seconds);
            if (seconds < 10) {
                secondsString = "0" + String.valueOf(seconds);
            }

            Context context = itemView.getContext();

            return (hours != 0)
                    ? context.getString(R.string.hour_minute_second, hoursString, minutesString, secondsString)
                    : context.getString(R.string.minute_second, minutesString, secondsString);
        }

        private void updateCountersBlock(@NonNull Video video) {
            Context context = itemView.getContext();

            countViewsView.setText(
                    context.getString(R.string.fragment_videos_views,
                            String.valueOf(video.getViews())));

            int countLikesDrawable = (video.getLikes().isUserLike())
                    ? R.drawable.ic_favorite_red_24dp
                    : R.drawable.ic_favorite_black_24dp;
            likeIconView.setImageDrawable(ContextCompat.getDrawable(context, countLikesDrawable));
            countLikesView.setText(String.valueOf(video.getLikes().getCount()));

            commentIconView.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_comment_black_24dp));
            countCommentsView.setText(String.valueOf(video.getCountComments()));

            int countRepostDrawable = (video.getReposts().isUserReposted())
                    ? R.drawable.ic_bullhorn_blue_24dp
                    : R.drawable.ic_bullhorn_black_24dp;
            repostIconView.setImageDrawable(ContextCompat.getDrawable(context, countRepostDrawable));
            countRepostsView.setText(String.valueOf(video.getReposts().getCount()));
        }

    }

}
