package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheObject;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity.FriendsServiceManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.RetrofitCallback;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.FriendsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

import java.util.List;

public class FriendsDataManager implements DataManager<User> {

    @Override
    public void getData(@NonNull CallbackLoadData<User> callbackLoadData) {
        CacheObject<Boolean> cacheObject =
                LocalCacheManager.getInstance()
                        .get(CacheKey.FriendsFragment.FIRST_VISIBLE);

        if (!cacheObject.is(Boolean.class)) {
            loadData(callbackLoadData);
        } else {
            CacheObject<List<User>> dataCacheObject =
                    LocalCacheManager.getInstance()
                            .get(CacheKey.FriendsFragment.ITEMS_DATA);

            if (!dataCacheObject.is(List.class)) {
                loadData(callbackLoadData);
            } else {
                callbackLoadData.onSuccessful(dataCacheObject.getValue());
            }
        }
    }

    @Override
    public void loadData(@NonNull CallbackLoadData<User> callbackLoadData) {
        callbackLoadData.onStartLoadData();

        FriendsQueryParams params = new FriendsQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setUserId(Constants.MOCK_USER_ID);

        new FriendsServiceManager(params)
                .loadData(new RetrofitCallback<>(callbackLoadData));
    }
}
