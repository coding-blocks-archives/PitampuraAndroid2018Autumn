package com.codingblocks.asynctasknetworking;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute("https://www.google.com");
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

            TextView textView = findViewById(R.id.tvResult);
            ProgressBar pb = findViewById(R.id.progressBar);
            textView.setVisibility(View.VISIBLE);
            textView.setText(s);
            pb.setVisibility(View.GONE);
        }
    }
}
