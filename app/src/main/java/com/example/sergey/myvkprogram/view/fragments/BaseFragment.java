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
import android.widget.Toast;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

public abstract class BaseFragment<D> extends Fragment implements FragmentView<D> {

    private FrameLayout contentFragment;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);

        contentFragment = view.findViewById(R.id.contentFragment);
        progressBar = view.findViewById(R.id.progress);

        return view;
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

    @Override
    public void showError(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
