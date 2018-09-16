package com.codingblocks.decoupledfragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements Communicator {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void handleClick(String input) {
        FrameLayout container = findViewById(R.id.container);

        if (container == null) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("KEY", input);
            startActivity(intent);
        } else {
            FragmentB fragmentB = FragmentB.newInstance(input);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, fragmentB)
                    .commit();
        }


    }
}
