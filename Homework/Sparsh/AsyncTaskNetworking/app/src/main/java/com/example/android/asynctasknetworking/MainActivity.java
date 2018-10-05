package com.example.android.asynctasknetworking;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       MyAsyncTask myAsyncTask = new MyAsyncTask();
       myAsyncTask.doInBackground("https://www.google.com");
    }
    class MyAsyncTask extends AsyncTask<String,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String inputUrl = strings[0];

            try {
                //Convert The String To Url Object
                URL url = new URL(inputUrl);
                //open a connection with the URL and Save the instance as httpUrlConnection Object
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                //Get the inputStream from the connection we have above
                InputStream is = httpURLConnection.getInputStream();
                //Create a scanner from the above connection
                Scanner scanner = new Scanner(is);
                //The \\A delimiter
                scanner.useDelimiter("\\A");
                String response ="";
                if(scanner.hasNext()){
                    response = scanner.next();
                }
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        @Override
        protected void onPostExecute(String s) {

            ProgressBar progressBar = findViewById(R.id.progressBar2);
            TextView textView = findViewById(R.id.textView);
            textView.setText(s);


        }
    }
}

