package com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.response.FriendsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceApi;

import retrofit2.Call;

public class FriendsServiceManager extends MainActivityServiceManager<FriendsResponse> {

    public FriendsServiceManager(@NonNull QueryParams params) {
        super(params);
    }

    @NonNull
    @Override
    public Call<ResponseImpl<FriendsResponse>> getResponseCall(@NonNull ServiceApi serviceApi) {
        return serviceApi.getFriends(getQueryParams().getParams());
    }

}
