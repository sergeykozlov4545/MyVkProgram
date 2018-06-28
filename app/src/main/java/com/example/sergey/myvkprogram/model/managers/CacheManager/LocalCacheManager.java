package com.example.sergey.myvkprogram.model.managers.CacheManager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.CacheObject;
import com.example.sergey.myvkprogram.model.managers.CacheManager.CacheObjects.NullableCacheObject;

import java.util.HashMap;
import java.util.Map;

public final class LocalCacheManager implements CacheManager {

    private volatile static LocalCacheManager instance;

    private static final Object lock = new Object();

    private volatile Map<String, CacheObject> cachedObjects;

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
    public <T> void put(@NonNull String key, @Nullable T value) {
        synchronized (lock) {
            cachedObjects.put(key, new CacheObject<>(value));
        }
    }

    @NonNull
    @Override
    public <T> CacheObject<T> get(@NonNull String key) {
        synchronized (lock) {
            CacheObject<T> object = cachedObjects.get(key);
            return (object == null) ? new NullableCacheObject<>() : object;
        }
    }
}
