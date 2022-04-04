package com.example.retrofit_complexe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofit_complexe.databinding.ActivityMainBinding;
import com.example.retrofit_complexe.http.RetrofitUtility;
import com.example.retrofit_complexe.http.Service;
import com.example.retrofit_complexe.transfert.element;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Service service= RetrofitUtility.Get();
        service.element("whippsie").enqueue(new Callback<element>() {
            @Override
            public void onResponse(Call<element> call, Response<element> response) {
                if (response.isSuccessful()){
                    element result = response.body();
                    binding.tv.setText(result.a+"///"+result.b+"////"+result.c.size());
                }
                else {
                    Log.i("Retrofit",response.message());
                }
            }

            @Override
            public void onFailure(Call<element> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }
}