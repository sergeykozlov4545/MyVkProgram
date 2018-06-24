package com.example.sergey.myvkprogram.presenter.base;

public interface Presenter<V> {

    void attachView(V view);

    void detachView();

    void viewIsReady();

    V getView();
}
