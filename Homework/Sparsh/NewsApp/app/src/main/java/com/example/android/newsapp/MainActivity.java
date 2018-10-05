package com.example.android.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    String url = "https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=3d8f8c95ce344516a90998c5a9bb5d83";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNews = findViewById(R.id.btnNews);
        btnNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeNetworkCall(url);
            }
        });
    }
    private void makeNetworkCall(String url){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Toast.makeText(MainActivity.this, "Sorry,The Request Is Invalid", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //Response can only be consumed once
                final String result = response.body().string();
//                Gson gson = new Gson();
                   parseJson(result);
//                MediaType mediaType = MediaType.parse("applicaion/json")

                    //If i try to modify the text view here i won't be able to do so
                //this is some other thread than my Main/UI thread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        TextView textView =findViewById(R.id.tvResult);
                        textView.setText(result);
                        //This code Runs In the Main Thread
                    }
                });
            }
        });
    }
    public ArrayList<News> parseJson(String json){

        ArrayList<News> news = new ArrayList<>();

        try {
            JSONObject rootObject = new JSONObject(json);
            JSONArray itemsArray = rootObject.getJSONArray("articles");
            for(int i=0;i<itemsArray.length();i++){
                JSONObject currentObject = itemsArray.getJSONObject(i);
                String author = currentObject.optString("author");
                String title = currentObject.optString("title");
                String description = currentObject.optString("description");
                String url  = currentObject.optString("url");
                String urlToImage = currentObject.optString("urlToImage");
                String publishedAt = currentObject.optString("publishedAt");
                String content = currentObject.optString("content");

                News currentNews = new News(author,title,description,url,urlToImage,publishedAt,content);
                news.add(currentNews);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    return news;
    }
}
