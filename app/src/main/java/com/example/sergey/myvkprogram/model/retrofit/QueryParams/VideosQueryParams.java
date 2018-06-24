package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.VideosQuery;

public class VideosQueryParams extends BaseQueryParams {

    public VideosQueryParams(@NonNull String accessToken, @NonNull String versionApi) {
        super(accessToken, versionApi);
    }

    public void setOwnerId(int ownerId) {
        addParam(VideosQuery.Key.OWNER_ID, String.valueOf(ownerId));
    }

}
