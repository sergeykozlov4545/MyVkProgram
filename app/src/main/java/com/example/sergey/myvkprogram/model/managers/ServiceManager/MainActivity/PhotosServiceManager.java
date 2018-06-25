package com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.response.PhotosResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceApi;

import retrofit2.Call;

public class PhotosServiceManager extends MainActivityServiceManager<PhotosResponse> {

    public PhotosServiceManager(@NonNull QueryParams params) {
        super(params);
    }

    @NonNull
    @Override
    public Call<ResponseImpl<PhotosResponse>> getResponseCall(@NonNull ServiceApi serviceApi) {
        return serviceApi.getPhotos(getQueryParams().getParams());
    }
}
