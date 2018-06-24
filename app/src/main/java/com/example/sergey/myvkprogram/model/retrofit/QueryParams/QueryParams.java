package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Map;

public interface QueryParams {

    @NonNull
    Map<String, String> getParams();

    void addParam(@NonNull String key, @Nullable String value);

    void addParams(@NonNull QueryParams queryParams);

}
