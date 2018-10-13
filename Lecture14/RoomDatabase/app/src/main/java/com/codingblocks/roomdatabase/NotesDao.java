package com.codingblocks.roomdatabase;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface NotesDao {

//    @Insert
//    void insertNote(Note note);

    @Insert
    List<Long> insertNotes(Note... notes);

    @Delete
    void deleteNote(Note note);

    @Query("SELECT * FROM noteTable")
    LiveData<List<Note>> getAllNotes();

    @Query("SELECT * FROM noteTable WHERE id = :id")
    Note getNoteById(Long id);

    @Update
    void updateNote(Note note);
}
