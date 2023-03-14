package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AllUserData extends AppCompatActivity {
    DemoDatabase db;
    TextView userrecords;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_user_data);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Users Data");
        }

        userrecords = (TextView) findViewById(R.id.userrecords);

        db = new DemoDatabase(getApplicationContext());
        User[] users = db.getAllUsers();
        StringBuilder usersData = new StringBuilder();

        for (User user: users) {
            usersData.append(user.fname).append(" ").append(user.lname).append(" ").append(user.contact).append("\n\n");
        }

        userrecords.setText(usersData);
    }
}