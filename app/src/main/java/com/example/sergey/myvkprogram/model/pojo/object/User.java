package com.example.sergey.myvkprogram.model.pojo.object;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private long id;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("photo_50")
    private String photoUrl;

    @SerializedName("online")
    private int online;

    public User(String firstName, String lastName, String photoUrl, int online) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
        this.online = online;
    }

    public long getId() {
        return id;
    }

    public String getAllName() {
        return firstName + " " + lastName;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public boolean isOnline() {
        return online == 1;
    }

}
