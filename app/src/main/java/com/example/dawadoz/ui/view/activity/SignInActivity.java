package com.example.dawadoz.ui.view.activity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.dawadoz.R;
import com.example.dawadoz.databinding.ActivitySignInBinding;
import com.example.dawadoz.db.entity.login.User;
import com.example.dawadoz.ui.Presenter;
import com.example.dawadoz.ui.presenter.SignInPresenter;
import com.example.dawadoz.ui.view.SharedPrefManager;

import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_ACCESS_TOKEN;
import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_IS_LOGIN;

public class SignInActivity extends AppCompatActivity implements Presenter.IView {

    private ActivitySignInBinding binding;

    private SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);
        binding.setActivitySignIn(this);

        if (SharedPrefManager.getInstance(this).getBooleanValue(KEY_IS_LOGIN)) {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }

        initComponents();
    }

    private void initComponents() {
        signInPresenter = new SignInPresenter(this);
    }

    public void validateData() {
        String userName = binding.etUsername.getText().toString().trim();
        String password = binding.etPassword.getText().toString().trim();

        if (userName.isEmpty()) {
            binding.etUsername.setError(getText(R.string.username_required));
            binding.etUsername.requestFocus();
        } else if (password.isEmpty()) {
            binding.etPassword.setError(getText(R.string.password_required));
            binding.etPassword.requestFocus();
        } else if (!isNetworkConnected()) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.error)
                    .setMessage(R.string.internet_connection)
                    .setIcon(R.drawable.cancel)
                    .setPositiveButton(R.string.ok, null)
                    .show();
        } else {
            binding.progressBar.setVisibility(View.VISIBLE);
            binding.btnLogin.setEnabled(false);
            signInPresenter.login(new User(userName, password, SharedPrefManager.getInstance(this).getStringValue(KEY_ACCESS_TOKEN)));
        }
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

    @Override
    public void openHomeActivity() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void showError(String error) {
        binding.btnLogin.setEnabled(true);
        binding.progressBar.setVisibility(View.GONE);
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void showError(int error) {
        binding.btnLogin.setEnabled(true);
        binding.progressBar.setVisibility(View.GONE);
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}