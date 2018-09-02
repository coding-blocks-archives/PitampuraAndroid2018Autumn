package com.codingblocks.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnClick);

//        View.OnClickListener onClickListener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        };
//
//        OnClickListenerImpl onClickListener = new OnClickListenerImpl();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),DetailActivity.class);
                startActivity(i);
            }
        });

//        btn.setOnClickListener(onClickListener);
//        btn.setOnClickListener();

    }

//    public void startDetailActivity(View view) {
//
//    }
}
