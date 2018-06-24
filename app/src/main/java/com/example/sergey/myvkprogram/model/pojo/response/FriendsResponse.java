package com.example.sergey.myvkprogram.model.pojo.response;

import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendsResponse implements Response<User> {

    @SerializedName("count")
    private int count;

    @SerializedName("items")
    private List<User> items;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public List<User> getItems() {
        return items;
    }
}
