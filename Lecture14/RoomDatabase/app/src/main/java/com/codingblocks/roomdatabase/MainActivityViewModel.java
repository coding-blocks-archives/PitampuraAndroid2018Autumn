package com.codingblocks.roomdatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    //Activity Context, Views should not be there

    private LiveData<List<Note>> liveNotes;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Note>> getLiveNotes() {
        if (liveNotes == null) {
            NotesDao notesDao = NoteApplication.getNoteDatabase(getApplication())
                    .getNotesDao();
            liveNotes = notesDao.getAllNotes();
        }

        return liveNotes;
    }
}
