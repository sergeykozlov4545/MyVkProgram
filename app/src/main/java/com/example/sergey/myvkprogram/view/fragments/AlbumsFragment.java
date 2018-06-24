package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.sergey.myvkprogram.R;

public class AlbumsFragment extends BaseFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        addView(R.layout.fragment_albums);
    }
}
