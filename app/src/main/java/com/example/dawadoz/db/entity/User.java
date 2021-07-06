package com.example.dawadoz.db.entity;

public class User {

    private String mUserName;
    private String mPassword;
    private String mFireBaseToken;

    public User() { }

    public User(String mUserName, String mPassword, String mFireBaseToken) {
        this.mUserName = mUserName;
        this.mPassword = mPassword;
        this.mFireBaseToken = mFireBaseToken;
    }

    public String getUserName() {
        return mUserName;
    }

    public void setUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
    }

    public String getFireBaseToken() {
        return mFireBaseToken;
    }

    public void setFireBaseToken(String mFireBaseToken) {
        this.mFireBaseToken = mFireBaseToken;
    }
}
