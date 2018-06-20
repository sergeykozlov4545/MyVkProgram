package com.example.sergey.myvkprogram;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.sergey.myvkprogram.fragments.AlbumsFragment;
import com.example.sergey.myvkprogram.fragments.FriendsFragment;
import com.example.sergey.myvkprogram.fragments.GroupsFragment;
import com.example.sergey.myvkprogram.fragments.VideosFragment;
import com.example.sergey.myvkprogram.listeners.MainActivityBottomBarTabSelectListener;
import com.roughike.bottombar.BottomBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        BottomBar bottomBar = findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new MainActivityBottomBarTabSelectListener(this));

        showAlbums();
    }

    public void onTabSelected(int tabId) {
        Log.e("MyTag", "onTabSelected: tabId = " + tabId);

        if (tabId == R.id.albums) {
            showAlbums();
            return;
        }
        if (tabId == R.id.videos) {
            showVideos();
            return;
        }
        if (tabId == R.id.friends) {
            showFriends();
            return;
        }
        if (tabId == R.id.groups) {
            showGroups();
            return;
        }
    }

    private void showAlbums() {
        showFragment(getFragmentByTabId(R.id.albums));
    }

    private void showVideos() {
        showFragment(getFragmentByTabId(R.id.videos));
    }

    private void showFriends() {
        showFragment(getFragmentByTabId(R.id.friends));
    }

    private void showGroups() {
        showFragment(getFragmentByTabId(R.id.groups));
    }

    private Fragment getFragmentByTabId(int tabId) {
        if (tabId == R.id.albums) {
            return new AlbumsFragment();
        }
        if (tabId == R.id.videos) {
            return new VideosFragment();
        }
        if (tabId == R.id.friends) {
            return new FriendsFragment();
        }
        if (tabId == R.id.groups) {
            return new GroupsFragment();
        }
        return null;
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.contentContainer, fragment)
                .commit();

        Log.e("MyTag", "showFragment: fragment = " + fragment);
    }
}
