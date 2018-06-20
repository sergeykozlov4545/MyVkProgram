package com.example.sergey.myvkprogram.listeners;

import com.example.sergey.myvkprogram.MainActivity;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivityBottomBarTabSelectListener implements OnTabSelectListener {

    private MainActivity mainActivity;

    public MainActivityBottomBarTabSelectListener(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public void onTabSelected(int tabId) {
        mainActivity.onTabSelected(tabId);
    }
}