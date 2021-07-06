package com.example.dawadoz.repository;

import android.content.Context;
import android.util.Base64;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.dawadoz.db.dao.APIInterface;
import com.example.dawadoz.db.entity.LoginResponse;
import com.example.dawadoz.db.entity.TempAPI;
import com.example.dawadoz.db.entity.User;
import com.example.dawadoz.ui.Presenter;
import com.example.dawadoz.ui.presenter.SignInPresenter;
import com.example.dawadoz.ui.view.SharedPrefManager;
import com.example.dawadoz.ui.view.activity.SignInActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_ACCESS_PASSWORD;
import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_ACCESS_TOKEN;
import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_ACCESS_USERNAME;
import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_IS_LOGIN;

public class Repository {

    private APIInterface apiInterface;
    private SignInPresenter signInPresenter;
    private SignInActivity signInActivity;

    public Repository() {
        apiInterface = TempAPI.getClient().create(APIInterface.class);
    }

    public Repository(Presenter.IPresenter iPresenter, Context context) {
        signInPresenter = (SignInPresenter) iPresenter;
        signInActivity = (SignInActivity) context;
        apiInterface = TempAPI.getClient().create(APIInterface.class);
    }

    public void login(User user) {
        final String userName = "1b75d39d-6850-410f-966e-adcd1a50b308";
        final String Password = "2a654c23-568e-436c-a96c-e826e89bd3b7";
        String base = userName + ":" + Password;
        String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);


        apiInterface.login(authHeader, user).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                Log.i("asdfg", response.headers().toString());
                Log.i("asdfg", response.body().toString());
                Log.i("asdfg", ""+response.code());
                Log.i("asdfg", response.message().toString());
                Log.i("asdfg", user.getPassword().toString());
                Log.i("asdfg", user.getFireBaseToken().toString());
                Log.i("asdfg", user.getUserName().toString());

                if (response.isSuccessful()) {
                    LoginResponse model = response.body();
                    if (model.getStatus().equals("201")) {
                        saveDataUsingSharedPref(user.getUserName(), user.getPassword());
                    } else {
                        signInPresenter.showError(model.getMessage());
                    }

                    Log.i("asdfg", "OnResponse()");
                } else {
                    // show error message to user either username or password incorrect
                    Log.i("asdfg", "Error OnResponse()");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
                Log.i("asdfg", t.getMessage());
            }
        });
    }

    private void saveDataUsingSharedPref(String userName, String password) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.w("TAGTAG", "Fetching FCM registration token failed", task.getException());
                    return;
                }

                String token = task.getResult();

                SharedPrefManager.getInstance(signInActivity).setValue(KEY_ACCESS_TOKEN, token);
                SharedPrefManager.getInstance(signInActivity).setValue(KEY_ACCESS_USERNAME, userName);
                SharedPrefManager.getInstance(signInActivity).setValue(KEY_ACCESS_PASSWORD, password);
                SharedPrefManager.getInstance(signInActivity).setValue(KEY_IS_LOGIN, true);
                signInPresenter.sendToHomeActivity();
            }
        });
    }
}
