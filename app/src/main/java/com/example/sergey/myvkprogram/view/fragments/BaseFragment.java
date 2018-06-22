package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public class BaseFragment extends Fragment implements FragmentView {

    private FrameLayout contentFragment;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_base, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        contentFragment = getView().findViewById(R.id.contentFragment);
        progressBar = getView().findViewById(R.id.progress);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public ViewGroup getContentView() {
        return contentFragment;
    }

    @Override
    public void addView(int layoutId) {
        ViewGroup contentView = getContentView();
        View view = LayoutInflater.from(getContext())
                .inflate(layoutId, contentView, false);
        contentView.addView(view);
    }
}
