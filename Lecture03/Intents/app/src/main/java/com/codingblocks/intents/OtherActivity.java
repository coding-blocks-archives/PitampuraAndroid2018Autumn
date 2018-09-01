package com.codingblocks.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class OtherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        if (getIntent() != null) {
            ((TextView) findViewById(R.id.textView)).setText(getIntent().getStringExtra("hello"));
        }
    }
}
