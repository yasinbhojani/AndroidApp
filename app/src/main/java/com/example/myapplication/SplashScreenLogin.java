package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashScreenLogin extends AppCompatActivity {

    TextView tw1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_login);

        tw1 = findViewById(R.id.textviewUname);

        Intent fromAct = getIntent();
        String username = fromAct.getStringExtra("username");
        int user_id = fromAct.getIntExtra("user_id", 0);

        tw1.setText("user_id: " + user_id + "\n" + "username: " + username);

        if(getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreenLogin.this, Calculator.class);
                i.putExtra("user_id", user_id);
                i.putExtra("username", username);
                startActivity(i);
            }
        }, 4000);
    }
}