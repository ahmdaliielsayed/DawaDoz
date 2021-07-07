package com.example.dawadoz.db.dao;

import com.example.dawadoz.db.entity.login.User;
import com.example.dawadoz.db.entity.login.LoginResponse;
import com.example.dawadoz.db.entity.searchproducts.Product;
import com.example.dawadoz.db.entity.searchproducts.SearchProductsResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("PharmacyAccount/Login")
    Call<LoginResponse> login(@Body User user);

    @POST("Products/SearchInProducts")
    Call<SearchProductsResponse> getProducts(@Body Product product);
}
