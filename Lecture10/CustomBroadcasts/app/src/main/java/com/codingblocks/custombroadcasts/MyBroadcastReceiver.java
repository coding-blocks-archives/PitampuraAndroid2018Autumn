package com.codingblocks.custombroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //Advice : Start another android component here, don't do any long running task here!!!

        //In case you want to do a long running task here
        PendingResult pr = goAsync();

        //Do some Long running ASYNC work here

        //Notify the system to kill this broadcast once the work is done
        pr.finish();

        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Airplane mode toggled", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Power Connected", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Power Disconnected", Toast.LENGTH_SHORT).show();
                break;
            case "mycustombroadcastreceiver":
                String input = intent.getStringExtra("KEY");
                Toast.makeText(context, "My custom broadcast event with name " + input + " received", Toast.LENGTH_SHORT).show();
        }
//        context.startActivity(new Intent(context,MainActivity.class));
    }
}
