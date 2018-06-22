package com.example.sergey.myvkprogram.model.retrofit.ServiceApi;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.contracts.FriendsFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.FriendsResponse;
import com.example.sergey.myvkprogram.model.pojo.User;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.QueryParams;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FriendsQueryServiceManager extends ServiceManagerImpl {

    private QueryParams params;

    public FriendsQueryServiceManager(@NonNull QueryParams params) {
        this.params = params;
    }

    public void loadData(FriendsFragmentContract.FriendsFragmentPresenter presenter) {
        ServiceApi service = createService(ServiceApi.class, Constants.BASE_URL);
        Call<FriendsResponse> friendsResponseCall = service.getFriends(params.getParams());

        friendsResponseCall.enqueue(new Callback<FriendsResponse>() {
            @Override
            public void onResponse(Call<FriendsResponse> call, Response<FriendsResponse> response) {
                if (response.isSuccessful()) {
                    FriendsResponse friendsResponse = response.body();
                    List<User> friends = friendsResponse.getItems();

                    if (friends != null) {
                        presenter.friendsLoaded(friends);
                    }
                } else {
                    presenter.friendsErrorLoaded("Произошла ошибка при выполнении запроса: code = " + response.code());
                }
            }

            @Override
            public void onFailure(Call<FriendsResponse> call, Throwable t) {
                presenter.friendsErrorLoaded("Произошла ошибка при выполнении запроса");
            }
        });
    }
}
