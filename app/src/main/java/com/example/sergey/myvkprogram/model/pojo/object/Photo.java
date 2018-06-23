package com.example.sergey.myvkprogram.model.pojo.object;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {

    @SerializedName("id")
    private long id;

    @SerializedName("date")
    private long date;

    @SerializedName("sizes")
    private List<PhotoSize> sizes;

    public long getId() {
        return id;
    }

    public long getDate() {
        return date;
    }

    public List<PhotoSize> getSizes() {
        return sizes;
    }
}
