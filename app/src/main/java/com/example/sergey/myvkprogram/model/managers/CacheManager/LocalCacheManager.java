package com.example.sergey.myvkprogram.model.managers.CacheManager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class LocalCacheManager implements CacheManager {

    private volatile static LocalCacheManager instance;

    private Map<String, CacheObject> cachedObjects;

    public static LocalCacheManager getInstance() {
        if (instance == null) {
            synchronized (LocalCacheManager.class) {
                if (instance == null) {
                    instance = new LocalCacheManager();
                }
            }
        }

        return instance;
    }

    private LocalCacheManager() {
        cachedObjects = new HashMap<>();
    }

    @Override
    public synchronized <T> void put(@NonNull String key, @Nullable T value) {
        cachedObjects.put(key, new CacheObject<>(value));
    }

    @NonNull
    @Override
    public synchronized <T> CacheObject<T> get(@NonNull String key) {
        CacheObject<T> object = cachedObjects.get(key);
        return (object == null) ? new NullableCacheObject<>() : object;
    }
}
