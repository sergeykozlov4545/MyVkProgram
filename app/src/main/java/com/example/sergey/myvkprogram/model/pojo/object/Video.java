package com.example.sergey.myvkprogram.model.pojo.object;

import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("id")
    private long id;

    @SerializedName("title")
    private String title;

    @SerializedName("duration")
    private long duration;

    @SerializedName("photo_130")
    private String photoUrl;

    @SerializedName("views")
    private int views;

    @SerializedName("player")
    private String playerUrl;

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public long getDuration() {
        return duration;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public int getViews() {
        return views;
    }

    public String getPlayerUrl() {
        return playerUrl;
    }
}
