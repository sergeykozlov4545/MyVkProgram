package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.contracts.PhotosFragmentContract;
import com.example.sergey.myvkprogram.model.managers.DataManager.PhotosDataManager;
import com.example.sergey.myvkprogram.model.pojo.object.Photo;
import com.example.sergey.myvkprogram.presenter.main.PhotosFragmentPresenterImpl;
import com.example.sergey.myvkprogram.view.adapters.PhotosListAdapter;

import java.util.List;

public class PhotosFragment extends BaseFragment implements PhotosFragmentContract.PhotosFragmentView {

    private View content;
    private PhotosFragmentContract.PhotosFragmentPresenter presenter;

    private RecyclerView photosListView;
    private PhotosListAdapter photosListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new PhotosFragmentPresenterImpl(new PhotosDataManager());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);

        addView(R.layout.fragment_photos);
        initViews();

        presenter.attachView(this);
        presenter.viewIsReady();

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        presenter.detachView();
    }

    @Override
    public void showPhotos(@NonNull List<Photo> photos) {
        if (photosListAdapter != null) {
            photosListAdapter.updateData(photos);
        }

        content.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    private void initViews() {
        content = getContentView().findViewById(R.id.content);

        photosListView = content.findViewById(R.id.photosList);
        photosListView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        photosListAdapter = new PhotosListAdapter();
        photosListView.setAdapter(photosListAdapter);
    }
}
