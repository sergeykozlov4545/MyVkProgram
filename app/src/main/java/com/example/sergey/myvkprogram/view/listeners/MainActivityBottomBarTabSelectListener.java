package com.example.sergey.myvkprogram.view.listeners;

import android.support.annotation.IdRes;

import com.example.sergey.myvkprogram.contracts.MainActivityContract;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivityBottomBarTabSelectListener implements OnTabSelectListener {

    private MainActivityContract.MainActivityPresenter presenter;

    public MainActivityBottomBarTabSelectListener(MainActivityContract.MainActivityPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        if (presenter.getView() != null) {
            presenter.getView().updateSelectedTabId(tabId);
        }

        presenter.onTabSelected(tabId);
    }
}