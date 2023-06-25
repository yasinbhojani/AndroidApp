package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Practice_AlertDialog extends AppCompatActivity {
    private Button show_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_alert_dialog);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Dialog Demo");
        }

        show_dialog = (Button) findViewById(R.id.show_dialog);
        show_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Practice_AlertDialog.this);
                builder.setMessage("This is an alert message");
                builder.setTitle("This is a Title");
                builder.setCancelable(false);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Practice_AlertDialog.this, "You clicked OK", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(Practice_AlertDialog.this, "You clicked cancel", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}