package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.presenter.base.BaseFragmentPresenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public class VideosFragmentPresenterImpl
        extends BaseFragmentPresenter<FragmentView<Video>, Video> {

    private DataManager<Video> dataManager;

    public VideosFragmentPresenterImpl(@NonNull DataManager<Video> dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void viewIsReady() {
        loadData();
    }

    private void loadData() {
        dataManager.getData(new CallbackLoadData<Video>() {
            @Override
            public void onStartLoadData() {
                if (getView() != null) {
                    getView().showProgress();
                }
            }

            @Override
            public void onSuccessful(@NonNull List<Video> data) {
                LocalCacheManager.getInstance()
                        .put(CacheKey.VideosFragment.FIRST_VISIBLE, Boolean.FALSE);
                LocalCacheManager.getInstance()
                        .put(CacheKey.VideosFragment.ITEMS_DATA, data);

                successLoadData(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                failureLoadData(message);
            }
        });
    }
}
