package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.GroupsQuery;

public class GroupsQueryParams extends BaseQueryParams {

    public GroupsQueryParams(@NonNull String accessToken, @NonNull String versionApi) {
        super(accessToken, versionApi);

        addParam(GroupsQuery.Key.EXTENDED, GroupsQuery.Value.EXTENDED);
        addParam(GroupsQuery.Key.FIELDS, GroupsQuery.Value.FIELDS);
    }

    public void setUserId(int userId) {
        addParam(GroupsQuery.Key.USER_ID, String.valueOf(userId));
    }

}
