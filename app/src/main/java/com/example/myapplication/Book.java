package com.example.myapplication;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

class Book implements Serializable {
    String book_name;
    String book_author;
    String book_summary;
    String book_price;
    double book_rating;
    int book_image;

    Book(String name, String author, String summary, String price, double rating, int image) {
        book_name = name;
        book_author = author;
        book_summary = summary;
        book_price = price;
        book_rating = rating;
        book_image = image;
    }
}
