package com.example.dawadoz.ui;

import com.example.dawadoz.db.entity.User;

public interface Presenter {

    interface IPresenter {
        void login(User user);
        void sendToHomeActivity();
        void showError(String error);
    }

    interface IView {
        void openHomeActivity();
        void showError(String error);
    }
}
