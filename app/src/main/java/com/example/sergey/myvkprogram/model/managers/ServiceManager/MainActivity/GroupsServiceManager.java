package com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.response.GroupsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceApi;

import retrofit2.Call;

public class GroupsServiceManager extends MainActivityServiceManager<GroupsResponse> {

    public GroupsServiceManager(@NonNull QueryParams params) {
        super(params);
    }

    @NonNull
    @Override
    public Call<ResponseImpl<GroupsResponse>> getResponseCall(@NonNull ServiceApi serviceApi) {
        return serviceApi.getGroups(getQueryParams().getParams());
    }

}
