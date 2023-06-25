package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practice_SendEmail extends AppCompatActivity {

    private Button send_mail;
    private EditText to_ed, subject_ed, body_ed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_send_email);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Send Email");
        }

        send_mail = (Button) findViewById(R.id.mail_btn);

        to_ed = (EditText) findViewById(R.id.email);
        subject_ed = (EditText) findViewById(R.id.subject);
        body_ed = (EditText) findViewById(R.id.body);

        send_mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String to_mail = to_ed.getText().toString().trim();
                String subject = subject_ed.getText().toString().trim();
                String body = body_ed.getText().toString().trim();

                if (to_mail.isEmpty() || subject.isEmpty() || body.isEmpty()) {
                    Toast.makeText(Practice_SendEmail.this, "Enter mail, subject and body correctly", Toast.LENGTH_SHORT).show();
                } else {
                    sendEmail(to_mail, subject, body);
                }
            }
        });
    }

    private void sendEmail(String to_mail, String subject, String body) {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto:"));
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{to_mail});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, body);

        System.out.println(to_mail);
        System.out.println(subject);
        System.out.println(body);

        if (i.resolveActivity(getPackageManager()) != null) {
            startActivity(i);
        } else {
            Toast.makeText(getApplicationContext(), "No email app found", Toast.LENGTH_SHORT).show();
        }
    }
}