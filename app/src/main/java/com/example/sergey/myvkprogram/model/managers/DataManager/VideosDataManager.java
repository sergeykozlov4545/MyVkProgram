package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheObject;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity.VideosServiceManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.RetrofitCallback;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.VideosQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

import java.util.List;

public class VideosDataManager implements DataManager<Video> {

    @Override
    public void getData(@NonNull CallbackLoadData<Video> callbackLoadData) {
        CacheObject<Boolean> cacheObject =
                LocalCacheManager.getInstance()
                        .get(CacheKey.VideosFragment.FIRST_VISIBLE);

        if (!cacheObject.is(Boolean.class)) {
            loadData(callbackLoadData);
        } else {
            CacheObject<List<Video>> dataCacheObject =
                    LocalCacheManager.getInstance()
                            .get(CacheKey.VideosFragment.ITEMS_DATA);

            if (!dataCacheObject.is(List.class)) {
                loadData(callbackLoadData);
            } else {
                callbackLoadData.onSuccessful(dataCacheObject.getValue());
            }
        }
    }

    @Override
    public void loadData(@NonNull CallbackLoadData<Video> callbackLoadData) {
        callbackLoadData.onStartLoadData();

        VideosQueryParams params = new VideosQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setOwnerId(Constants.MOCK_USER_ID);

        new VideosServiceManager(params)
                .loadData(new RetrofitCallback<>(callbackLoadData));
    }
}
