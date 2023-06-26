package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendEmail extends AppCompatActivity {
    Button mailbtn;
    EditText recmail, subject, mailmessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Send Email");
        }

        mailbtn = findViewById(R.id.mailbtn);
        recmail = findViewById(R.id.recmail);
        subject = findViewById(R.id.subject);
        mailmessage = findViewById(R.id.mailmessage);

        mailbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipientEmail = recmail.getText().toString().trim();
                String sub = subject.getText().toString().trim();
                String message = mailmessage.getText().toString().trim();

                if (recipientEmail.isEmpty() || sub.isEmpty() || message.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please enter mail, subject and message correctly", Toast.LENGTH_SHORT).show();
                } else {
                    sendEmail(recipientEmail, sub, message);
                }
            }
        });
    }

    private void sendEmail(String recipientEmail, String subject, String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:" + recipientEmail));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "No email app found", Toast.LENGTH_SHORT).show();
        }
    }
}