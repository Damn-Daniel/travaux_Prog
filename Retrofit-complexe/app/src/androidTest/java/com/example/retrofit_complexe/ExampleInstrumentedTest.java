package com.example.retrofit_complexe;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.w3c.dom.Element;

import static org.junit.Assert.*;

import com.example.retrofit_complexe.http.RetrofitUtility;
import com.example.retrofit_complexe.http.Service;
import com.example.retrofit_complexe.transfert.element;

import java.io.IOException;

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
        Call<element> call= service.element("whippsie");
        Response<element> response = call.execute();
        Log.i("Retrofit", String.valueOf(response.body().un));

    }
}