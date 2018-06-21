package com.example.sergey.myvkprogram.presenter.base;

import com.example.sergey.myvkprogram.view.interfaces.View;

public abstract class BasePresenter<V extends View> implements Presenter<V> {

    private V view;

    @Override
    public void attachView(V view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public V getView() {
        return view;
    }
}
