package com.example.sergey.myvkprogram.model.managers.DataManager;

import android.support.annotation.NonNull;

public interface DataManager<T> {
    void getData(@NonNull CallbackLoadData<T> callbackLoadData);
}
