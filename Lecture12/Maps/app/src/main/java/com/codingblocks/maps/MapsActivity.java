package com.codingblocks.maps;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, LocationListener {

    private static final String TAG = "MainActivity";
    LocationManager lm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        lm = (LocationManager) getSystemService(LOCATION_SERVICE);

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
    public void onMapReady(final GoogleMap googleMap) {

        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this,
                R.raw.style_json));

        final LatLng delhi = new LatLng(28.7041, 77.1025);

        MarkerOptions markerOptions = new MarkerOptions()
                .title("New Delhi")
                .position(delhi)
                .draggable(true);

        googleMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {

            LatLng initialPos = delhi;

            @Override
            public void onMarkerDragStart(Marker marker) {
            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {
                LatLng finalPos = marker.getPosition();

                googleMap.addPolyline(new PolylineOptions()
                        .add(initialPos, finalPos)
                        .color(Color.rgb(54, 178, 74))
                        .width(1.5f));

                googleMap.animateCamera(CameraUpdateFactory.newLatLng(finalPos));
                initialPos = finalPos;

            }
        });

       googleMap.addMarker(markerOptions);

        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(delhi, 9));
//
//        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(delhi,9));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
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

        //Move the map to the lat/lng
        //Add a marker to the lat/lng
        //Draw a path from the last pos to the new lat/lng
        //(Optional) Remove the marker from the last lat/lng


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
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                1000,
                10,
                this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Remove the listener when not in need to save battery
        lm.removeUpdates(this);
    }

}
