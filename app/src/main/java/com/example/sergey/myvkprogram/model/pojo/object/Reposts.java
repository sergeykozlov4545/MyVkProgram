package com.example.sergey.myvkprogram.model.pojo.object;

import com.google.gson.annotations.SerializedName;

public class Reposts {

    @SerializedName("user_reposted")
    private int userReposted;

    @SerializedName("count")
    private int count;

    public boolean isUserReposted() {
        return userReposted == 1;
    }

    public int getCount() {
        return count;
    }

}
