package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Practice_DBUser extends AppCompatActivity {

    EditText edit_t;
    TextView show_users;
    Button insert_user, danger;
    Practice_Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_dbuser);

        edit_t = (EditText) findViewById(R.id.edit_t);
        insert_user = (Button) findViewById(R.id.insert_user);
        show_users = (TextView) findViewById(R.id.show_users);
        danger = (Button) findViewById(R.id.danger);

        db = new Practice_Database(getApplicationContext());

        String[] users = db.getUsers();
        StringBuilder allNames = new StringBuilder();
        for (String user : users) {
            allNames.append(user).append("\n");
        }
        show_users.setText(allNames);


        insert_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname = edit_t.getText().toString().trim();
                if (db.insertUser(uname) == -1) {
                    Toast.makeText(Practice_DBUser.this, "Insertion Failed", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Practice_DBUser.this, "Values inserted successfully", Toast.LENGTH_SHORT).show();
                    edit_t.setText("");
                }
            }
        });

        danger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                db.thanos();
                db.ironman("LOL");
            }
        });
    }
}