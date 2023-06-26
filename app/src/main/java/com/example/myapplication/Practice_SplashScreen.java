package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Practice_SplashScreen extends AppCompatActivity {

    TextView intent_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_splash_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        intent_name = (TextView) findViewById(R.id.intent_name);
        String unm = getIntent().getStringExtra("username");
        intent_name.setText(unm);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(Practice_SplashScreen.this, Practice_Calculator.class);
                startActivity(i);
            }
        }, 4000);
    }

}