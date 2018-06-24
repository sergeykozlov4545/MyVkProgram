package com.example.sergey.myvkprogram.model.pojo.response;

import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupsResponse implements Response<Group> {

    @SerializedName("count")
    private int count;

    @SerializedName("items")
    private List<Group> items;

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public List<Group> getItems() {
        return items;
    }
}