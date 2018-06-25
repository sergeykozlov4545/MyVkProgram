package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.VideosFragmentContract;
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
        if (getView() != null) {
            getView().showProgress();
        }

        dataManager.getData(new CallbackLoadData<Video>() {
            @Override
            public void onSuccessful(@NonNull List<Video> data) {
                videosLoaded(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                videosErrorLoaded(message);
            }
        });
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
}
