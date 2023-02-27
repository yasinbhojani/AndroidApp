package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class Book_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        getSupportActionBar().setTitle("Book Store");

        Book[] books = new Book[8];
        books[0] = new Book("Ikigai", "Hector Gracia", getString(R.string.ikigai), "329.00", 4.6, R.drawable.book_ikigai);
        books[1] = new Book("Algorithms to Live By", "Brian Christian, Tom Griffiths", getString(R.string.algorithms_to_live_by), "466.00", 4.5, R.drawable.book_algorithms_to_live_by);
        books[2] = new Book("Atomic Habits", "James Clear", getString(R.string.atomic_habits), "468.00", 4.6, R.drawable.book_atomic_habits);
        books[3] = new Book("Our Mathematical Universe", "Max Tegmark", getString(R.string.our_mathematical_universe), "478.00", 4.5, R.drawable.book_our_mathematical_universe);
        books[4] = new Book("Outliers", "Malcolm Gladwell", getString(R.string.outliers), "419.00", 4.4, R.drawable.book_outliers);
        books[5] = new Book("Sapiens", "Yuval Noah Harrari", getString(R.string.sapiens), "243.00", 4.7, R.drawable.book_sapiens);
        books[6] = new Book("The Intelligent Investor", "Benjamin Graham", getString(R.string.the_intelligent_investor), "470.00", 4.7, R.drawable.book_the_intelligent_investor);
        books[7] = new Book("Tiny Habits", "BJ Fogg", getString(R.string.tiny_habits), "441.00", 4.6, R.drawable.book_tiny_habits);

        findViewById(R.id.book1).setOnClickListener(createBookClickListener(books[0]));
        findViewById(R.id.book2).setOnClickListener(createBookClickListener(books[1]));
        findViewById(R.id.book3).setOnClickListener(createBookClickListener(books[2]));
        findViewById(R.id.book4).setOnClickListener(createBookClickListener(books[3]));
        findViewById(R.id.book5).setOnClickListener(createBookClickListener(books[4]));
        findViewById(R.id.book6).setOnClickListener(createBookClickListener(books[5]));
        findViewById(R.id.book7).setOnClickListener(createBookClickListener(books[6]));
        findViewById(R.id.book8).setOnClickListener(createBookClickListener(books[7]));
    }

    public View.OnClickListener createBookClickListener(Book data) {
        return (new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Book_Data.class);
                i.putExtra("data", data);
                System.out.println("in send data lol");
                startActivity(i);
            }
        });
    }
}