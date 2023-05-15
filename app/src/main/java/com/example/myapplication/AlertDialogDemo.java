package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogDemo extends AppCompatActivity {

    Button dialog_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);

        dialog_btn = (Button) findViewById(R.id.dialog_btn);
        dialog_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogDemo.this);
                builder.setMessage("This is a alert message");
                builder.setTitle("This is a title");
                builder.setCancelable(false);

                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogDemo.this, "You clicked OK", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(AlertDialogDemo.this, "You clicked cancel", Toast.LENGTH_SHORT).show();
                        dialogInterface.cancel();
                    }
                });


                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }
}