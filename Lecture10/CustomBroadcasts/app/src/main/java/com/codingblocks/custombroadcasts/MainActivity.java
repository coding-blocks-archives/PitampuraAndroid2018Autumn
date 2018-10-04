package com.codingblocks.custombroadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver mbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Registering the receiver
        mbr = new MyBroadcastReceiver();
        final IntentFilter inf = new IntentFilter();
        inf.addAction(Intent.ACTION_POWER_CONNECTED);
        inf.addAction(Intent.ACTION_POWER_DISCONNECTED);
        inf.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        inf.addAction("mycustombroadcastreceiver");

        //Registers a local broadcast receiver which ensures that only your app's components are notified!
        LocalBroadcastManager.getInstance(this).registerReceiver(mbr, inf);

//        registerReceiver(mbr, inf);

        final EditText etMessage = findViewById(R.id.etMessage);
        Button btnSend = findViewById(R.id.sendMessage);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Send a custom BroadCast
                Intent intent = new Intent();
                intent.setAction("mycustombroadcastreceiver");
                intent.putExtra("KEY", etMessage.getText().toString());
                LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);

                //Sends an ordered broadcast to other apps (the intent data might change)!
//                sendOrderedBroadcast(intent,"");
//                sendBroadcast(intent);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mbr);
//        unregisterReceiver(mbr);
    }
}