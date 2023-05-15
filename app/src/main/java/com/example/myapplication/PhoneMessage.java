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
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PhoneMessage extends AppCompatActivity {

    private static final int REQUEST_CALL_PHONE_PERMISSION = 1;
    private static final int REQUEST_SEND_MSG_PERMISSION = 2;

    EditText edmessage, edphoneno, edmsgno;
    Button messagebtn, phonebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_message);

        edphoneno = findViewById(R.id.edphoneno);
        phonebtn = findViewById(R.id.phonebtn);

        edmessage = findViewById(R.id.edmessage);
        edmsgno = findViewById(R.id.edmsgno);
        messagebtn = findViewById(R.id.messagebtn);

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

        messagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String messageNumber = edmsgno.getText().toString().trim();
                String message = edmessage.getText().toString().trim();

                if (messageNumber.isEmpty() || message.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter phone number and message", Toast.LENGTH_SHORT).show();
                } else {
                    int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS);
                    if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                        sendMessage(messageNumber, message);
                    } else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, REQUEST_SEND_MSG_PERMISSION);
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

        if (requestCode == REQUEST_SEND_MSG_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String messageNumber = edmsgno.getText().toString().trim();
                String message = edmessage.getText().toString().trim();
                sendMessage(messageNumber, message);
            } else {
                Toast.makeText(getApplicationContext(), "Send SMS permission denied", Toast.LENGTH_SHORT).show();
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


    private void sendMessage(String phoneNumber, String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(phoneNumber, null, message, null, null);
        Toast.makeText(getApplicationContext(), "Message Sent", Toast.LENGTH_SHORT).show();
        edmessage.setText("");
    }
}