package com.example.sergey.myvkprogram.contracts;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public interface VideosFragmentContract {

    interface VideosFragmentView extends FragmentView {
        void showVideos(@NonNull List<Video> videos);

        void showError(@NonNull String message);
    }

    interface VideosFragmentPresenter extends Presenter<VideosFragmentView> {
        void videosLoaded(@NonNull List<Video> videos);

        void videosErrorLoaded(@NonNull String message);
    }

}
