package com.example.retrofit_simple;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.retrofit_simple.http.RetrofitUtility;
import com.example.retrofit_simple.http.Service;
import com.example.retrofit_simple.transfer.Repo;
import com.example.retrofit_simple.transfer.Utilisateur;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws IOException {
        // Context of the app under test.
        Service service = RetrofitUtility.Get();
        Call<String> call =  service.listReposString("jorisdeguet");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("Retrofit", resultat);
    }
    @Test
    public void test3() throws IOException {
        // Context of the app under test.
        Service service = RetrofitUtility.Get();
        Call<List<Repo>> call =  service.listRepos("jorisdeguet");
        Response<List<Repo>> response = call.execute();
        List<Repo> resultat = response.body();
        Log.i("Retrofit", resultat.toString());
    }

    @Test
    public void test1() throws IOException {
        // Context of the app under test.
        Service service = RetrofitUtility.Get();
        Call<String> call =  service.UtilisateurString("jorisdeguet");
        Response<String> response = call.execute();
        String resultat = response.body();
        Log.i("Retrofit", resultat);
    }

    @Test
    public void test2() throws IOException {
        // Context of the app under test.
        Service service = RetrofitUtility.Get();
        Call<Utilisateur> call =  service.Utilisateur("jorisdeguet");
        Response<Utilisateur> response = call.execute();
        Utilisateur resultat = response.body();
        Log.i("Retrofit", resultat.toString());
    }
}
