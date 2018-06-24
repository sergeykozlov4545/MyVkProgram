package com.example.sergey.myvkprogram.model.pojo.object;

import com.google.gson.annotations.SerializedName;

public class Likes {

    @SerializedName("user_likes")
    private int userLikes;

    @SerializedName("count")
    private int count;

    public boolean isUserLike() {
        return userLikes == 1;
    }

    public int getCount() {
        return count;
    }
}
