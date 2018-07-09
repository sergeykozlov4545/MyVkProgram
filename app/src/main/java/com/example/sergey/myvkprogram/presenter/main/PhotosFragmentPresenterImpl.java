package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.presenter.base.BaseFragmentPresenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public class PhotosFragmentPresenterImpl
        extends BaseFragmentPresenter<FragmentView<Photo>, Photo> {

    private DataManager<Photo> dataManager;

    public PhotosFragmentPresenterImpl(@NonNull DataManager<Photo> dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void viewIsReady() {
        loadData();
    }

    private void loadData() {
        dataManager.getData(new CallbackLoadData<Photo>() {
            @Override
            public void onStartLoadData() {
                if (getView() != null) {
                    getView().showProgress();
                }
            }

            @Override
            public void onSuccessful(@NonNull List<Photo> data) {
                LocalCacheManager.getInstance()
                        .put(CacheKey.PhotosFragment.FIRST_VISIBLE, Boolean.FALSE);
                LocalCacheManager.getInstance()
                        .put(CacheKey.PhotosFragment.ITEMS_DATA, data);

                successLoadData(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                failureLoadData(message);
            }
        });
    }
}
