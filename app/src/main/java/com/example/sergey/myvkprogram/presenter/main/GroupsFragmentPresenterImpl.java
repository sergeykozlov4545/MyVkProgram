package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.GroupsFragmentContract;
import com.example.sergey.myvkprogram.model.managers.DataManager.CallbackLoadData;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

import java.util.List;

public class GroupsFragmentPresenterImpl
        extends BasePresenter<GroupsFragmentContract.GroupsFragmentView>
        implements GroupsFragmentContract.GroupsFragmentPresenter {

    private DataManager<Group> dataManager;

    public GroupsFragmentPresenterImpl(@NonNull DataManager<Group> dataManager) {
        this.dataManager = dataManager;
    }

    @Override
    public void viewIsReady() {
        if (getView() != null) {
            getView().showProgress();
        }

        dataManager.getData(new CallbackLoadData<Group>() {
            @Override
            public void onSuccessful(@NonNull List<Group> data) {
                groupsLoaded(data);
            }

            @Override
            public void onFailure(@NonNull String message) {
                groupsErrorLoaded(message);
            }
        });
    }

    @Override
    public void groupsLoaded(@NonNull List<Group> groups) {
        GroupsFragmentContract.GroupsFragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showGroups(groups);
        }
    }

    @Override
    public void groupsErrorLoaded(@NonNull String message) {
        GroupsFragmentContract.GroupsFragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showError(message);
        }
    }
}
