package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button loginbtn;
    TextView signupredirect;
    EditText username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupredirect = findViewById(R.id.signupredirect);
        loginbtn = findViewById(R.id.loginbtn);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        signupredirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignupForm.class));
            }
        });

        Intent i = new Intent(MainActivity.this, SplashScreenLogin.class);
        DemoDatabase db = new DemoDatabase(getApplicationContext());


        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = username.getText().toString();
                String pass = password.getText().toString();

                String res = db.findUser(uname, pass);
                if (res.equals("")) {
                    Toast.makeText(getBaseContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getBaseContext(), "Login Successful", Toast.LENGTH_SHORT).show();

                    SharedPreferencesHandler.setDefaults("isLoggedIn", true, getApplicationContext());
                    SharedPreferencesHandler.setDefaults("name", res, getApplicationContext());
                    SharedPreferencesHandler.setDefaults("uname", uname, getApplicationContext());

                    i.putExtra("username", res);

                    startActivity(i);
                }
            }
        });
    }
}