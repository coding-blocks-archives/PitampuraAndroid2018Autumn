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

    GoogleMap map;

    // Obtain the SupportMapFragment and get notified when the map is ready to be used.
    SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //do whatever you want with the location
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION
                    },
                    12345);

        } else {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(final GoogleMap googleMap) {

        googleMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this,
                R.raw.style_json));

        map = googleMap;

        startLocationUpdates((LocationManager) getSystemService(LOCATION_SERVICE));

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 12345:
                //Handle location
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                    //attach the location listener
                    mapFragment.getMapAsync(this);
                }
                break;
        }
    }

    LatLng lastPos = null;
    Marker lastMarker = null;

    @Override
    public void onLocationChanged(Location location) {

        //Move the map to the lat/lng
        //Add a marker to the lat/lng
        //Draw a path from the last pos to the new lat/lng
        //(Optional) Remove the marker from the last lat/lng

        LatLng currentPos = new LatLng(location.getLatitude(), location.getLongitude());

        if (lastPos == null) lastPos = currentPos;

        map.animateCamera(CameraUpdateFactory.newLatLng(currentPos));
        Marker currentMarker = map.addMarker(new MarkerOptions().position(currentPos));

        map.addPolyline(new PolylineOptions().add(lastPos, currentPos));

        if (lastMarker != null) {
            lastMarker.remove();
        }

        lastMarker = currentMarker;
        lastPos = currentPos;
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
