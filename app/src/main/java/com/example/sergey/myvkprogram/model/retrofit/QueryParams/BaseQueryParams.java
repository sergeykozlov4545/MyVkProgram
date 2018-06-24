package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;

import java.util.HashMap;
import java.util.Map;

public class BaseQueryParams implements QueryParams {

    private Map<String, String> params = new HashMap<>();

    public BaseQueryParams(@NonNull String accessToken, @NonNull String versionApi) {
        addParam(Constants.Url.Params.Key.ACCESS_TOKEN, accessToken);
        addParam(Constants.Url.Params.Key.VERSION_API, versionApi);
    }

    @NonNull
    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public void addParam(@NonNull String key, @Nullable String value) {
        this.params.put(key, value);
    }

    @Override
    public void addParams(@NonNull QueryParams queryParams) {
        this.params.putAll(queryParams.getParams());
    }

}
