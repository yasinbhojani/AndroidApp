package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {

    EditText contactedittext, lnameedittext, fnameedittext;
    Button donebtn, deletebtn;
    DemoDatabase database;
    String uname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Edit Profile");
        }

        fnameedittext = findViewById(R.id.fnameedittext);
        lnameedittext = findViewById(R.id.lnameedittext);
        contactedittext = findViewById(R.id.contactedittext);
        donebtn = findViewById(R.id.donebtn);
        deletebtn = findViewById(R.id.deletebtn);

        database = new DemoDatabase(getApplicationContext());

        uname = SharedPreferencesHandler.getStringDefaults("uname", getApplicationContext());
        User user = database.getUser(uname);

        fnameedittext.setText(user.fname);
        lnameedittext.setText(user.lname);
        contactedittext.setText(user.contact + "");

        donebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fname = fnameedittext.getText().toString();
                String lname = lnameedittext.getText().toString();
                long contact = Long.parseLong(contactedittext.getText().toString());

                User user = new User(uname, fname, lname, "", contact);
                boolean res = database.editUser(user);

                if (res == true) {
                    Toast.makeText(getBaseContext(), "Changes Made Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), HomeScreen.class));
                } else {
                    Toast.makeText(getBaseContext(), "An Error Occured", Toast.LENGTH_SHORT).show();
                }
            }
        });

        deletebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean res = database.removeUser(uname);
                if (res == true) {
                    Toast.makeText(getBaseContext(), "Account Deleted", Toast.LENGTH_LONG).show();
                    SharedPreferencesHandler.deleteAllDefaults(getApplicationContext());
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                } else {
                    Toast.makeText(getBaseContext(), "An Error Occurred", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}