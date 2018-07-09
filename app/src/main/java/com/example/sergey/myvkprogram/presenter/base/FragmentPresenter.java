package com.example.sergey.myvkprogram.presenter.base;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public interface FragmentPresenter<V extends FragmentView, D> extends Presenter<V> {

    void successLoadData(@NonNull List<D> data);

    void failureLoadData(@NonNull String message);

    void refreshedData();

}
