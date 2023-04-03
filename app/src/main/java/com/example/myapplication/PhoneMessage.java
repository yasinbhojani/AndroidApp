package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneMessage extends AppCompatActivity {

    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;

    EditText edmessage, edphoneno;
    Button messagebtn, phonebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_message);

        edmessage = findViewById(R.id.edmessage);
        edphoneno = findViewById(R.id.edphoneno);
        messagebtn = findViewById(R.id.messagebtn);
        phonebtn = findViewById(R.id.phonebtn);

        phonebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneNumber = edphoneno.getText().toString().trim();

                if (phoneNumber.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter a phone number", Toast.LENGTH_SHORT).show();
                } else {
                    int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
                    if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                        makePhoneCall(phoneNumber);
                    } else {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
                    }
                }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CALL_PHONE_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String phoneNumber = edphoneno.getText().toString().trim();
                makePhoneCall(phoneNumber);
            } else {
                Toast.makeText(getApplicationContext(), "Call phone permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void makePhoneCall(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + phoneNumber));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "No app found to handle this activity", Toast.LENGTH_SHORT).show();
        }
    }
}