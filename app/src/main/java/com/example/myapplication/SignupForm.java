package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.mindrot.jbcrypt.BCrypt;

public class SignupForm extends AppCompatActivity {
    SharedPreferencesHandler pref;
    EditText username, password, confpassword, contact, firstname, lastname;
    Button signupbtn;
    TextView loginredirect;
    DemoDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        if (SharedPreferencesHandler.getBooleanDefaults("isLoggedIn", getApplicationContext())) {
            System.out.println("IsLoggedIn?: " + SharedPreferencesHandler.getBooleanDefaults("isLoggedIn", getApplicationContext()));

            Intent i = new Intent(SignupForm.this, SplashScreenLogin.class);
            i.putExtra("username", SharedPreferencesHandler.getStringDefaults("name", getApplicationContext()));
            startActivity(i);
        }

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confpassword = findViewById(R.id.confpassword);
        contact = findViewById(R.id.contact);
        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);

        signupbtn = findViewById(R.id.signupbtn);
        loginredirect = findViewById(R.id.loginredirect);

        loginredirect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignupForm.this, MainActivity.class));
            }
        });

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (password.getText().toString().equals(confpassword.getText().toString())) {
                    db = new DemoDatabase(getApplicationContext());

                    String hashedPassword = BCrypt.hashpw(confpassword.getText().toString(), BCrypt.gensalt());

                    User user = new User(username.getText().toString(), firstname.getText().toString(), lastname.getText().toString(), hashedPassword, Long.parseLong(contact.getText().toString()));
                    int res = db.insertUser(user);

                    if (res == -1) {
                        Toast.makeText(getApplicationContext(), "Data Insertion Failed", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                        username.setText("");
                        password.setText("");
                        confpassword.setText("");
                        contact.setText("");
                        firstname.setText("");
                        lastname.setText("");
                        Intent i = new Intent(SignupForm.this, MainActivity.class);
                        startActivity(i);
                    }

                } else {
                    Toast.makeText(getApplicationContext(), "Passwords do not match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}