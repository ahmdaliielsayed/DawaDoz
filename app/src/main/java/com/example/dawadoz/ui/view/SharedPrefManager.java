package com.example.dawadoz.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefManager {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String SHARED_PREF_NAME = "fcmSharedPref";
    public static final String KEY_ACCESS_TOKEN = "token";
    public static final String KEY_ACCESS_USERNAME = "username";
    public static final String KEY_ACCESS_PASSWORD = "password";
    public static final String KEY_IS_LOGIN = "login";

    @SuppressLint("CommitPrefEdits")
    public SharedPrefManager() {
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    @SuppressLint("CommitPrefEdits")
    public SharedPrefManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static synchronized SharedPrefManager getInstance(Context context) {
        return new SharedPrefManager(context);
    }

    public void setValue(String key,Object value){
        if (value instanceof Integer){
            editor.putInt(key, (int)value);
            editor.apply() ;
        } else if (value instanceof String){
            editor.putString(key, (String)value);
            editor.apply() ;
        } else if (value instanceof Float){
            editor.putFloat(key, (float)value);
            editor.apply() ;
        } else if (value instanceof Long){
            editor.putLong(key, (long)value);
            editor.apply() ;
        } else if (value instanceof Boolean){
            editor.putBoolean(key, (boolean)value);
            editor.apply() ;
        }
    }

    public int getIntValue(String key, int defaultValue) {
        return sharedPreferences.getInt(key, defaultValue);
    }

    public long getLongValue(String key, long defaultValue) {
        return sharedPreferences.getLong(key, defaultValue);
    }

    public boolean getBooleanValue(String keyFlag) {
        return sharedPreferences.getBoolean(keyFlag, false);
    }

    public void removeKey(String key) {
        editor.remove(key);
        editor.apply();
    }

    public void clear() {
        editor.clear().apply();
    }

    public String getStringValue(String key) {
        return sharedPreferences.getString(key, "null");
    }
}
