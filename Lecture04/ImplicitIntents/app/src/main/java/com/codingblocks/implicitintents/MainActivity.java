package com.codingblocks.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBrowser = findViewById(R.id.openBrowser);
        btnBrowser.setOnClickListener(this);

        Button button = findViewById(R.id.openActivity);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent();
                //kuch kuch
                i.setAction("com.codingblocks.implicitintents.ThirdActivity");
                startActivity(i);

            }
        });

    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent();
        i.setAction(Intent.ACTION_VIEW);
        i.setData(Uri.parse("https://www.google.com"));

        startActivity(i);
    }
}
