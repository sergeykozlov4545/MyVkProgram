package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.presenter.base.BaseFragmentPresenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public class PhotosFragmentPresenter
        extends BaseFragmentPresenter<FragmentView<Photo>, Photo> {

    public PhotosFragmentPresenter(@NonNull DataManager<Photo> dataManager) {
        super(dataManager);
    }

    @NonNull
    @Override
    protected String getFirstLoadKey() {
        return CacheKey.PhotosFragment.FIRST_VISIBLE;
    }

    @NonNull
    @Override
    protected String getDataKey() {
        return CacheKey.PhotosFragment.ITEMS_DATA;
    }
}
