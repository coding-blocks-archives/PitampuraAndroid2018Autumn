package com.codingblocks.broadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBroadcastReceiver mbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStart = findViewById(R.id.btnStart);
        Button btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        mbr = new MyBroadcastReceiver();
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.btnStart) {
            //Register the Receiver

            IntentFilter inf = new IntentFilter();
            inf.addAction(Intent.ACTION_POWER_CONNECTED);
            inf.addAction(Intent.ACTION_POWER_DISCONNECTED);
            inf.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

            registerReceiver(mbr, inf);

        } else if (v.getId() == R.id.btnStop) {
            //Unregister the receiver
            unregisterReceiver(mbr);
        }
    }
}
