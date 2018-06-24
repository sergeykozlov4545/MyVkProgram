package com.example.sergey.myvkprogram.model.pojo.object;

import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("duration")
    private long duration;

    @SerializedName("photo_320")
    private String smallPhotoUrl;

    @SerializedName("photo_640")
    private String middlePhotoUrl;

    @SerializedName("photo_800")
    private String bigPhotoUrl;

    @SerializedName("views")
    private int views;

    @SerializedName("player")
    private String playerUrl;

    @SerializedName("likes")
    private Likes likes;

    @SerializedName("comments")
    private int countComments;

    @SerializedName("reposts")
    private Reposts reposts;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getDuration() {
        return duration;
    }

    public String getSmallPhotoUrl() {
        return smallPhotoUrl;
    }

    public String getMiddlePhotoUrl() {
        return middlePhotoUrl;
    }

    public String getBigPhotoUrl() {
        return bigPhotoUrl;
    }

    public int getViews() {
        return views;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }

    public Likes getLikes() {
        return likes;
    }

    public int getCountComments() {
        return countComments;
    }

    public Reposts getReposts() {
        return reposts;
    }
}
