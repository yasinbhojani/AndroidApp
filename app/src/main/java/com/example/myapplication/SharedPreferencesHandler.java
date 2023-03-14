package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferencesHandler {
    public static void setDefaults(String key, String value, Context context) {
        android.content.SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply(); // or editor.commit() in case you want to write data instantly
    }

    public static void setDefaults(String key, boolean value, Context context) {
        android.content.SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        android.content.SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        editor.apply(); // or editor.commit() in case you want to write data instantly
    }

    public static String getStringDefaults(String key, Context context) {
        android.content.SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }

    public static boolean getBooleanDefaults(String key, Context context) {
        android.content.SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean(key, false);
    }

    public static void deleteAllDefaults(Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}
