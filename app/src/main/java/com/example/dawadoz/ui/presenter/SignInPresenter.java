package com.example.dawadoz.ui.presenter;

import com.example.dawadoz.db.entity.login.User;
import com.example.dawadoz.repository.Repository;
import com.example.dawadoz.ui.Presenter;
import com.example.dawadoz.ui.view.activity.SignInActivity;

public class SignInPresenter implements Presenter.IPresenter {

    private SignInActivity signInActivity;
    private Repository repository;

    public SignInPresenter() { }

    public SignInPresenter(SignInActivity signInActivity) {
        this.signInActivity = signInActivity;
        repository = new Repository(this, signInActivity);
    }

    @Override
    public void login(User user) {
        repository.login(user);
    }

    @Override
    public void sendToHomeActivity() {
        signInActivity.openHomeActivity();
    }

    @Override
    public void showError(String error) {
        signInActivity.showError(error);
    }

    @Override
    public void showError(int error) {
        signInActivity.showError(error);
    }
}
