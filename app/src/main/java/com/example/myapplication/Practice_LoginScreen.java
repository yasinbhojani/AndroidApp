package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practice_LoginScreen extends AppCompatActivity {

    private EditText password_ed, username_ed;
    private Button login_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_login_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Login");
        }

        login_btn = (Button) findViewById(R.id.login_btn);

        username_ed = (EditText) findViewById(R.id.username_ed);
        password_ed = (EditText) findViewById(R.id.password_ed);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = username_ed.getText().toString();
                String password = password_ed.getText().toString();

                if (username.equals("yasin") && password.equals("yasin")) {
                    startActivity(new Intent(Practice_LoginScreen.this, Practice_SplashScreen.class));
                    Toast.makeText(getApplicationContext(), "Login successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}