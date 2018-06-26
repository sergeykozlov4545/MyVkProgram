package com.example.sergey.myvkprogram.model.managers.CacheManager;

public class CacheObject<T> {

    private T value;

    public CacheObject(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public <V> boolean is(Class<V> tClass) {
        return value != null && tClass.isInstance(value);
    }
}
