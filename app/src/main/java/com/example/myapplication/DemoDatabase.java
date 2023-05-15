package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.mindrot.jbcrypt.BCrypt;


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

    public String findUser(String uname, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultCr = db.rawQuery("SELECT fname, lname, password FROM users WHERE uname = ?", new String[]{uname});

        if (resultCr.getCount() >= 1) {
            resultCr.moveToFirst();
            @SuppressLint("Range") String passhash = resultCr.getString(resultCr.getColumnIndex("password"));
            if (BCrypt.checkpw(pass, passhash)) {
                @SuppressLint("Range") String fname = resultCr.getString(resultCr.getColumnIndex("fname"));
                @SuppressLint("Range") String lname = resultCr.getString(resultCr.getColumnIndex("lname"));
                resultCr.close();
                return fname + " " + lname;
            } else {
                resultCr.close();
                return "";
            }
        } else {
            resultCr.close();
            return "";
        }
    }

    public User[] getAllUsers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor resultCr = db.rawQuery("SELECT * FROM users", null);

        String uname, fname, lname, password;
        long contact;

        int len = resultCr.getCount();
        User[] users = new User[len];
        resultCr.moveToFirst();

        for (int i = 0; i < len; i++) {
            uname = resultCr.getString(resultCr.getColumnIndexOrThrow("uname"));
            fname = resultCr.getString(resultCr.getColumnIndexOrThrow("fname"));
            lname = resultCr.getString(resultCr.getColumnIndexOrThrow("lname"));
            password = resultCr.getString(resultCr.getColumnIndexOrThrow("password"));
            contact = resultCr.getLong(resultCr.getColumnIndexOrThrow("contact"));

            users[i] = new User(uname, fname, lname, password, contact);
            resultCr.moveToNext();
        }

        resultCr.close();
        return users;
    }

    public boolean editUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("fname", user.fname);
        cv.put("lname", user.lname);
        cv.put("contact", user.contact);

        db.update("users", cv, "uname = ?", new String[]{user.uname});
        return true;
    }

    public User getUser(String find_uname) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("SELECT * FROM users WHERE uname = ?", new String[]{find_uname});
        String uname, fname, lname, password;
        long contact;
        User user;

        result.moveToFirst();

        uname = result.getString(result.getColumnIndexOrThrow("uname"));
        fname = result.getString(result.getColumnIndexOrThrow("fname"));
        lname = result.getString(result.getColumnIndexOrThrow("lname"));
        password = result.getString(result.getColumnIndexOrThrow("password"));
        contact = result.getLong(result.getColumnIndexOrThrow("contact"));

        user = new User(uname, fname, lname, password, contact);

        result.close();
        return user;
    }

    public boolean removeUser(String uname) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("users", "uname = ?", new String[]{uname});

        return true;
    }
}
