package com.example.sergey.myvkprogram.presenter.base;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public abstract class BaseFragmentPresenter<View extends FragmentView, Data>
        extends BasePresenter<View> implements FragmentPresenter<View, Data> {

    private DataManager<Data> dataManager;

    public BaseFragmentPresenter(DataManager<Data> dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void viewIsReady() {
        loadData(false);
    }

    @Override
    public void successLoadData(@NonNull List<Data> data) {
        FragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showData(data);
        }
    }

    @Override
    public void failureLoadData(@NonNull String message) {
        FragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showError(message);
        }
    }

    @Override
    public void refreshedData() {
        loadData(true);
    }

    @NonNull
    protected abstract String getFirstLoadKey();

    @NonNull
    protected abstract String getDataKey();

    private void loadData(boolean isReload) {
        if (isReload) {
            LocalCacheManager.getInstance()
                    .put(getFirstLoadKey(), Boolean.TRUE);
            LocalCacheManager.getInstance()
                    .put(getDataKey(), null);
        }

        dataManager.getData(new CallbackLoadData<Data>() {
            @Override
            public void onStartLoadData() {
                if (!isReload && getView() != null) {
                    getView().showProgress();
                }
            }

            @Override
            public void onSuccessful(@NonNull List<Data> data) {
                LocalCacheManager.getInstance()
                        .put(getFirstLoadKey(), Boolean.FALSE);
                LocalCacheManager.getInstance()
                        .put(getDataKey(), data);

                successLoadData(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                failureLoadData(message);
            }
        });
    }
}
