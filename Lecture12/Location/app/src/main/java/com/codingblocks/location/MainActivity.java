package com.codingblocks.location;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements LocationListener {
    private static final String TAG = "MainActivity";
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnRequest = findViewById(R.id.bthRequest);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{
                                Manifest.permission.READ_CONTACTS
                        },
                        420);
            }
        });

        lm = (LocationManager) getSystemService(LOCATION_SERVICE);

//        LocationProvider lp = lm.getProvider(LocationManager.GPS_PROVIDER);
//        lp.

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //do whatever you want with the location
            startLocationUpdates(lm);
        } else {
            //request the location
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    },
                    12345);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 420:
                //handle call;
                break;
            case 12345:
                //Handle location
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    //attach the location listener
                    startLocationUpdates(lm);
                }
                break;
        }
    }

    @Override
    public void onLocationChanged(Location location) {

        Log.e(TAG, "onLocationChanged: Time " + location.getTime());
        Log.e(TAG, "onLocationChanged: Provider " + location.getProvider());
        Log.e(TAG, "onLocationChanged: Latitude " + location.getLatitude());
        Log.e(TAG, "onLocationChanged: Longitude" + location.getLongitude());
        //These three will be provided only by the GPS provider
        Log.e(TAG, "onLocationChanged: Speed " + location.getSpeed());
        Log.e(TAG, "onLocationChanged: Altitude " + location.getAltitude());
        Log.e(TAG, "onLocationChanged: Bearing " + location.getBearing());
        Log.e(TAG, "onLocationChanged: Accuracy " + location.getAccuracy());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @SuppressLint("MissingPermission")
    void startLocationUpdates(LocationManager lm) {

        //If you don't require updates continuously
//        lm.requestSingleUpdate(LocationManager.GPS_PROVIDER, this, null);

        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000,
                10,
                this);

        //Get the last known location from a provider
//        Location loc = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

//        lm.addProximityAlert();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Remove the listener when not in need to save battery
        lm.removeUpdates(this);
    }
}
