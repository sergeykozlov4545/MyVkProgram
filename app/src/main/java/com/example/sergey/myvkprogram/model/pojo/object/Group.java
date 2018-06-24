package com.example.sergey.myvkprogram.model.pojo.object;

import com.google.gson.annotations.SerializedName;

public class Group {

    public static final String GROUP = "group";
    public static final String PAGE = "page";
    public static final String EVENT = "event";

    @SerializedName("id")
    private long id;

    @SerializedName("name")
    private String name;

    @SerializedName("type")
    private String type;

    @SerializedName("photo_100")
    private String photoUrl;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
