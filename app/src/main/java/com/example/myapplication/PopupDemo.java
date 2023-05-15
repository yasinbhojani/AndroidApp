package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class PopupDemo extends AppCompatActivity {

    Button popup_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_demo);

        popup_btn = (Button) findViewById(R.id.popup_btn);

        popup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(PopupDemo.this, popup_btn);
                popup.getMenuInflater().inflate(R.menu.popup_menu_demo, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.one:
                                Toast.makeText(PopupDemo.this, "Hello, how are you", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.two:
                                Toast.makeText(PopupDemo.this, "Good", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.three:
                                Toast.makeText(PopupDemo.this, "My name is Yasin", Toast.LENGTH_SHORT).show();
                                break;
                            case R.id.four:
                                Toast.makeText(PopupDemo.this, "Thanks a lot", Toast.LENGTH_SHORT).show();
                                break;
                        }
                        return true;
                    }
                });

                popup.show();
            }
        });
    }
}