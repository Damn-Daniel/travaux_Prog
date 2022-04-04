package com.example.retrofit_simple;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.retrofit_simple.databinding.ActivityMainBinding;
import com.example.retrofit_simple.http.RetrofitUtility;
import com.example.retrofit_simple.http.Service;
import com.example.retrofit_simple.transfer.Repo;
import com.example.retrofit_simple.transfer.Utilisateur;

import java.util.List;

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



        binding.BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Service service = RetrofitUtility.Get();
                service.Utilisateur(binding.ET.getText().toString()).enqueue(new Callback<Utilisateur>() {
                    @Override
                    public void onResponse(Call<Utilisateur> call, Response<Utilisateur> response) {
                        if(response.isSuccessful()){
                            Utilisateur resultat = response.body();
                            binding.tv.setText(resultat.id.toString());
                            Log.i("Retrofit",resultat.id.toString());
                        }
                        else {
                            Log.i("Retrofit",response.code()+"");
                        }
                    }

                    @Override
                    public void onFailure(Call<Utilisateur> call, Throwable t) {
                        Log.i("Retrofit", t.getMessage());
                    }
                });
            }
        });

    }
}