package com.example.retrofit_complexe.http;

import com.example.retrofit_complexe.transfert.element;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Service {
    @GET("complexe?name=utilisateur")
    Call<element> element(@Query("utilisateur") String utilisateur);
}
