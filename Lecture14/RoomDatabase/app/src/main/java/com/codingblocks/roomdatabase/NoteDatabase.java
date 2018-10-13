package com.codingblocks.roomdatabase;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NotesDao getNotesDao();

    public abstract UserDao getUserDao();

}
