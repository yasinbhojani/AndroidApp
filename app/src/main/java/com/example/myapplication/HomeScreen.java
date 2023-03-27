package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeScreen extends AppCompatActivity {

    Button logoutbtn, calcbtn, allrecordsbtn, bookstorelinearbtn, bookstoregridbtn, editprofilebtn;
    TextView loggedinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        logoutbtn = findViewById(R.id.logoutbtn);
        calcbtn = findViewById(R.id.calcbtn);
        allrecordsbtn = findViewById(R.id.allrecordsbtn);
        bookstorelinearbtn = findViewById(R.id.bookstorelinearbtn);
        bookstoregridbtn = findViewById(R.id.bookstoregridbtn);
        editprofilebtn = findViewById(R.id.editprofilebtn);
        loggedinas = findViewById(R.id.loggedinas);


        String username = SharedPreferencesHandler.getStringDefaults("name", getApplicationContext());
        System.out.println(username);
        loggedinas.setText(username);

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesHandler.deleteAllDefaults(getApplicationContext());
                startActivity(new Intent(getApplicationContext(), SignupForm.class));
            }
        });

        calcbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Calculator.class));
            }
        });

        allrecordsbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AllUserData.class));
            }
        });

        bookstorelinearbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Book_Info.class));
            }
        });

        bookstoregridbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), BookGridLayout.class));
            }
        });

        editprofilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), EditProfile.class));
            }
        });
    }
}