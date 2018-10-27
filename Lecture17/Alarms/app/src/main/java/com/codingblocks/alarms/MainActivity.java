package com.codingblocks.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Button btnSchedule = findViewById(R.id.btnAlarm);
        final EditText etTimer = findViewById(R.id.etTime);

        Intent intent = new Intent(this, MyReceiver.class);

        final PendingIntent pi = PendingIntent.getBroadcast(this,
                995,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long time = Long.parseLong(etTimer.getText().toString());

                //Run an exact Elapsed Alarm at the given time from now
                alarmManager.set(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime() + time,
                        pi);

                //Run an exact repeating Elapsed Alarm at the given time from now
                //and repeat it every day
                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime() + time,
                        AlarmManager.INTERVAL_DAY,
                        pi);

                //Run an exact repeating Elapsed Alarm at the given time from now
                //and repeat it after every 20 mins
                alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime() + time,
                        10 * 60 * 60 * 1000,
                        pi);

                //Run an exact repeating Elapsed Alarm at the given time from now
                //and repeat it after every 15 mins
                alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime() + time,
                        AlarmManager.INTERVAL_FIFTEEN_MINUTES, //You can only use predefined values here
                        pi);

                //Schedules an inexact alarm which will be fired at the given time from now with a window of 10 seconds
                alarmManager.setWindow(
                        AlarmManager.ELAPSED_REALTIME,
                        SystemClock.elapsedRealtime() + time,
                        100000,
                        pi
                );
            }
        });

    }
}
