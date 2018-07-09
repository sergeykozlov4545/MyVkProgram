package com.example.sergey.myvkprogram.view.interfaces;

import android.support.annotation.NonNull;

import java.util.List;

public interface FragmentView<D> extends View {

    void showProgress();

    void hideProgress();

    void showData(@NonNull List<D> data);

    void showError(@NonNull String message);

}
