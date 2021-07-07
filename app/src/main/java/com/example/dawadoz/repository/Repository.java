package com.example.dawadoz.repository;

import android.content.Context;
import android.util.Log;

import androidx.paging.PageKeyedDataSource;

import com.example.dawadoz.R;
import com.example.dawadoz.db.dao.APIInterface;
import com.example.dawadoz.db.entity.TempAPI;
import com.example.dawadoz.db.entity.login.LoginResponse;
import com.example.dawadoz.db.entity.login.User;
import com.example.dawadoz.db.entity.searchproducts.Data;
import com.example.dawadoz.db.entity.searchproducts.DtResult;
import com.example.dawadoz.db.entity.searchproducts.Product;
import com.example.dawadoz.db.entity.searchproducts.Result;
import com.example.dawadoz.db.entity.searchproducts.SearchProductsResponse;
import com.example.dawadoz.ui.Presenter;
import com.example.dawadoz.ui.presenter.SignInPresenter;
import com.example.dawadoz.ui.view.SharedPrefManager;
import com.example.dawadoz.ui.view.activity.SignInActivity;
import com.google.firebase.messaging.FirebaseMessaging;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_ACCESS_PASSWORD;
import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_ACCESS_TOKEN;
import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_ACCESS_USERNAME;
import static com.example.dawadoz.ui.view.SharedPrefManager.KEY_IS_LOGIN;

public class Repository extends PageKeyedDataSource<Integer, DtResult> {

    private static final String SERVER_SUCCESS_RESPONSE = "201";

    private final APIInterface apiInterface;
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
        apiInterface.login(user).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response != null && response.isSuccessful()) {
                    if (response.body().getStatus().equals(SERVER_SUCCESS_RESPONSE)) {
                        saveDataUsingSharedPref(user.getUserName(), user.getPassword());
                    } else {
                        signInPresenter.showError(response.body().getMessage());
                    }
                } else {
                    signInPresenter.showError(R.string.errorResponse);
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                signInPresenter.showError(R.string.errorResponse);
            }
        });
    }

    private void saveDataUsingSharedPref(String userName, String password) {
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(task -> {
            if (!task.isSuccessful()) {
                signInPresenter.showError(R.string.tokenFail);
                return;
            }

            String token = task.getResult();

            SharedPrefManager.getInstance(signInActivity).setValue(KEY_ACCESS_TOKEN, token);
            SharedPrefManager.getInstance(signInActivity).setValue(KEY_ACCESS_USERNAME, userName);
            SharedPrefManager.getInstance(signInActivity).setValue(KEY_ACCESS_PASSWORD, password);
            SharedPrefManager.getInstance(signInActivity).setValue(KEY_IS_LOGIN, true);
            signInPresenter.sendToHomeActivity();
        });
    }

    @Override
    public void loadInitial(@NotNull LoadInitialParams<Integer> loadInitialParams, @NotNull LoadInitialCallback<Integer, DtResult> loadInitialCallback) {
        apiInterface.getProducts(new Product(Data.PageNumber, Data.RowspPage)).enqueue(new Callback<SearchProductsResponse>() {
            @Override
            public void onResponse(Call<SearchProductsResponse> call, Response<SearchProductsResponse> response) {
                if (response != null && response.isSuccessful()) {
                    if (response.body().getStatus().equals(SERVER_SUCCESS_RESPONSE)) {
                        Result result = response.body().getResult();
                        if (result != null) {
                            loadInitialCallback.onResult(result.getDtResult(), null, Data.PageNumber + 1);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchProductsResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void loadBefore(@NotNull LoadParams<Integer> loadParams, @NotNull LoadCallback<Integer, DtResult> loadCallback) {
        apiInterface.getProducts(new Product(loadParams.key, Data.RowspPage)).enqueue(new Callback<SearchProductsResponse>() {
            @Override
            public void onResponse(Call<SearchProductsResponse> call, Response<SearchProductsResponse> response) {
                if (response != null && response.isSuccessful()) {
                    if (response.body().getStatus().equals(SERVER_SUCCESS_RESPONSE)) {
                        int key = loadParams.key > 1 ? loadParams.key - 1 : null;
                        Result result = response.body().getResult();
                        if (response != null) {
                            loadCallback.onResult(result.getDtResult(), key);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchProductsResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void loadAfter(@NotNull LoadParams<Integer> loadParams, @NotNull LoadCallback<Integer, DtResult> loadCallback) {
        apiInterface.getProducts(new Product(loadParams.key, Data.RowspPage)).enqueue(new Callback<SearchProductsResponse>() {
            @Override
            public void onResponse(Call<SearchProductsResponse> call, Response<SearchProductsResponse> response) {
                if (response != null && response.isSuccessful()) {
                    if (response.body().getStatus().equals(SERVER_SUCCESS_RESPONSE)) {
                        int key = response.body().getResult().getDtResult().size() > 0 ? loadParams.key + 1 : null;
                        Result result = response.body().getResult();
                        if (response != null) {
                            loadCallback.onResult(result.getDtResult(), key);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<SearchProductsResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
