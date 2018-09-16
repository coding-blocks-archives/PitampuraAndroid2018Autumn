package com.codingblocks.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.tvText);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //At one time only 5-6 tasks can run in parallel, rest are pushed to a queue
                //from where they are fetched once a particular task has finished execution
                MyTask myTask = new MyTask();
                myTask.execute(9000000);

//                MyTask myTask2 = new MyTask();
//                myTask2.doInBackground(9000);

                MyTask myTask1 = new MyTask();
                myTask1.execute(5000);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            MainActivity.this.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    textView.setText("Running the thread");
//                                }
//                            });
//                            Log.e("TAG", "Running the thread ");
//                            Thread.sleep(2000);
//                            Log.e("TAG", "Thread ran ");
//                            MainActivity.this.runOnUiThread(new Runnable() {
//                                @Override
//                                public void run() {
//                                    textView.setText("Thread ran");
//                                }
//                            });
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }).start();
            }
        });
    }


    class MyTask extends AsyncTask<Integer, Float, String> {

        //Runs on the main thread
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView.setText("Starting the work");
        }

        //This runs in a new Thread
        @Override
        protected String doInBackground(Integer... integers) {
            int input = integers[0];

            Log.e("TAG", "doInBackground: " );

            for (int i = 0; i < input; i++) {
                if (i % 100 == 0) {
                    publishProgress((float) i);
                }
            }
            return "Counting done!";
        }

        //Runs on the main thread
        @Override
        protected void onProgressUpdate(Float... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0].toString());
        }

        //Runs on the main thread
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
        }

    }


}
