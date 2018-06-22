package com.example.sergey.myvkprogram.view.interfaces;

import android.support.annotation.LayoutRes;
import android.view.ViewGroup;

public interface FragmentView extends View {

    void showProgress();

    void hideProgress();

    ViewGroup getContentView();

    void addView(@LayoutRes int layoutId);

}
