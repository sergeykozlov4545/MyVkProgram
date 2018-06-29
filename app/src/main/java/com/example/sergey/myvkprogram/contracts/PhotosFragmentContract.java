package com.example.sergey.myvkprogram.contracts;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public interface PhotosFragmentContract {

    interface PhotosFragmentView extends FragmentView {
        void showPhotos(@NonNull List<Photo> photos);

        void showError(@NonNull String message);
    }

    interface PhotosFragmentPresenter extends Presenter<PhotosFragmentView> {
        void photosLoaded(@NonNull List<Photo> photos);

        void photosErrorLoaded(@NonNull String message);
    }

}
