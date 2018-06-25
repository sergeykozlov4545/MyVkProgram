package com.example.sergey.myvkprogram.model.managers.CacheManager;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface CacheManager {
    void putString(@NonNull String key, @Nullable String value);

    @Nullable
    String getString(@NonNull String key, @Nullable String defaultValue);

    void putInteger(@NonNull String key, @Nullable Integer value);

    @Nullable
    Integer getInteger(@NonNull String key, @Nullable Integer defaultValue);

    void putLong(@NonNull String key, @Nullable Long value);

    @Nullable
    Long getLong(@NonNull String key, @Nullable Long defaultValue);

    void putDouble(@NonNull String key, @Nullable Double value);

    @Nullable
    Double getDouble(@NonNull String key, @Nullable Double defaultValue);

    void putBoolean(@NonNull String key, @Nullable Boolean value);

    @Nullable
    Boolean getBoolean(@NonNull String key, @Nullable Boolean defaultValue);
}
