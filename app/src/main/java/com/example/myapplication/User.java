package com.example.myapplication;

public class User {
    String uname, fname, lname, password;
    long contact;

    public User(String uname, String fname, String lname, String password, long contact) {
        this.uname = uname;
        this.fname = fname;
        this.lname = lname;
        this.password = password;
        this.contact = contact;
    }
}
