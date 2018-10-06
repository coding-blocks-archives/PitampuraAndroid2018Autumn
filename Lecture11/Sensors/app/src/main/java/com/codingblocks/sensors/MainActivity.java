package com.codingblocks.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    public static final String TAG = "MAINACTIVITY";
    SensorManager sm;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        constraintLayout = findViewById(R.id.rootLayout);

        List<Sensor> sensors = sm.getSensorList(Sensor.TYPE_ALL);

//        Log.e(TAG, "Number of sensors : " + sensors.size());
//
//        for (Sensor s : sensors) {
//            Log.e(TAG, ": " + s.toString());
//        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Sensor acceleroMeter = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        Sensor proximitySensor = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        sm.registerListener(this,
                acceleroMeter,
                SensorManager.SENSOR_DELAY_UI);

//        sm.registerListener(this,
//                proximitySensor,
//                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] sensorValue = event.values;

        switch (event.sensor.getType()) {
            case Sensor.TYPE_GRAVITY:
                Log.e(TAG, "Gravity in x : " + sensorValue[0]);
                Log.e(TAG, "Gravity in y : " + sensorValue[1]);
                Log.e(TAG, "Gravity in z : " + sensorValue[2]);

                int red = (int) ((sensorValue[0] / 9.8) * 255);
                int green = (int) ((sensorValue[1] / 9.8) * 255);
                int blue = (int) ((sensorValue[2] / 9.8) * 255);

                //Write a logic to convert the gravity values to RGB (0-255)

                int color = Color.rgb(red, green, blue);
                constraintLayout.setBackgroundColor(color);

                break;
//            case Sensor.TYPE_PROXIMITY :
//                Log.e(TAG, "Proximity distance  : "  + sensorValue[0]);
//                break;
        }
        Log.e(TAG, "onSensorChanged: ");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //In case the type of sensor changes due to system configuration
    }

    //Remove the listener when not in need
    @Override
    protected void onStop() {
        super.onStop();
        sm.unregisterListener(this);
    }
}
