package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.contracts.FriendsFragmentContract;
import com.example.sergey.myvkprogram.model.pojo.User;
import com.example.sergey.myvkprogram.model.retrofit.QueryParams.FriendsQueryParams;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.Constants;
import com.example.sergey.myvkprogram.model.retrofit.ServiceApi.FriendsQueryServiceManager;
import com.example.sergey.myvkprogram.presenter.main.FriendsFragmentPresenterImpl;

import java.util.List;

public class FriendsFragment extends BaseFragment implements FriendsFragmentContract.FriendsFragmentView {

    private FriendsQueryServiceManager serviceManager;
    private FriendsFragmentContract.FriendsFragmentPresenter presenter;

    private View content;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FriendsQueryParams params = new FriendsQueryParams()
                .setAccessToken(Constants.ACCESS_TOKEN)
                .setVersionApi(Constants.API_VERSION)
                .setUserId(Constants.MOCK_USER_ID)
                .setOrder(Constants.ORDER)
                .setFields(Constants.USER_FIELDS.PHOTO_50);
        serviceManager = new FriendsQueryServiceManager(params);
        presenter = new FriendsFragmentPresenterImpl(serviceManager);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addView(R.layout.fragment_friends);

        content = getContentView().findViewById(R.id.content);
    }

    @Override
    public void onResume() {
        super.onResume();

        presenter.attachView(this);
        presenter.viewIsReady();
    }

    @Override
    public void onStop() {
        super.onStop();

        presenter.detachView();
    }

    @Override
    public void showFriends(List<User> users) {
        Toast.makeText(getContext(), "OK", Toast.LENGTH_SHORT).show();

        content.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
