package com.codingblocks.asynctasknetworking;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> responseArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText = findViewById(R.id.etName);
        Button btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://api.github.com/search/users?q=" + editText.getText().toString();

                MyAsyncTask myAsyncTask = new MyAsyncTask();
                myAsyncTask.execute(url);
            }
        });
    }

    //After onStop
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("KEY", responseArrayList);
    }

    //After onCreate
    //This depends on the user's intention, if the user wants to kill the app, this won't be called in the next app,
    //launch else it will be
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        responseArrayList = savedInstanceState.getParcelableArrayList("KEY");
        RecyclerView recyclerView = findViewById(R.id.rvUsers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        GithubAdapter githubAdapter = new GithubAdapter(responseArrayList);

        recyclerView.setAdapter(githubAdapter);
    }

    class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected String doInBackground(String... strings) {
            //Make a Network call
            String inputUrl = strings[0];

            try {
                //Convert the string to a URL object
                URL url = new URL(inputUrl);
                //Open a connection with the URL and save the instance as a HttpURLConnection Object
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                //Get the inputStream from the connection we have above
                InputStream is = httpURLConnection.getInputStream();
                //Create a Scanner from the stream above
                Scanner scanner = new Scanner(is);

                //The \\A delimiter instructs the Scanner
                // to read the entire content of the inputstream in one go
                scanner.useDelimiter("\\A");

                String response = "";
                //If the scanner has something to read, read it all in one go
                if (scanner.hasNext()) {
                    response = scanner.next();
                }
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
                Log.e("TAG", "Wrong URL entered!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            responseArrayList = parseJson(s);
            RecyclerView recyclerView = findViewById(R.id.rvUsers);
            recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
            GithubAdapter githubAdapter = new GithubAdapter(responseArrayList);

            recyclerView.setAdapter(githubAdapter);

        }
    }

    public ArrayList<Item> parseJson(String input) {

        ArrayList<Item> itemArrayList = new ArrayList<>();

        try {
            JSONObject rootObject = new JSONObject(input);
            JSONArray itemsArray = rootObject.getJSONArray("items");

            for (int i = 0; i < itemsArray.length(); i++) {
                JSONObject currentObject = itemsArray.getJSONObject(i);

                String login = currentObject.getString("login");
                String id = currentObject.getString("id");
                String avatarUrl = currentObject.getString("avatar_url");
                String url = currentObject.getString("url");
                String reposUrl = currentObject.getString("repos_url");
                String score = currentObject.getString("score");
                Item currentItem = new Item(login, id, avatarUrl, url, score, reposUrl);
                itemArrayList.add(currentItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return itemArrayList;
    }

}
