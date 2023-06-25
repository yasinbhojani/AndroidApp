package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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

public class Practice_CallSMS extends AppCompatActivity {

    private EditText number_field, number_field_sms, message_field_sms;
    private Button call_btn, sms_btn;
    private int REQUEST_CALL_PHONE_PERMISSION = 123;
    private int REQUEST_SEND_SMS_PERMISSION = 456;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_call_sms);

        number_field = (EditText) findViewById(R.id.number_field);
        number_field_sms = (EditText) findViewById(R.id.number_field_sms);
        message_field_sms = (EditText) findViewById(R.id.message_field_sms);
        call_btn = (Button) findViewById(R.id.call_btn);
        sms_btn = (Button) findViewById(R.id.sms_btn);

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = number_field.getText().toString().trim();
                if (phone_number.isEmpty()) {
                    Toast.makeText(Practice_CallSMS.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
                } else {
                    int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE);
                    if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                        makeCall(phone_number);
                    } else {
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL_PHONE_PERMISSION);
                    }
                }
            }
        });

        sms_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone_number = number_field_sms.getText().toString().trim();
                String message = message_field_sms.getText().toString();

                if (phone_number.isEmpty() || message.isEmpty()) {
                    Toast.makeText(Practice_CallSMS.this, "Enter phone and message", Toast.LENGTH_SHORT).show();
                } else {
                    int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.SEND_SMS);
                    if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                        sendMessage(phone_number, message);
                    } else {
                        requestPermissions(new String[]{Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS_PERMISSION);
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
                String phone_number = number_field.getText().toString().trim();
                makeCall(phone_number);
            }
        }

        if (requestCode == REQUEST_SEND_SMS_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                String phone_number = number_field_sms.getText().toString().trim();
                String message = message_field_sms.getText().toString();

                sendMessage(phone_number, message);
            }
        }
    }

    private void makeCall(String number) {
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(Uri.parse("tel:" + number));

        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        } else {
            Toast.makeText(this, "No app found to make a call", Toast.LENGTH_SHORT).show();
        }
    }

    private void sendMessage(String number, String message) {
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(number, null, message, null, null);
        Toast.makeText(this, "Message Sent", Toast.LENGTH_SHORT).show();
        message_field_sms.setText("");
    }
}