package com.example.sergey.myvkprogram.model.pojo;

import com.google.gson.annotations.SerializedName;

public class CountersResponse {

    @SerializedName("albums")
    private int albums;
    @SerializedName("videos")
    private int videos;
    @SerializedName("audios")
    private int audios;
    @SerializedName("photos")
    private int photos;
    @SerializedName("groups")
    private int groups;
    @SerializedName("friends")
    private int friends;

    public int getAlbums() {
        return albums;
    }

    public int getVideos() {
        return videos;
    }

    public int getAudios() {
        return audios;
    }

    public int getPhotos() {
        return photos;
    }

    public int getGroups() {
        return groups;
    }

    public int getFriends() {
        return friends;
    }
}
