package com.example.myapplication;
// BCrpyt.checkpw(text, hash);
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginbtn;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginbtn = findViewById(R.id.loginbtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        Intent i = new Intent(MainActivity.this, SplashScreenLogin.class);


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();

                System.out.println(uname);
                System.out.println(pass);

                if (uname.equals("yasin") && pass.equals("123")) {
                    Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                    i.putExtra("username", uname);
                    i.putExtra("user_id", 1234);
                    startActivity(i);
                } else {
                    Toast.makeText(getBaseContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}