package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.FriendsQuery;

public class FriendsQueryParams extends BaseQueryParams {

    public FriendsQueryParams(@NonNull String accessToken, @NonNull String versionApi) {
        super(accessToken, versionApi);

        addParam(FriendsQuery.Key.ORDER, FriendsQuery.Value.ORDER);
        addParam(FriendsQuery.Key.FIELDS, FriendsQuery.Value.FIELDS);
    }

    public void setUserId(int userId) {
        addParam(FriendsQuery.Key.USER_ID, String.valueOf(userId));
    }

}
