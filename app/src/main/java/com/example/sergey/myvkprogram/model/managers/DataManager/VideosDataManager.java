package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.ServiceManager.VideosQueryServiceManager;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.pojo.response.VideosResponse;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.VideosQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosDataManager implements DataManager<Video> {

    @Override
    public void getData(@NonNull CallbackLoadData<Video> callbackLoadData) {
        VideosQueryParams params = new VideosQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setOwnerId(Constants.MOCK_USER_ID);

        VideosQueryServiceManager serviceManager = new VideosQueryServiceManager(params);
        serviceManager.loadData(new Callback<ResponseImpl<VideosResponse>>() {
            @Override
            public void onResponse(Call<ResponseImpl<VideosResponse>> call, Response<ResponseImpl<VideosResponse>> response) {
                if (response.isSuccessful()) {
                    ResponseImpl<VideosResponse> videosResponse = response.body();
                    List<Video> videos = videosResponse.getItems();

                    if (videos != null) {
                        callbackLoadData.onSuccessful(videos);
                    }
                } else {
                    callbackLoadData.onFailure("Произошла ошибка при выполнении запроса: code = " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseImpl<VideosResponse>> call, Throwable t) {
                callbackLoadData.onFailure("Произошла ошибка при выполнении запроса");
            }
        });

    }
}
