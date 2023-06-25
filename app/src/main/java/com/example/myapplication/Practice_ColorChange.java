package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class Practice_ColorChange extends AppCompatActivity {

    private Button change_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_color_change);

        change_btn = (Button) findViewById(R.id.change_btn);

        change_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                View root = change_btn.getRootView();

                PopupMenu popupMenu = new PopupMenu(getApplicationContext(), view);
                popupMenu.inflate(R.menu.color_menu);
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.red:
                                root.setBackgroundColor(Color.parseColor("#ff0000"));
                                break;
                            case R.id.green:
                                root.setBackgroundColor(Color.parseColor("#00ff00"));
                                break;
                            case R.id.blue:
                                root.setBackgroundColor(Color.parseColor("#0000ff"));
                                break;
                            case R.id.white:
                                root.setBackgroundColor(Color.parseColor("#ffffff"));
                                break;
                            case R.id.black:
                                root.setBackgroundColor(Color.parseColor("#000000"));
                                break;
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });
    }
}