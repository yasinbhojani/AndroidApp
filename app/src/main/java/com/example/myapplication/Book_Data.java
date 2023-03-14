package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Book_Data extends AppCompatActivity {
    ImageView book_image;
    TextView book_title;
    TextView book_author;
    TextView book_price;
    TextView book_rating;
    TextView book_summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_data);

        Book data = (Book) getIntent().getSerializableExtra("data");
        getSupportActionBar().setTitle(data.book_name);

        book_image = findViewById(R.id.book_image);
        book_title = findViewById(R.id.book_title);
        book_author = findViewById(R.id.book_author);
        book_price = findViewById(R.id.book_price);
        book_rating = findViewById(R.id.book_rating);
        book_summary = findViewById(R.id.book_summary);



        book_image.setImageDrawable(getDrawable(data.book_image));
        book_title.setText(data.book_name);
        book_author.setText(data.book_author);
        book_price.setText("₹" + data.book_price);
        book_rating.setText(String.valueOf(data.book_rating));
        book_summary.setText(data.book_summary);
    }
}