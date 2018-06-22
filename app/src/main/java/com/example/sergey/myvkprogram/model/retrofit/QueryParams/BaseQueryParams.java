package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import java.util.HashMap;
import java.util.Map;

public class BaseQueryParams implements QueryParams {

    private Map<String, String> params = new HashMap<>();

    @Override
    public Map<String, String> getParams() {
        return params;
    }

    @Override
    public void addParam(@NonNull String key, @Nullable String value) {
        this.params.put(key, value);
    }

    @Override
    public void addParams(QueryParams queryParams) {
        this.params.putAll(queryParams.getParams());
    }

}
