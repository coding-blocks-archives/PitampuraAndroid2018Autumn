package com.example.android.keepit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<KeepV> notes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.etNote);

        final KeepAdapter keepAdapter = new KeepAdapter(notes);
        ListView listView =findViewById(R.id.ListView);

        listView.setAdapter(keepAdapter);
        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Title = editText.getText().toString();
                String Time = String.valueOf(System.currentTimeMillis());

                KeepV keepV =new KeepV(Title,Time);
                notes.add(keepV);
                keepAdapter.notifyDataSetChanged();
            }
        });
    }
}
