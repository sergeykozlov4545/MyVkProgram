package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

public class FriendsQueryParams extends BaseQueryParams {

    public BaseQueryParams setAccessToken(String accessToken) {
        addParam("access_token", accessToken);
        return this;
    }

    public BaseQueryParams setVersionApi(String versionApi) {
        addParam("v", versionApi);
        return this;
    }

    public BaseQueryParams setOrder(String order) {
        addParam("order", order);
        return this;
    }

    public BaseQueryParams setFields(String fields) {
        addParam("fields", fields);
        return this;
    }
}
