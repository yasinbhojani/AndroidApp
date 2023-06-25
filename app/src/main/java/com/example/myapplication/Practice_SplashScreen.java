package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Practice_SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_splash_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Practice_SplashScreen.this, Practice_Calculator.class);
                startActivity(i);
            }
        }, 4000);
    }

    public static class Practice_Database {
    }
}