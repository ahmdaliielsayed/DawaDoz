package com.example.dawadoz.ui;

import com.example.dawadoz.db.entity.login.User;

public interface Presenter {

    interface IPresenter {
        void login(User user);
        void sendToHomeActivity();
        void showError(String error);
        void showError(int error);
    }

    interface IView {
        void openHomeActivity();
        void showError(String error);
        void showError(int error);
    }
}
