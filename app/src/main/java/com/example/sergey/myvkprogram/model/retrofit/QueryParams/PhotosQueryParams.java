package com.example.sergey.myvkprogram.model.retrofit.QueryParams;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.PhotosQuery;

public class PhotosQueryParams extends BaseQueryParams {

    public PhotosQueryParams(@NonNull String accessToken, @NonNull String versionApi) {
        super(accessToken, versionApi);

        addParam(PhotosQuery.Key.ORDER, PhotosQuery.Value.ORDER);
    }

    public void setOwnerId(int ownerId) {
        addParam(PhotosQuery.Key.OWNER_ID, String.valueOf(ownerId));
    }

    public void setAlbumType(@NonNull String albumType) {
        addParam(PhotosQuery.Key.ALBUM_ID, albumType);
    }

}
