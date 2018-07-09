package com.example.sergey.myvkprogram.view.utils;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kozlov S.O. on 04.07.18.
 */
public class VideoDescriptionManagerImpl implements VideoDescriptionManager {

    private Set<Integer> showedDescriptionPosition = new HashSet<>();

    @Override
    public boolean isShowedDescription(int position) {
        return showedDescriptionPosition.contains(position);
    }

    @Override
    public void addShowedDescription(int position) {
        showedDescriptionPosition.add(position);
    }

    @Override
    public void removeShowedDescription(int position) {
        showedDescriptionPosition.remove(position);
    }

    @Override
    public void clear() {
        showedDescriptionPosition.clear();
    }
}
