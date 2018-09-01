package com.codingblocks.intents;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class Fruit {
        String getTaste() {
          return "tasteless";
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Fruit f = new Fruit() {
//            @Override
//            String getTaste() {
//                return "sweet";
//            }
//        };
//
//        Log.d("TASTE", f.getTaste());
//        Log.d("TASTE", f.getClass().getName());

        setContentView(R.layout.activity_main);
        Button btnOther = findViewById(R.id.button);
        btnOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "Button Clicked!!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(MainActivity.this, OtherActivity.class);
                i.putExtra("hello", "world");
                startActivity(i);
            }
        });
        Button btnDialog = findViewById(R.id.btnDialog);
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("SOME ALERT")
                        .setMessage("This to tell something happened.")
                        .setCancelable(false)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "OK CLICKED", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(MainActivity.this, "CANCEL CLICKED", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }
}
