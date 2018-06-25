package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.ServiceManager.MainActivity.PhotosServiceManager;
import com.example.sergey.myvkprogram.model.managers.ServiceManager.RetrofitCallback;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.PhotosQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.PhotosQuery;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants.Url.Params.Value;

public class PhotosDataManager implements DataManager<Photo> {

    @Override
    public void getData(@NonNull CallbackLoadData<Photo> callbackLoadData) {

        PhotosQueryParams params = new PhotosQueryParams(Value.ACCESS_TOKEN, Value.VERSION_API);
        params.setOwnerId(Constants.MOCK_USER_ID);
        params.setAlbumType(PhotosQuery.Value.ALBUM_PROFILE);

        new PhotosServiceManager(params)
                .loadData(new RetrofitCallback<>(callbackLoadData));
    }
}
