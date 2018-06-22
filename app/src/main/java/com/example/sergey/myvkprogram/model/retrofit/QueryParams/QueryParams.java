package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import java.util.Map;

public interface QueryParams {

    Map<String, String> getParams();

    void addParam(String key, String value);

    void addParams(QueryParams queryParams);

    String buildParamsString();
}
