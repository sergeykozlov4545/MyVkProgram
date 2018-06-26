package com.example.sergey.myvkprogram.model.managers.CacheManager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface CacheManager {

    <T> void put(@NonNull String key, @Nullable T value);

    @NonNull
    <T> CacheObject<T> get(@NonNull String key);

}
