package com.example.android.menu;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.design.widget.BottomNavigationView;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId()) {
                   case R.id.actionSettings:
                       Toast.makeText(getBaseContext(), "Settings", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.actionAbout:
                       Toast.makeText(getBaseContext(), "About", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.actionHelp:
                       Toast.makeText(getBaseContext(), "Help", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.actionHome:
                       Toast.makeText(getBaseContext(), "Home", Toast.LENGTH_SHORT).show();
                       break;
                   case R.id.actionRefresh:
                       Toast.makeText(getBaseContext(), "Refresh", Toast.LENGTH_SHORT).show();
                       break;
               }
               return true;
           }
       });


    }@Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu,menu);
            return true;
        }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionSettings:
                Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionAbout:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionHelp:
                Toast.makeText(this, "Help", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionHome:
                Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show();
                break;
            case R.id.actionRefresh:
                Toast.makeText(this, "Refresh", Toast.LENGTH_SHORT).show();
                break;
        }
        return false;
    }
}

