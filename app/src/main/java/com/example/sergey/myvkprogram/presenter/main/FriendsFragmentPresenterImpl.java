package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.FriendsFragmentContract;
import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

import java.util.List;

public class FriendsFragmentPresenterImpl
        extends BasePresenter<FriendsFragmentContract.FriendsFragmentView>
        implements FriendsFragmentContract.FriendsFragmentPresenter {

    private DataManager<User> dataManager;

    public FriendsFragmentPresenterImpl(@NonNull DataManager<User> dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void viewIsReady() {
        if (getView() != null) {
            getView().showProgress();
        }

        dataManager.getData(new CallbackLoadData<User>() {
            @Override
            public void onSuccessful(@NonNull List<User> data) {
                friendsLoaded(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                friendsErrorLoaded(message);
            }
        });
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
