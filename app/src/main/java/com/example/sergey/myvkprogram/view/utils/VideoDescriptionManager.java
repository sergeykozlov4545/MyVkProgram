package com.example.sergey.myvkprogram.view.utils;

/**
 * Created by Kozlov S.O. on 04.07.18.
 */
public interface VideoDescriptionManager {
    boolean isShowedDescription(int position);

    void addShowedDescription(int position);

    void removeShowedDescription(int position);

    void clear();
}
