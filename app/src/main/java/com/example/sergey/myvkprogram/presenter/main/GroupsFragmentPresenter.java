package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheKey;
import com.example.sergey.myvkprogram.model.managers.DataManager.DataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Group;
import com.example.sergey.myvkprogram.presenter.base.BaseFragmentPresenter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public class GroupsFragmentPresenter
        extends BaseFragmentPresenter<FragmentView<Group>, Group> {

    public GroupsFragmentPresenter(@NonNull DataManager<Group> dataManager) {
        super(dataManager);
    }

    @NonNull
    @Override
    protected String getFirstLoadKey() {
        return CacheKey.GroupsFragment.FIRST_VISIBLE;
    }

    @NonNull
    @Override
    protected String getDataKey() {
        return CacheKey.GroupsFragment.ITEMS_DATA;
    }
}
