package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.ServiceManager.FriendsQueryServiceManager;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.model.pojo.response.FriendsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.FriendsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsDataManager implements DataManager<User> {

    @Override
    public void getData(@NonNull CallbackLoadData<User> callbackLoadData) {
        FriendsQueryParams params = new FriendsQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setUserId(Constants.MOCK_USER_ID);

        FriendsQueryServiceManager serviceManager = new FriendsQueryServiceManager(params);
        serviceManager.loadData(new Callback<ResponseImpl<FriendsResponse>>() {
            @Override
            public void onResponse(Call<ResponseImpl<FriendsResponse>> call, Response<ResponseImpl<FriendsResponse>> response) {
                if (response.isSuccessful()) {
                    ResponseImpl<FriendsResponse> friendsResponse = response.body();
                    List<User> friends = friendsResponse.getItems();

                    if (friends != null) {
                        callbackLoadData.onSuccessful(friends);
                    }
                } else {
                    callbackLoadData.onFailure("Произошла ошибка при выполнении запроса: code = " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseImpl<FriendsResponse>> call, Throwable t) {
                callbackLoadData.onFailure("Произошла ошибка при выполнении запроса");
            }
        });

    }
}
