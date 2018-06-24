package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.FriendsFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.model.pojo.response.FriendsResponse;
import com.example.sergey.myvkprogram.model.pojo.response.ResponseImpl;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.ServiceManager.FriendsQueryServiceManager;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

        serviceManager.loadData(new ServiceManagerCallback());
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

    private class ServiceManagerCallback implements Callback<ResponseImpl<FriendsResponse>> {

        @Override
        public void onResponse(Call<ResponseImpl<FriendsResponse>> call, Response<ResponseImpl<FriendsResponse>> response) {
            if (response.isSuccessful()) {
                ResponseImpl<FriendsResponse> friendsResponse = response.body();
                List<User> friends = friendsResponse.getItems();

                if (friends != null) {
                    friendsLoaded(friends);
                }
            } else {
                friendsErrorLoaded("Произошла ошибка при выполнении запроса: code = " + response.code());
            }
        }

        @Override
        public void onFailure(Call<ResponseImpl<FriendsResponse>> call, Throwable t) {
            friendsErrorLoaded("Произошла ошибка при выполнении запроса");
        }
    }
}
