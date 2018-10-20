package com.codingblocks.roomdatabase;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Don't pass your activity's context since that may cause memory leaks
        NoteDatabase database = NoteApplication.getNoteDatabase(getApplicationContext());

        //Assuming that I have a note object,
//        database.getNotesDao().insertNotes();


        MainActivityViewModel mainActivityViewModel = ViewModelProviders
                .of(this)
                .get(MainActivityViewModel.class);

        final List<Note> originalNotes = new ArrayList<>();

        //NoteAdapter notesAdapter = new NoteAdapter(notes);

        //Set adapter to your recyclerview

        LiveData<List<Note>> liveNotes = mainActivityViewModel.getLiveNotes();

        liveNotes.observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                //Set the list to your adapter
                //Notify data change

                notes.removeAll(originalNotes);
                originalNotes.addAll(notes);

//                //notify the adapter
            }
        });


//        LiveData<List<Note>> liveNotes = database.getNotesDao().getAllNotes();

//        List<Note> notes = liveNotes.getValue();

//        liveNotes.observe(this, new Observer<List<Note>>() {
//            @Override
//            public void onChanged(@Nullable List<Note> notes) {
//
//                //Set the list to your adapter
//                //Notify data change
//
//                notes.removeAll(originalNotes);
//                originalNotes.addAll(notes);
//
//                //notify the adapter
//            }
//        });

    }
}
