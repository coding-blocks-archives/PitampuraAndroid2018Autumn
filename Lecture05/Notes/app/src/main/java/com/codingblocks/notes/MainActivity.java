package com.codingblocks.notes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> notes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText noteTitle = findViewById(R.id.etNoteTitle);

        //Adding a view by JAVA
//        LinearLayout linearLayout = findViewById(R.id.linearLayout);
//
//        Button button = new Button(this);
//        button.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//
//        button.setText("New Button");
//        linearLayout.addView(button);


        //Here the EditText is empty so the String titleNote has the value ""
//        String titleNote = noteTitle.getText().toString();

        ListView listView = findViewById(R.id.listView);
        final NotesAdapter notesAdapter = new NotesAdapter(notes);

        listView.setAdapter(notesAdapter);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = noteTitle.getText().toString();
                String time = String.valueOf(System.currentTimeMillis());
                Note note = new Note(title, time);

                notes.add(note);
                notesAdapter.notifyDataSetChanged();

            }
        });
    }
}
