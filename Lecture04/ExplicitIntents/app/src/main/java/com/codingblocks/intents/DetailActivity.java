package com.codingblocks.intents;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    //The activity is partially visible and another activity is in the foreground
    @Override
    protected void onPause() {
        super.onPause();
    }

    //The activity is no longer visible
    @Override
    protected void onStop() {
        super.onStop();
    }

    //Called when the activity is about to be destroyed.
    //Note : This isn't guaranteed to be called always
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
