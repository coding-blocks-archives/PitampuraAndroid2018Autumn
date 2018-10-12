package com.codingblocks.tododatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotesDatabaseHelper notesDatabaseHelper = new NotesDatabaseHelper(this);

        notesDatabaseHelper.insert(new Note("Hello", "First Entry", "" + System.currentTimeMillis(), 0));
        notesDatabaseHelper.insert(new Note("Hello", "First Entry", "" + System.currentTimeMillis(), 0));
        notesDatabaseHelper.insert(new Note("Hello", "First Entry", "" + System.currentTimeMillis(), 0));
        notesDatabaseHelper.insert(new Note("Hello", "First Entry", "" + System.currentTimeMillis(), 0));
        notesDatabaseHelper.insert(new Note("Hello", "First Entry", "" + System.currentTimeMillis(), 0));


        ArrayList<Note> notes = notesDatabaseHelper.getAllNotes();

        Note note = notesDatabaseHelper.getNoteById(2);

        Log.e("TAG", "onCreate: " + note.getId());

        Log.e("TAG", "onCreate: " + notes.size());
    }
}
