package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CachKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity.GroupsServiceManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.RetrofitCallback;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.GroupsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

public class GroupsDataManager implements DataManager<Group> {

    @Override
    public void getData(@NonNull CallbackLoadData<Group> callbackLoadData) {
        boolean firstVisible = LocalCacheManager.getInstance()
                .getBoolean(CachKey.GroupsFragment.FIRST_VISIBLE, true);

        if (firstVisible) {
            callbackLoadData.onStartLoadData();

            GroupsQueryParams params = new GroupsQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
            params.setUserId(Constants.MOCK_USER_ID);

            new GroupsServiceManager(params)
                    .loadData(new RetrofitCallback<>(callbackLoadData));
        } else {
            // TODO: 26.06.18 Берем из кеша
        }
    }
}
