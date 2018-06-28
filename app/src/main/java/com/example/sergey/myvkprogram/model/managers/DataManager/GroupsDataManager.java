package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheObject;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity.GroupsServiceManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.RetrofitCallback;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.GroupsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

import java.util.List;

public class GroupsDataManager implements DataManager<Group> {

    @Override
    public void getData(@NonNull CallbackLoadData<Group> callbackLoadData) {
        CacheObject<Boolean> cacheObject =
                LocalCacheManager.getInstance()
                        .get(CacheKey.GroupsFragment.FIRST_VISIBLE);

        if (!cacheObject.is(Boolean.class)) {
            loadData(callbackLoadData);
        } else {
            CacheObject<List<Group>> dataCacheObject =
                    LocalCacheManager.getInstance()
                            .get(CacheKey.GroupsFragment.ITEMS_DATA);

            if (!dataCacheObject.is(List.class)) {
                loadData(callbackLoadData);
            } else {
                callbackLoadData.onSuccessful(dataCacheObject.getValue());
            }
        }
    }

    @Override
    public void loadData(@NonNull CallbackLoadData<Group> callbackLoadData) {
        callbackLoadData.onStartLoadData();

        GroupsQueryParams params = new GroupsQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setUserId(Constants.MOCK_USER_ID);

        new GroupsServiceManager(params)
                .loadData(new RetrofitCallback<>(callbackLoadData));
    }
}
