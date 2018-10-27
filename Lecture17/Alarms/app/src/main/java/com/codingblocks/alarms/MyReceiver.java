package com.codingblocks.alarms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("TAG", "onStartCommand: ");
        Toast.makeText(context, "Timer triggered", Toast.LENGTH_SHORT).show();
    }
}
