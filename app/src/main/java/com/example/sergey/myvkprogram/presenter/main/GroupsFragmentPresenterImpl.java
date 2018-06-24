package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.GroupsFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.model.pojo.response.GroupsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceManager.GroupsQueryServiceManager;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupsFragmentPresenterImpl
        extends BasePresenter<GroupsFragmentContract.GroupsFragmentView>
        implements GroupsFragmentContract.GroupsFragmentPresenter {

    private GroupsQueryServiceManager serviceManager;

    public GroupsFragmentPresenterImpl(GroupsQueryServiceManager serviceManager) {
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

    private class ServiceManagerCallback implements Callback<ResponseImpl<GroupsResponse>> {

        @Override
        public void onResponse(Call<ResponseImpl<GroupsResponse>> call, Response<ResponseImpl<GroupsResponse>> response) {
            if (response.isSuccessful()) {
                ResponseImpl<GroupsResponse> friendsResponse = response.body();
                List<Group> groups = friendsResponse.getItems();

                if (groups != null) {
                    groupsLoaded(groups);
                }
            } else {
                groupsErrorLoaded("Произошла ошибка при выполнении запроса: code = " + response.code());
            }
        }

        @Override
        public void onFailure(Call<ResponseImpl<GroupsResponse>> call, Throwable t) {
            groupsErrorLoaded("Произошла ошибка при выполнении запроса");
        }
    }
}
