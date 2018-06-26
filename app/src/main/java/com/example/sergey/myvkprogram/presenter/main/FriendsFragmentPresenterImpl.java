package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.FriendsFragmentContract;
import com.example.sergey.myvkprogram.model.managers.CacheManager.CachKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
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
        loadData();
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

    private void loadData() {
        dataManager.getData(new CallbackLoadData<User>() {
            @Override
            public void onStartLoadData() {
                if (getView() != null) {
                    getView().showProgress();
                }
            }

            @Override
            public void onSuccessful(@NonNull List<User> data) {
                LocalCacheManager.getInstance()
                        .put(CachKey.FriendsFragment.FIRST_VISIBLE, Boolean.FALSE);
                // TODO: 26.06.18 Сохраняем в кэш

                friendsLoaded(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                friendsErrorLoaded(message);
            }
        });
    }
}
