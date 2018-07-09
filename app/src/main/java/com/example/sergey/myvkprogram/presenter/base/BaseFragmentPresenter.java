package com.example.sergey.myvkprogram.presenter.base;

import android.support.annotation.NonNull;

import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public abstract class BaseFragmentPresenter<V extends FragmentView, D>
        extends BasePresenter<V>
        implements FragmentPresenter<V, D> {

    @Override
    public void successLoadData(@NonNull List<D> data) {
        FragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showData(data);
        }
    }

    @Override
    public void failureLoadData(@NonNull String message) {
        FragmentView view = getView();

        if (view != null) {
            view.hideProgress();
            view.showError(message);
        }
    }
}
