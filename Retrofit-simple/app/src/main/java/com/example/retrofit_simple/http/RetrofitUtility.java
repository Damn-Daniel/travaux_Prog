package com.example.retrofit_simple.http;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitUtility {
    public static Service Get(){
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.github.com/")
                .build();

        Service service = retrofit.create(Service.class);
        return service;
    }
}
