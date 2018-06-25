package com.example.sergey.myvkprogram.model.managers.CacheManager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;

public final class LocalCacheManager implements CacheManager {

    private volatile static LocalCacheManager instance;

    private Map<String, Object> map;

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
        map = new HashMap<>();
    }

    @Override
    public synchronized void putString(@NonNull String key, @Nullable String value) {
        map.put(key, value);
    }

    @Nullable
    @Override
    public synchronized String getString(@NonNull String key, @Nullable String defaultValue) {
        return map.containsKey(key) ? (String) map.get(key) : defaultValue;
    }

    @Override
    public synchronized void putInteger(@NonNull String key, @Nullable Integer value) {
        map.put(key, value);
    }

    @Override
    public synchronized Integer getInteger(@NonNull String key, @Nullable Integer defaultValue) {
        return map.containsKey(key) ? (Integer) map.get(key) : defaultValue;
    }

    @Override
    public synchronized void putLong(@NonNull String key, @Nullable Long value) {
        map.put(key, value);
    }

    @Override
    public synchronized Long getLong(@NonNull String key, @Nullable Long defaultValue) {
        return map.containsKey(key) ? (Long) map.get(key) : defaultValue;
    }

    @Override
    public synchronized void putDouble(@NonNull String key, @Nullable Double value) {
        map.put(key, value);
    }

    @Override
    public synchronized Double getDouble(@NonNull String key, @Nullable Double defaultValue) {
        return map.containsKey(key) ? (Double) map.get(key) : defaultValue;
    }

    @Override
    public synchronized void putBoolean(@NonNull String key, @Nullable Boolean value) {
        map.put(key, value);
    }

    @Override
    public synchronized Boolean getBoolean(@NonNull String key, @Nullable Boolean defaultValue) {
        return map.containsKey(key) ? (Boolean) map.get(key) : defaultValue;
    }
}
