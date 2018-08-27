package com.codingblocks.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);
    }

//    public void changeText(View view) {
//        TextView textView = findViewById(R.id.textView);
//        textView.setText("I'm Harshit!");
//    }

    public void decrement(View view) {
        TextView textView = findViewById(R.id.tvCount);
        switch (view.getId()){
            case R.id.increment :
                count++;
                textView.setText(String.valueOf(count));
                break;
            case R.id.decrement :
                count--;
                textView.setText(String.valueOf(count));
                break;
            case R.id.btnReset :
                count = 0;
                textView.setText(String.valueOf(count));
                break;
        }
        //decrement
//        count--;
//        TextView textView = findViewById(R.id.tvCount);
//        textView.setText(String.valueOf(count));
    }

//    public void increment(View view) {
//        count++;
//        TextView textView = findViewById(R.id.tvCount);
//        textView.setText(String.valueOf(count));
//    }
//
//    public void reset(View view) {
//        count = 0;
//        TextView textView = findViewById(R.id.tvCount);
//        textView.setText(String.valueOf(count));
//    }
}
