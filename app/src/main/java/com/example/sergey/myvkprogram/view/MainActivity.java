package com.example.sergey.myvkprogram.view;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.sergey.myvkprogram.R;
import com.example.sergey.myvkprogram.contracts.MainActivityContract;
import com.example.sergey.myvkprogram.presenter.main.MainActivityPresenterImpl;
import com.example.sergey.myvkprogram.view.fragments.PhotosFragment;
import com.example.sergey.myvkprogram.view.fragments.FriendsFragment;
import com.example.sergey.myvkprogram.view.fragments.GroupsFragment;
import com.example.sergey.myvkprogram.view.fragments.VideosFragment;
import com.roughike.bottombar.BottomBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements MainActivityContract.MainActivityView {

    public static final String SELECTED_TAB_ID = "SELECTED_TAB_ID";

    private Toolbar toolbar;
    private TextView toolbarTitleView;
    private BottomBar bottomBar;

    private List<Fragment> fragments;
    private List<Integer> titleIds;
    private SparseArrayCompat<Integer> items;

    private MainActivityContract.MainActivityPresenter presenter;

    private int selectedTabId = R.id.photos;

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
        updateToolbarTitle();
        showFragment(getFragmentByTabId(tabId));
    }

    private void initData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            selectedTabId = savedInstanceState.getInt(SELECTED_TAB_ID, R.id.photos);
        }

        fragments = new ArrayList<>();
        fragments.add(new PhotosFragment());
        fragments.add(new VideosFragment());
        fragments.add(new FriendsFragment());
        fragments.add(new GroupsFragment());

        titleIds = new ArrayList<>();
        titleIds.add(R.string.activity_main_tab_albums);
        titleIds.add(R.string.activity_main_tab_videos);
        titleIds.add(R.string.activity_main_tab_friends);
        titleIds.add(R.string.activity_main_tab_groups);

        items = new SparseArrayCompat<>();
        items.put(R.id.photos, 0);
        items.put(R.id.videos, 1);
        items.put(R.id.friends, 2);
        items.put(R.id.groups, 3);

        presenter = new MainActivityPresenterImpl();
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbar);
        toolbarTitleView = toolbar.findViewById(R.id.title);

        bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(tabId -> presenter.onTabSelected(tabId));
    }

    private void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.contentContainer, fragment)
                .commit();
    }

    @NonNull
    private Fragment getFragmentByTabId(@IdRes int tabId) {
        return fragments.get(items.get(tabId));
    }

    private void updateToolbarTitle() {
        int titlePos = items.get(selectedTabId);
        toolbarTitleView.setText(titleIds.get(titlePos));
    }
}
