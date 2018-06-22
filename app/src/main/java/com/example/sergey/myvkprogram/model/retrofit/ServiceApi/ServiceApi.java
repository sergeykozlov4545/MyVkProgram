package com.example.sergey.myvkprogram.model.retrofit.ServiceApi;

import com.example.sergey.myvkprogram.model.pojo.FriendsResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ServiceApi {

    @GET("friends.get")
    Call<FriendsResponse> getFriends(@QueryMap Map<String, String> params);

}
