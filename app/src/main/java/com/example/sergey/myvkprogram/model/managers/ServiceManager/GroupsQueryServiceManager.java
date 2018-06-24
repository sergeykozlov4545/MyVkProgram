package com.example.sergey.myvkprogram.model.managers.ServiceManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.response.GroupsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;

public class GroupsQueryServiceManager extends ServiceManagerImpl {

    private QueryParams params;

    public GroupsQueryServiceManager(@NonNull QueryParams params) {
        this.params = params;
    }

    public void loadData(Callback<ResponseImpl<GroupsResponse>> callback) {
        ServiceApi service = createService(ServiceApi.class, Constants.Url.BASE_URL);
        Call<ResponseImpl<GroupsResponse>> GroupsResponseCall = service.getGroups(params.getParams());
        GroupsResponseCall.enqueue(callback);
    }
}
