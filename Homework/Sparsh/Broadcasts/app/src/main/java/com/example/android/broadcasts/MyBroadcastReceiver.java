package com.example.android.broadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

//        Toast.makeText(context, "The Broadcast Will show "+intent.getStringExtra("Key")+" As you send it", Toast.LENGTH_SHORT).show();
        
    }
}
