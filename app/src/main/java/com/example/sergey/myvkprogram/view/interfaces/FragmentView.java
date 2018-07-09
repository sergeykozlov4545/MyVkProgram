package com.example.sergey.myvkprogram.view.interfaces;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import java.util.List;

public interface FragmentView<D> extends View {

    void showProgress();

    void hideProgress();

    ViewGroup getContentView();

    void addView(@LayoutRes int layoutId);

    void showData(@NonNull List<D> data);

    void showError(@NonNull String message);

}
