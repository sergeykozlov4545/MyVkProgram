package com.example.sergey.myvkprogram.model.managers.ServiceManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.response.FriendsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;

public class FriendsQueryServiceManager extends ServiceManagerImpl {

    private QueryParams params;

    public FriendsQueryServiceManager(@NonNull QueryParams params) {
        this.params = params;
    }

    public void loadData(Callback<ResponseImpl<FriendsResponse>> callback) {
        ServiceApi service = createService(ServiceApi.class, Constants.Url.BASE_URL);
        Call<ResponseImpl<FriendsResponse>> friendsResponseCall = service.getFriends(params.getParams());
        friendsResponseCall.enqueue(callback);
    }
}
