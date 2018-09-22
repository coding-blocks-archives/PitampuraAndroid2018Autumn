package com.codingblocks.pokeapi;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivityJava extends AppCompatActivity {

    String url = "https://pokeapi.co/api/v2/pokemon/1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeNetworkCall(url);
    }

    void makeNetworkCall(String url) {
        OkHttpClient client = new OkHttpClient();

        final Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                String jsonResponse = response.body().string();
                Gson gson = new Gson();

                Result result = gson.fromJson(jsonResponse, Result.class);

                ArrayList<Abilities> abilities = result.getAbilities();

//                for (int i=0; i< abilities.size(); i++){
//
//                    Abilities a = abilities.get(i);
//
//                }


                for (Abilities a : abilities) {
                    ClassesKt.globalFunc(a.getAbility().getName());
                }


            }
        });

    }

}
