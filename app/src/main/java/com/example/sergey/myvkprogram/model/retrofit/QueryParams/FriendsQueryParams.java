package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import android.support.annotation.NonNull;

public class FriendsQueryParams extends BaseQueryParams {

    public FriendsQueryParams setAccessToken(@NonNull String accessToken) {
        addParam("access_token", accessToken);
        return this;
    }

    public FriendsQueryParams setVersionApi(@NonNull String versionApi) {
        addParam("v", versionApi);
        return this;
    }

    public FriendsQueryParams setOrder(@NonNull String order) {
        addParam("order", order);
        return this;
    }

    public FriendsQueryParams setFields(@NonNull String fields) {
        addParam("fields", fields);
        return this;
    }

    public FriendsQueryParams setUserId(int userId) {
        addParam("user_ids", String.valueOf(userId));
        return this;
    }
}
