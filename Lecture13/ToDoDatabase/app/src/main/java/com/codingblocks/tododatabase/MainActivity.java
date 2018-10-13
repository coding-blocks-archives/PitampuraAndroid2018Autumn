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

        //Clicked the add button

        Note note = new Note("Hello", "First Entry", "" + System.currentTimeMillis(), 0);

        //Insert the note into the db
        Note insertedNote = notesDatabaseHelper.insert(note);

        //Get the inserted note back from the db
//        Note insertedNote = notesDatabaseHelper.getNoteById(insertedID);

        //Add the retrieved note to your ArrayList and notify the adapter

        ArrayList<Note> notes = notesDatabaseHelper.getAllNotes();

//        Note note = notesDatabaseHelper.getNoteById(2L);

        Log.e("TAG", "onCreate: " + note.getId());

        Log.e("TAG", "onCreate: " + notes.size());
    }
}
