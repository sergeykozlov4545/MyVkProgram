package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.VideosFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.object.Video;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.pojo.response.VideosResponse;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceManager.VideosQueryServiceManager;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VideosFragmentPresenterImpl
        extends BasePresenter<VideosFragmentContract.VideosFragmentView>
        implements VideosFragmentContract.VideosFragmentPresenter {

    private VideosQueryServiceManager serviceManager;

    public VideosFragmentPresenterImpl(VideosQueryServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    @Override
    public void viewIsReady() {
        if (getView() != null) {
            getView().showProgress();
        }

        serviceManager.loadData(new ServiceManagerCallback());
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

    private class ServiceManagerCallback implements Callback<ResponseImpl<VideosResponse>> {

        @Override
        public void onResponse(Call<ResponseImpl<VideosResponse>> call, Response<ResponseImpl<VideosResponse>> response) {
            if (response.isSuccessful()) {
                ResponseImpl<VideosResponse> videosResponse = response.body();
                List<Video> videos = videosResponse.getItems();

                if (videos != null) {
                    videosLoaded(videos);
                }
            } else {
                videosErrorLoaded("Произошла ошибка при выполнении запроса: code = " + response.code());
            }
        }

        @Override
        public void onFailure(Call<ResponseImpl<VideosResponse>> call, Throwable t) {
            videosErrorLoaded("Произошла ошибка при выполнении запроса");
        }
    }
}
