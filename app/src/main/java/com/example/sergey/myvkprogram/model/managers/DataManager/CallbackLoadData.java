package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

import java.util.List;

public interface CallbackLoadData<T> {

    void onSuccessful(@NonNull List<T> data);

    void onFailure(@NonNull String message);

}
