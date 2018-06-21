package com.example.sergey.myvkprogram;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.app.AppCompatActivity;

import com.example.sergey.myvkprogram.fragments.AlbumsFragment;
import com.example.sergey.myvkprogram.fragments.FriendsFragment;
import com.example.sergey.myvkprogram.fragments.GroupsFragment;
import com.example.sergey.myvkprogram.fragments.VideosFragment;
import com.example.sergey.myvkprogram.listeners.MainActivityBottomBarTabSelectListener;
import com.roughike.bottombar.BottomBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomBar bottomBar;

    private List<Fragment> fragments;
    private SparseArrayCompat<Integer> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    private void initData() {
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
    }

    private void initView() {
        bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new MainActivityBottomBarTabSelectListener(this));
    }

    public void onTabSelected(@IdRes int tabId) {
        showFragment(getFragmentByTabId(tabId));
    }

    private Fragment getFragmentByTabId(@IdRes int tabId) {
        return fragments.get(items.get(tabId));
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.contentContainer, fragment)
                .commit();
    }
}
