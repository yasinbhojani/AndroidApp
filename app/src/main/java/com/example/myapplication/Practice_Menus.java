package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class Practice_Menus extends AppCompatActivity {

    Button popup_button;
    TextView context;

    private void showToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_menus);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Menus Demo");
        }

        popup_button = (Button) findViewById(R.id.popup_button);
        context = (TextView) findViewById(R.id.context);
        registerForContextMenu(context);

        popup_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(Practice_Menus.this, view);
                popup.inflate(R.menu.sample_menu);
//                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
//                    @Override
//                    public boolean onMenuItemClick(MenuItem menuItem) {
//                        return false;
//                    }
//                });
                popup.show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sample_menu, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Choose your language");
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sample_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.js:
                showToast("JavaScript Selected");
                return true;
            case R.id.py:
                showToast("Python Selected");
                return true;
            case R.id.rs:
                showToast("Rust Selected");
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}