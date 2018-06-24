package com.example.sergey.myvkprogram.model.pojo.response;

import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideosResponse implements Response<Video> {

    @SerializedName("count")
    private int count;

    @SerializedName("items")
    private List<Video> items;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public List<Video> getItems() {
        return items;
    }
}