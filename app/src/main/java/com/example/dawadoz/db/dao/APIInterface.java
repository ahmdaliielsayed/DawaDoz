package com.example.dawadoz.db.dao;

import com.example.dawadoz.db.entity.LoginResponse;
import com.example.dawadoz.db.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("api/PharmacyAccount/Login")
    Call<LoginResponse> login(@Header("Authorization") String header,
                              @Body User user);
}
