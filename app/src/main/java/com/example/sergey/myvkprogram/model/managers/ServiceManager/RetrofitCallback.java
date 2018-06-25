package com.example.sergey.myvkprogram.model.managers.ServiceManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.pojo.response.Response;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class RetrofitCallback<T extends Response, R> implements Callback<ResponseImpl<T>> {

    private CallbackLoadData<R> callbackLoadData;

    public RetrofitCallback(@NonNull CallbackLoadData<R> callbackLoadData) {
        this.callbackLoadData = callbackLoadData;
    }

    @Override
    public void onResponse(Call<ResponseImpl<T>> call, retrofit2.Response<ResponseImpl<T>> response) {
        if (!response.isSuccessful()) {
            callbackLoadData.onFailure("Произошла ошибка при выполнении запроса: code = " + response.code());
            return;
        }

        ResponseImpl<T> body = response.body();
        List<R> items = body.getItems();
        if (items != null) {
            callbackLoadData.onSuccessful(items);
        }
    }

    @Override
    public void onFailure(Call<ResponseImpl<T>> call, Throwable t) {
        callbackLoadData.onFailure("Произошла ошибка при выполнении запроса");
    }
}
