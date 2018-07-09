package com.example.sergey.myvkprogram.view.adapters;

import android.support.annotation.NonNull;

import java.util.List;

public interface ListAdapter<T> {
    void updateData(@NonNull List<T> values);
}
