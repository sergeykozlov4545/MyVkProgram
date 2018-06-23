package com.example.sergey.myvkprogram.model.pojo.object;

import com.google.gson.annotations.SerializedName;

public class Group {

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("sreen_name")
    private String sreen_name;

    @SerializedName("photo_100")
    private String photoUrl;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSreen_name() {
        return sreen_name;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
