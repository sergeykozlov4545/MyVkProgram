package com.example.sergey.myvkprogram.model.pojo.object;

import android.support.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

public class PhotoSize {

    @SerializedName("type")
    private String type;

    @SerializedName("url")
    private String url;

    @SerializedName("width")
    private int width;

    @SerializedName("height")
    private int height;

    @Nullable
    public String getType() {
        return type;
    }

    @Nullable
    public String getUrl() {
        return url;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
