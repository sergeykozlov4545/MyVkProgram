package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.ServiceManager.RetrofitCallback;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity.VideosServiceManager;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.VideosQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

public class VideosDataManager implements DataManager<Video> {

    @Override
    public void getData(@NonNull CallbackLoadData<Video> callbackLoadData) {
        VideosQueryParams params = new VideosQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setOwnerId(Constants.MOCK_USER_ID);

        new VideosServiceManager(params)
                .loadData(new RetrofitCallback<>(callbackLoadData));
    }
}
