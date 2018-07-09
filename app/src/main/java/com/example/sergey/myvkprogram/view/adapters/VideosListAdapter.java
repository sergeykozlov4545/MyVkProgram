package com.example.sergey.myvkprogram.view.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.glide.GlideApp;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.view.utils.VideoDescriptionManager;
import com.example.sergey.myvkprogram.view.utils.VideoDescriptionManagerImpl;

import java.util.ArrayList;
import java.util.List;

public class VideosListAdapter
        extends RecyclerView.Adapter<VideosListAdapter.ViewHolder> {

    private List<Video> videos = new ArrayList<>();
    private VideoDescriptionManager videoDescriptionManager = new VideoDescriptionManagerImpl();

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_videos_item, parent, false);

        return new ViewHolder(view, videoDescriptionManager);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position >= videos.size()) {
            return;
        }

        holder.bindViewHolder(videos.get(position), position);
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void updateData(@NonNull List<Video> videos) {
        this.videos.clear();
        this.videos.addAll(videos);
        this.videoDescriptionManager.clear();
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView photoPreview;
        private TextView durationView;
        private TextView videoNameView;
        private TextView countViewsView;

        private LinearLayout descriptionContainerView;
        private TextView descriptionTextView;
        private LinearLayout descriptionIconContainerView;
        private TextView descriptionIconLabelView;
        private ImageView descriptionIconView;

        private ImageView likeIconView;
        private TextView countLikesView;

        private ImageView commentIconView;
        private TextView countCommentsView;

        private ImageView repostIconView;
        private TextView countRepostsView;

        private VideoDescriptionManager descriptionManager;

        ViewHolder(View itemView, @NonNull VideoDescriptionManager descriptionManager) {
            super(itemView);

            this.descriptionManager = descriptionManager;

            photoPreview = itemView.findViewById(R.id.photoPreview);
            durationView = itemView.findViewById(R.id.duration);
            videoNameView = itemView.findViewById(R.id.videoName);
            countViewsView = itemView.findViewById(R.id.countViews);

            descriptionContainerView = itemView.findViewById(R.id.descriptionContainer);
            descriptionTextView = itemView.findViewById(R.id.descriptionText);
            descriptionIconContainerView = itemView.findViewById(R.id.descriptionIconContainer);
            descriptionIconLabelView = itemView.findViewById(R.id.descriptionIconLabel);
            descriptionIconView = itemView.findViewById(R.id.descriptionIcon);

            likeIconView = itemView.findViewById(R.id.likeIcon);
            countLikesView = itemView.findViewById(R.id.countLikes);

            commentIconView = itemView.findViewById(R.id.commentIcon);
            countCommentsView = itemView.findViewById(R.id.countComments);

            repostIconView = itemView.findViewById(R.id.repostIcon);
            countRepostsView = itemView.findViewById(R.id.countReposts);
        }

        void bindViewHolder(@NonNull Video video, int position) {
            updatePhotoView(video);

            videoNameView.setText(video.getTitle());

            updateDescriptionBlock(video, position);
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

        private void updateDescriptionBlock(@NonNull Video video, int position) {
            if (TextUtils.isEmpty(video.getDescription())) {
                descriptionContainerView.setVisibility(View.GONE);
            } else {
                descriptionTextView.setText(video.getDescription());
                descriptionTextView.setVisibility(getDescriptionTextViewVisibility(position));

                updateDescriptionIconContainer(position);

                descriptionContainerView.setVisibility(View.VISIBLE);
            }
        }

        private int getDescriptionTextViewVisibility(int position) {
            return descriptionManager.isShowedDescription(position) ? View.VISIBLE : View.GONE;
        }

        private void updateDescriptionIconContainer(int position) {
            descriptionIconLabelView.setText(getDescriptionIconLabelText(position));
            descriptionIconView.setImageDrawable(getDescriptionIconDrawable(position));

            descriptionIconContainerView.setOnClickListener((v) -> {
                if (descriptionManager.isShowedDescription(position)) {
                    descriptionManager.removeShowedDescription(position);
                } else {
                    descriptionManager.addShowedDescription(position);
                }

                descriptionTextView.setVisibility(getDescriptionTextViewVisibility(position));
                updateDescriptionIconContainer(position);
            });
        }

        @StringRes
        private int getDescriptionIconLabelText(int position) {
            return descriptionManager.isShowedDescription(position)
                    ? R.string.fragment_videos_hide_description
                    : R.string.fragment_videos_show_description;
        }

        @Nullable
        private Drawable getDescriptionIconDrawable(int position) {
            int drawableRes = descriptionManager.isShowedDescription(position)
                    ? R.drawable.ic_arrow_drop_up_black_24dp
                    : R.drawable.ic_arrow_drop_down_black_24dp;

            return ContextCompat.getDrawable(itemView.getContext(), drawableRes);
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
