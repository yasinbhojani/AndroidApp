package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    EditText edittext1, edittext2;
    Button add, sub, mul, div, logoutbtn;
    TextView textview1;

    double getEditText1() {
        edittext1 = findViewById(R.id.edittext1);
        double num1 = Double.parseDouble(edittext1.getText().toString());
        return num1;
    }

    double getEditText2() {
        edittext2 = findViewById(R.id.edittext2);
        double num2 = Double.parseDouble(edittext2.getText().toString());
        return num2;
    }

    void makeToast(String s) {
        Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        getSupportActionBar().setTitle("Calculator");

        Intent fromAct = getIntent();
        String username = fromAct.getStringExtra("username");

        add = findViewById(R.id.addbtn);
        sub = findViewById(R.id.subbtn);
        mul = findViewById(R.id.mulbtn);
        div = findViewById(R.id.divbtn);
        logoutbtn = findViewById(R.id.logoutbtn);

        textview1 = findViewById(R.id.textview1);
        textview1.setText("Name: " + username);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = getEditText1() + getEditText2();
                makeToast("Addition: " + String.format("%.2f", num));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = getEditText1() - getEditText2();
                makeToast("Subtraction: " + String.format("%.2f", num));
            }
        });

        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num = getEditText1() * getEditText2();
                makeToast("Multiplication: " + String.format("%.2f", num));
            }
        });

        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double num = getEditText1() / getEditText2();
                    makeToast("Division: " + String.format("%.2f", num));
                } catch (Exception e) {
                    makeToast("Cannot Divide Number by 0");
                }
            }
        });

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferencesHandler.deleteAllDefaults(getApplicationContext());
                startActivity(new Intent(Calculator.this, SignupForm.class));
            }
        });

    }
}