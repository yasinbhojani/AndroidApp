package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeActivity extends AppCompatActivity {

    TextView Date, time1;
    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        reset = findViewById(R.id.restDate);
        Date = findViewById(R.id.curr_date);
        time1 = findViewById(R.id.curr_time);
        setDateTime(Date, time1);

        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(DateTimeActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                        Date.setText(selectedDate);
                    }
                }, year, month, day);
                datePickerDialog.show();

            }
        });
        time1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(DateTimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String selectedTime = hourOfDay + ":" + minute;
                        time1.setText(selectedTime);
                    }
                }, hour, minute, false);
                timePickerDialog.show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDateTime(Date, time1);
            }
        });
    }

    public void setDateTime(TextView date, TextView time1) {
        java.util.Date time = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        String curr_date = sdf.format(time);
        date.setText(curr_date.toString());

        SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
        String curr_time = sdf1.format(time);
        time1.setText(curr_time.toString());
    }
}