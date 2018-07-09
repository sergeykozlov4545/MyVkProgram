package com.example.sergey.myvkprogram.view.fragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sergey.myvkprogram.view.adapters.ListAdapter;

import java.util.List;

public abstract class BaseListFragment<D> extends BaseFragment<D> {

    @Override
    public void showData(@NonNull List<D> data) {
        ListAdapter<D> listAdapter = getListAdapter();
        listAdapter.updateData(data);

        getListView().setVisibility(View.VISIBLE);
    }

    @NonNull
    protected abstract ListAdapter<D> getListAdapter();

    @NonNull
    protected abstract RecyclerView getListView();

}
