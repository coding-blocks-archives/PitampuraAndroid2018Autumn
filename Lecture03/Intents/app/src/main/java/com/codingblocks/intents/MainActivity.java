package com.codingblocks.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Fruit {
        String getTaste() {
          return "tasteless";
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Fruit f = new Fruit() {
//            @Override
//            String getTaste() {
//                return "sweet";
//            }
//        };
//
//        Log.d("TASTE", f.getTaste());
//        Log.d("TASTE", f.getClass().getName());

        setContentView(R.layout.activity_main);
        Button btnOther = findViewById(R.id.button);
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Button Clicked!!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(i);
            }
        });
    }
}
