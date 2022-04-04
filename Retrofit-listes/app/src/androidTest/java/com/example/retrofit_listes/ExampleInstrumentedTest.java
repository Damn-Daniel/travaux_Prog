package com.example.retrofit_listes;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.retrofit_listes.http.RetrofitUtility;
import com.example.retrofit_listes.http.Service;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

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
        Call<List<Long>> call = service.Long("long");
        Response <List<Long>> response = call.execute();
        List<Long> resultat = response.body();
        Log.i("Retrofit",resultat.size()+"");

    }
}