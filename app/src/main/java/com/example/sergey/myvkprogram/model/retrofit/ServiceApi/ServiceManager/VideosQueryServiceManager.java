package com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.response.VideosResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;

public class VideosQueryServiceManager extends ServiceManagerImpl {

    private QueryParams params;

    public VideosQueryServiceManager(@NonNull QueryParams params) {
        this.params = params;
    }

    public void loadData(Callback<ResponseImpl<VideosResponse>> callback) {
        ServiceApi service = createService(ServiceApi.class, Constants.Url.BASE_URL);
        Call<ResponseImpl<VideosResponse>> VideosResponseCall = service.getVideos(params.getParams());
        VideosResponseCall.enqueue(callback);
    }
}
