package com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects;

import android.support.annotation.Nullable;

public class CacheObject<T> {

    private T value;

    public CacheObject(T value) {
        this.value = value;
    }

    @Nullable
    public T getValue() {
        return value;
    }

    public <V> boolean is(Class<V> tClass) {
        return value != null && tClass.isInstance(value);
    }

}
