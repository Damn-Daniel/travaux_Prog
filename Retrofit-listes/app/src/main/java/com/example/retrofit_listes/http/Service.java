package com.example.retrofit_listes.http;

import com.example.retrofit_listes.tranfert.T_truc;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Service {
    @GET("{type}/list")
    Call<List<Long>> Long(@Path("type") String type);

    @GET("{type}/list")
    Call<List<T_truc>> listTruc(@Path("type") String type);
}
