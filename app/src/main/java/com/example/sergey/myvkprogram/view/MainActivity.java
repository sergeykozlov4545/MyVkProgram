package com.example.sergey.myvkprogram.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.contracts.MainActivityContract;
import com.example.sergey.myvkprogram.presenter.main.MainActivityPresenterImpl;
import com.example.sergey.myvkprogram.view.fragments.AlbumsFragment;
import com.example.sergey.myvkprogram.view.fragments.FriendsFragment;
import com.example.sergey.myvkprogram.view.fragments.GroupsFragment;
import com.example.sergey.myvkprogram.view.fragments.VideosFragment;
import com.example.sergey.myvkprogram.view.listeners.MainActivityBottomBarTabSelectListener;
import com.roughike.bottombar.BottomBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements MainActivityContract.MainActivityView {

    public static final String SELECTED_TAB_ID = "SELECTED_TAB_ID";

    private BottomBar bottomBar;

    private List<Fragment> fragments;
    private SparseArrayCompat<Integer> items;

    private MainActivityContract.MainActivityPresenter presenter;

    private int selectedTabId = R.id.albums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData(savedInstanceState);
        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();

        presenter.attachView(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.viewIsReady();
        presenter.viewResumed(selectedTabId);
    }

    @Override
    protected void onStop() {
        super.onStop();

        presenter.detachView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(SELECTED_TAB_ID, selectedTabId);
    }

    @Override
    public void showTab(@IdRes int tabId) {
        selectedTabId = tabId;
        showFragment(getFragmentByTabId(tabId));
    }

    private void initData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            selectedTabId = savedInstanceState.getInt(SELECTED_TAB_ID, R.id.albums);
        }

        fragments = new ArrayList<>();
        fragments.add(new AlbumsFragment());
        fragments.add(new VideosFragment());
        fragments.add(new FriendsFragment());
        fragments.add(new GroupsFragment());

        items = new SparseArrayCompat<>();
        items.put(R.id.albums, 0);
        items.put(R.id.videos, 1);
        items.put(R.id.friends, 2);
        items.put(R.id.groups, 3);

        presenter = new MainActivityPresenterImpl();
    }

    private void initView() {
        bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new MainActivityBottomBarTabSelectListener(presenter));
    }

    private Fragment getFragmentByTabId(@IdRes int tabId) {
        return fragments.get(items.get(tabId));
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer, fragment)
                .commit();
    }
}
