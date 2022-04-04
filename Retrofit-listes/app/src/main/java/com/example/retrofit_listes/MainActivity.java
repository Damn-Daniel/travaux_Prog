package com.example.retrofit_listes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.retrofit_listes.databinding.ActivityMainBinding;
import com.example.retrofit_listes.http.RetrofitUtility;
import com.example.retrofit_listes.http.Service;
import com.example.retrofit_listes.tranfert.L_Adapter;
import com.example.retrofit_listes.tranfert.T_Adapter;
import com.example.retrofit_listes.tranfert.T_truc;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private L_Adapter l_adapter;
    private T_Adapter t_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecycler();
        try {
            remplirRecycler();
        } catch (IOException e) {
             
        }
    }

    private void remplirRecycler() throws IOException {
        Service service = RetrofitUtility.Get();
        Call<List<Long>> callL = service.Long("long");
        Response<List<Long>> responseL = callL.execute();
        List<Long> resultatL = responseL.body();

        Call<List<T_truc>> callT = service.listTruc("truc");
        Response<List<T_truc>> responseT = callT.execute();
        List<T_truc> resultatT = responseT.body();

        t_adapter.list = resultatT;
        t_adapter.notifyDataSetChanged();
    }


    private void initRecycler(){
        RecyclerView recyclerView = binding.recyclerView;
        RecyclerView recyclerView1 = binding.recyclerViewLong;
        recyclerView.setHasFixedSize(true);
        recyclerView1.setHasFixedSize(true);

        // use a linear layout manager
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        t_adapter = new T_Adapter();
        l_adapter = new L_Adapter();

        recyclerView.setAdapter(t_adapter);
        if (getIntent().getParcelableExtra("Adaptert")!=null){
            t_adapter.list= (List<T_truc>) getIntent().getSerializableExtra("Adapter");
        }

    }
}