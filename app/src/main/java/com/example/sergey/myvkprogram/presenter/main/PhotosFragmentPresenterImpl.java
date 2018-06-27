package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.PhotosFragmentContract;
import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

import java.util.List;

public class PhotosFragmentPresenterImpl
        extends BasePresenter<PhotosFragmentContract.PhotosFragmentView>
        implements PhotosFragmentContract.PhotosFragmentPresenter {

    private DataManager<Photo> dataManager;

    public PhotosFragmentPresenterImpl(@NonNull DataManager<Photo> dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void viewIsReady() {
        if (getView() != null) {
            getView().showProgress();
        }

        dataManager.getData(new CallbackLoadData<Photo>() {
            @Override
            public void onSuccessful(@NonNull List<Photo> data) {
                photosLoaded(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                photosErrorLoaded(message);
            }
        });
    }

    @Override
    public void photosLoaded(@NonNull List<Photo> photos) {
        PhotosFragmentContract.PhotosFragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showPhotos(photos);
        }
    }

    @Override
    public void photosErrorLoaded(@NonNull String message) {
        PhotosFragmentContract.PhotosFragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showError(message);
        }
    }
}
