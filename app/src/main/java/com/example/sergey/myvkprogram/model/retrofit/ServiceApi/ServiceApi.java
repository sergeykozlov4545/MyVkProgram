package com.example.sergey.myvkprogram.model.retrofit.ServiceApi;

import com.example.sergey.myvkprogram.model.pojo.response.FriendsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.GroupsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.PhotosResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.pojo.response.VideosResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ServiceApi {

    @GET("photos.get")
    Call<ResponseImpl<PhotosResponse>> getPhotos(@QueryMap Map<String, String> params);

    @GET("video.get")
    Call<ResponseImpl<VideosResponse>> getVideos(@QueryMap Map<String, String> params);

    @GET("friends.get")
    Call<ResponseImpl<FriendsResponse>> getFriends(@QueryMap Map<String, String> params);

    @GET("groups.get")
    Call<ResponseImpl<GroupsResponse>> getGroups(@QueryMap Map<String, String> params);

}
