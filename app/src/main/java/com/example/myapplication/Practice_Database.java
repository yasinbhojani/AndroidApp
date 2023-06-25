package com.example.myapplication;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Practice_Database extends SQLiteOpenHelper {
    public Practice_Database(@Nullable Context context) {
        super(context, "practiceDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE users (id integer PRIMARY KEY AUTOINCREMENT, uname VARCHAR(32))";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public int insertUser(String uname) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put("uname", uname);

        return (int) db.insert("users", null, val);
    }

    public String[] getUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor results = db.rawQuery("SELECT * FROM users", null);

        int length = results.getCount();
        String[] users = new String[length];
        results.moveToFirst();

        for (int i = 0; i < results.getCount(); i++) {
            users[i] = results.getString(results.getColumnIndexOrThrow("uname"));
            results.moveToNext();
            System.out.println(users[i]);
        }

        results.close();
        return users;
    }
}
