package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.ServiceManager.GroupsQueryServiceManager;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.model.pojo.response.GroupsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.GroupsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupsDataManager implements DataManager<Group> {

    @Override
    public void getData(@NonNull CallbackLoadData<Group> callbackLoadData) {
        GroupsQueryParams params = new GroupsQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setUserId(Constants.MOCK_USER_ID);

        GroupsQueryServiceManager serviceManager = new GroupsQueryServiceManager(params);
        serviceManager.loadData(new Callback<ResponseImpl<GroupsResponse>>() {
            @Override
            public void onResponse(Call<ResponseImpl<GroupsResponse>> call, Response<ResponseImpl<GroupsResponse>> response) {
                if (response.isSuccessful()) {
                    ResponseImpl<GroupsResponse> groupsResponse = response.body();
                    List<Group> groups = groupsResponse.getItems();

                    if (groups != null) {
                        callbackLoadData.onSuccessful(groups);
                    }
                } else {
                    callbackLoadData.onFailure("Произошла ошибка при выполнении запроса: code = " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ResponseImpl<GroupsResponse>> call, Throwable t) {
                callbackLoadData.onFailure("Произошла ошибка при выполнении запроса");
            }
        });

    }
}
