package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DemoDatabase extends SQLiteOpenHelper {
    public DemoDatabase(@Nullable Context context) {
        super(context, "demoDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String users = "CREATE TABLE users (id integer PRIMARY KEY AUTOINCREMENT, uname VARCHAR(32), contact DECIMAL(10), password VARCHAR(16), fname VARCHAR(32), lname VARCHAR(32))";
        sqLiteDatabase.execSQL(users);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public int insertUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();

        val.put("uname", user.uname);
        val.put("contact", user.contact);
        val.put("password", user.password);
        val.put("fname", user.fname);
        val.put("lname", user.lname);

        return (int) db.insert("users", null, val);
    }
}
