package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.VideosFragmentContract;
import com.example.sergey.myvkprogram.model.managers.CacheManager.CachKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

import java.util.List;

public class VideosFragmentPresenterImpl
        extends BasePresenter<VideosFragmentContract.VideosFragmentView>
        implements VideosFragmentContract.VideosFragmentPresenter {

    private DataManager<Video> dataManager;

    public VideosFragmentPresenterImpl(@NonNull DataManager<Video> dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void viewIsReady() {
        loadData();
    }

    @Override
    public void videosLoaded(@NonNull List<Video> videos) {
        VideosFragmentContract.VideosFragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showVideos(videos);
        }
    }

    @Override
    public void videosErrorLoaded(@NonNull String message) {
        VideosFragmentContract.VideosFragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showError(message);
        }
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
                        .put(CachKey.VideosFragment.FIRST_VISIBLE, Boolean.FALSE);
                // TODO: 26.06.18 Сохраняем в кэш

                videosLoaded(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                videosErrorLoaded(message);
            }
        });
    }
}
