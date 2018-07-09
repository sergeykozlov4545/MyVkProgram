package com.example.sergey.myvkprogram.view.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.presenter.base.FragmentPresenter;
import com.example.sergey.myvkprogram.presenter.base.Presenter;
import com.example.sergey.myvkprogram.view.adapters.BaseListAdapter;
import com.example.sergey.myvkprogram.view.interfaces.FragmentView;

import java.util.List;

public abstract class SwipeRefreshListFragment<Data> extends Fragment implements FragmentView<Data> {

    private FrameLayout contentFragment;
    private ProgressBar progressBar;
    private SwipeRefreshLayout swipeRefreshLayout;

    private RecyclerView dataRecyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private BaseListAdapter<Data> listAdapter;

    private Presenter<FragmentView<Data>> presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = getPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_swipe_refresh_list, container, false);

        initView(view);

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
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showData(@NonNull List<Data> data) {
        listAdapter.updateData(data);
        swipeRefreshLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void showError(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    protected abstract BaseListAdapter<Data> getListAdapter();

    @NonNull
    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract boolean isWithDividers();

    @NonNull
    protected abstract Presenter<FragmentView<Data>> getPresenter();

    private void initView(View view) {
        contentFragment = view.findViewById(R.id.contentFragment);
        progressBar = view.findViewById(R.id.progress);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (presenter instanceof FragmentPresenter) {
                ((FragmentPresenter) presenter).refreshedData();
            }
        });

        dataRecyclerView = view.findViewById(R.id.list);

        layoutManager = getLayoutManager();
        dataRecyclerView.setLayoutManager(layoutManager);

        listAdapter = getListAdapter();
        dataRecyclerView.setAdapter(listAdapter);

        if (isWithDividers() && layoutManager instanceof LinearLayoutManager) {
            int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
            dataRecyclerView.addItemDecoration(
                    new DividerItemDecoration(getContext(), orientation));
        }
    }
}
