package com.example.sergey.myvkprogram.model.pojo.response;

import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotosResponse implements Response<Photo> {

    @SerializedName("count")
    private int count;

    @SerializedName("items")
    private List<Photo> items;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public List<Photo> getItems() {
        return items;
    }
}
