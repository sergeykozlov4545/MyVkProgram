package com.example.sergey.myvkprogram.presenter.main;

import android.support.annotation.IdRes;

import com.example.sergey.myvkprogram.contracts.MainActivityContract;
import com.example.sergey.myvkprogram.presenter.base.BasePresenter;

public class MainActivityPresenterImpl
        extends BasePresenter<MainActivityContract.MainActivityView>
        implements MainActivityContract.MainActivityPresenter {

    @Override
    public void viewIsReady() {

    }

    @Override
    public void viewResumed(@IdRes int tabId) {
        MainActivityContract.MainActivityView view = getView();

        if (view != null) {
            view.showTab(tabId);
        }
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        MainActivityContract.MainActivityView view = getView();

        if (view != null) {
            view.showTab(tabId);
        }
    }
}
