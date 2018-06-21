package com.example.sergey.myvkprogram.listeners;

import android.support.annotation.IdRes;

import com.example.sergey.myvkprogram.MainActivity;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivityBottomBarTabSelectListener implements OnTabSelectListener {

    private MainActivity mainActivity;

    public MainActivityBottomBarTabSelectListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onTabSelected(@IdRes int tabId) {
        mainActivity.onTabSelected(tabId);
    }
}