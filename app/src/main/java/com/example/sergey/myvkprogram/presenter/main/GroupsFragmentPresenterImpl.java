package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.CacheManager.LocalCacheManager;
import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.presenter.base.BaseFragmentPresenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public class GroupsFragmentPresenterImpl
        extends BaseFragmentPresenter<FragmentView<Group>, Group> {

    private DataManager<Group> dataManager;

    public GroupsFragmentPresenterImpl(@NonNull DataManager<Group> dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void viewIsReady() {
        loadData();
    }

    private void loadData() {
        dataManager.getData(new CallbackLoadData<Group>() {
            @Override
            public void onStartLoadData() {
                if (getView() != null) {
                    getView().showProgress();
                }
            }

            @Override
            public void onSuccessful(@NonNull List<Group> data) {
                LocalCacheManager.getInstance()
                        .put(CacheKey.GroupsFragment.FIRST_VISIBLE, Boolean.FALSE);
                LocalCacheManager.getInstance()
                        .put(CacheKey.GroupsFragment.ITEMS_DATA, data);

                successLoadData(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                failureLoadData(message);
            }
        });
    }
}
