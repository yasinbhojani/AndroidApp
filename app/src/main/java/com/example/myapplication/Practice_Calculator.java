package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Practice_Calculator extends AppCompatActivity {

    private double num1, num2;
    private Button add, sub, mul, div;
    private EditText ed1, ed2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_calculator);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Calculator");
        }

        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);

        add = (Button) findViewById(R.id.add);
        sub = (Button) findViewById(R.id.sub);
        mul = (Button) findViewById(R.id.mul);
        div = (Button) findViewById(R.id.div);

        add.setOnClickListener(createClickListener("add"));
        sub.setOnClickListener(createClickListener("sub"));
        mul.setOnClickListener(createClickListener("mul"));
        div.setOnClickListener(createClickListener("div"));
    }

    private void createToast(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener createClickListener(String op) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result = 0;
                num1 = Double.parseDouble(ed1.getText().toString());
                num2 = Double.parseDouble(ed2.getText().toString());

                switch (op) {
                    case "add":
                        result = num1 + num2;
                        createToast("Addition: " + result);
                        break;
                    case "sub":
                        result = num1 - num2;
                        createToast("Subtraction: " + result);
                        break;
                    case "mul":
                        result = num1 * num2;
                        createToast("Multiplication: " + result);
                        break;
                    case "div":
                        result = num1 / num2;
                        createToast("Division: " + result);
                        break;
                    default:
                        createToast("Invalid");

                }
            }
        };
    }
}