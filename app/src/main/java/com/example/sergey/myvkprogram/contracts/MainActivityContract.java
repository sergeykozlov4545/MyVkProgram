package com.example.sergey.myvkprogram.contracts;

import android.support.annotation.IdRes;

import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.view.interfaces.View;

public interface MainActivityContract {

    interface MainActivityView extends View {

        void updateSelectedTabId(@IdRes int tabId);

        void showTab(@IdRes int tabId);

    }

    interface MainActivityPresenter extends Presenter<MainActivityView> {

        void viewResumed(@IdRes int tabId);

        void onTabSelected(@IdRes int tabId);

    }

}
