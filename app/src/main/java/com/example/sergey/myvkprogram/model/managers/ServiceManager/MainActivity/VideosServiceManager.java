package com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.pojo.response.VideosResponse;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceApi;

import retrofit2.Call;

public class VideosServiceManager extends MainActivityServiceManager<VideosResponse> {

    public VideosServiceManager(@NonNull QueryParams params) {
        super(params);
    }

    @NonNull
    @Override
    public Call<ResponseImpl<VideosResponse>> getResponseCall(@NonNull ServiceApi serviceApi) {
        return serviceApi.getVideos(getQueryParams().getParams());
    }
}
