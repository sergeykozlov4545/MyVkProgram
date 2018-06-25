package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CachKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity.FriendsServiceManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.RetrofitCallback;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.FriendsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

public class FriendsDataManager implements DataManager<User> {

    @Override
    public void getData(@NonNull CallbackLoadData<User> callbackLoadData) {
        boolean firstVisible = LocalCacheManager.getInstance()
                .getBoolean(CachKey.FriendsFragment.FIRST_VISIBLE, true);

        if (firstVisible) {
            callbackLoadData.onStartLoadData();

            FriendsQueryParams params = new FriendsQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
            params.setUserId(Constants.MOCK_USER_ID);

            new FriendsServiceManager(params)
                    .loadData(new RetrofitCallback<>(callbackLoadData));
        } else {
            // TODO: 26.06.18 Берем из кеша
        }
    }
}
