package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.FriendsFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.User;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.FriendsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.FriendsQueryServiceManager;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

import java.util.List;

public class FriendsFragmentPresenterImpl
        extends BasePresenter<FriendsFragmentContract.FriendsFragmentView>
        implements FriendsFragmentContract.FriendsFragmentPresenter {

    private FriendsQueryServiceManager serviceManager;

    public FriendsFragmentPresenterImpl(FriendsQueryServiceManager serviceManager) {
        this.serviceManager = serviceManager;
    }

    @Override
    public void viewIsReady() {
        if (getView() != null) {
            getView().showProgress();
        }

        serviceManager.loadData(this);
    }

    @Override
    public void friendsLoaded(@NonNull List<User> users) {
        FriendsFragmentContract.FriendsFragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showFriends(users);
        }
    }

    @Override
    public void friendsErrorLoaded(@NonNull String message) {
        FriendsFragmentContract.FriendsFragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showError(message);
        }
    }
}
