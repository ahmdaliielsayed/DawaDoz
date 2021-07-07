package com.example.dawadoz.db.entity;

import android.util.Base64;

import com.example.dawadoz.db.dao.APIInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TempAPI {

    private static Retrofit retrofit;

    public static Retrofit getClient(){
        if (retrofit == null) {
            synchronized (APIInterface.class) {
                if (retrofit == null) {
                    Gson gson = new GsonBuilder().serializeNulls().create();

                    retrofit = new Retrofit.Builder()
                            .baseUrl("http://TempAPI.dawadoz.com/api/")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(okHttpClient())
                            .build();
                }
            }
        }
        return retrofit;
    }

    private static OkHttpClient okHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addInterceptor(new HeaderInterceptor())
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .writeTimeout(120, TimeUnit.SECONDS)
                .build();
    }

    static final String userName = "1b75d39d-6850-410f-966e-adcd1a50b308";
    static final String Password = "2a654c23-568e-436c-a96c-e826e89bd3b7";
    static String base = userName + ":" + Password;
    static String authHeader = "Basic " + Base64.encodeToString(base.getBytes(), Base64.NO_WRAP);

    public static class HeaderInterceptor implements Interceptor {
        @NotNull
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", authHeader)
                    .build();
            return chain.proceed(request);
        }
    }
}
