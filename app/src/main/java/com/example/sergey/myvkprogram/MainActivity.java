package com.example.sergey.myvkprogram;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
        bottomBar.setOnTabSelectListener(new MainActivityBottomBarTabSelectListener());
    }
}
