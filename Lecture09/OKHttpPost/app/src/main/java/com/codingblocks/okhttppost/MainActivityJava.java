package com.codingblocks.okhttppost;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

public class MainActivityJava extends AppCompatActivity {
    OkHttpClient client;
    String url = "https://pokeapi.co/api/v2/pokemon/1";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        makeNetworkCall(url);
    }

    void makeNetworkCall(String url) {

        client = new OkHttpClient();

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

                String abilitiesJson = gson.toJson(abilities);

                Log.e("TAG", "onResponse: " + jsonResponse);
                postToServer(abilitiesJson);
            }
        });

    }

    public void postToServer(String data) {

        MediaType mediaType = MediaType.parse("application/json");

        RequestBody requestBody = RequestBody.create(mediaType, data);

        Request request = new Request.Builder()
                .url("http://ptsv2.com/t/dxbf9-1537682097/post")
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.e("TAG", "onResponse : " + response.body().string());

            }
        });

    }

}
