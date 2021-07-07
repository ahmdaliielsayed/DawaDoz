package com.example.dawadoz.db.entity.login;

public class User {

    private String UserName;
    private String Password;
    private String FireBaseToken;

    public User() { }

    public User(String UserName, String Password, String FireBaseToken) {
        this.UserName = UserName;
        this.Password = Password;
        this.FireBaseToken = FireBaseToken;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setFireBaseToken(String fireBaseToken) {
        FireBaseToken = fireBaseToken;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public String getFireBaseToken() {
        return FireBaseToken;
    }
}
