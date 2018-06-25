package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.ServiceManager.FriendsQueryServiceManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.RetrofitCallback;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.FriendsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

public class FriendsDataManager implements DataManager<User> {

    @Override
    public void getData(@NonNull CallbackLoadData<User> callbackLoadData) {
        FriendsQueryParams params = new FriendsQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setUserId(Constants.MOCK_USER_ID);

        new FriendsQueryServiceManager(params)
                .loadData(new RetrofitCallback<>(callbackLoadData));
    }
}
