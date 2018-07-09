package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.User;
import com.example.sergey.myvkprogram.presenter.base.BaseFragmentPresenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public class FriendsFragmentPresenter
        extends BaseFragmentPresenter<FragmentView<User>, User> {

    public FriendsFragmentPresenter(@NonNull DataManager<User> dataManager) {
        super(dataManager);
    }

    @NonNull
    @Override
    protected String getFirstLoadKey() {
        return CacheKey.FriendsFragment.FIRST_VISIBLE;
    }

    @NonNull
    @Override
    protected String getDataKey() {
        return CacheKey.FriendsFragment.ITEMS_DATA;
    }
}
