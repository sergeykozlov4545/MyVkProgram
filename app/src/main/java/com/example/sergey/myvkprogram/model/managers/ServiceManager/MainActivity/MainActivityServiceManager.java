package com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.ServiceManager.ServiceManagerImpl;
import com.example.sergey.myvkprogram.model.pojo.response.Response;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceApi;

import retrofit2.Call;
import retrofit2.Callback;

public abstract class MainActivityServiceManager<T extends Response> extends ServiceManagerImpl {

    private QueryParams params;

    MainActivityServiceManager(@NonNull QueryParams params) {
        this.params = params;
    }

    @NonNull
    QueryParams getQueryParams() {
        return params;
    }

    public void loadData(@NonNull Callback<ResponseImpl<T>> callback) {
        ServiceApi serviceApi = createService(ServiceApi.class, Constants.Url.BASE_URL);
        Call<ResponseImpl<T>> responseCall = getResponseCall(serviceApi);
        responseCall.enqueue(callback);
    }

    @NonNull
    public abstract Call<ResponseImpl<T>> getResponseCall(@NonNull ServiceApi serviceApi);
}
