package com.example.android.broadcasts;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MyBroadcastReceiver mbr;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter inf = new IntentFilter();
        inf.addAction(Intent.ACTION_POWER_CONNECTED);
        inf.addAction("CustomBroadcast");
        Button btnStart = findViewById(R.id.btnCheck);
        btnStart.setOnClickListener(this);
        LocalBroadcastManager.getInstance(this).registerReceiver(mbr,inf);
        mbr = new MyBroadcastReceiver();
        editText = findViewById(R.id.etInput);
    }

    @Override
    public void onClick(View v) {
        Intent intent =new Intent();
        intent.putExtra("Key",editText.getText().toString());
        LocalBroadcastManager.getInstance(getBaseContext()).sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mbr);
    }
}
