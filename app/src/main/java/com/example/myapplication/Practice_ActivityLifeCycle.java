package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Practice_ActivityLifeCycle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_life_cycle);
        System.out.println("onCreate() called");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Activity Life Cycle");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy() called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart() called");
    }
}