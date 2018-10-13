package com.codingblocks.tododatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class NotesDatabaseHelper extends SQLiteOpenHelper {

    public NotesDatabaseHelper(Context context) {
        super(context, "notesDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE task_table (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT NOT NULL, " +
                "content TEXT NOT NULL, " +
                "timeStamp TEXT NOT NULL, " +
                "isDone INTEGER);");
    }

    public Note insert(Note note) {
        //Insert the note into the table
        ContentValues contentValues = new ContentValues();

        contentValues.put("title", note.getTitle());
        contentValues.put("content", note.getDescription());
        contentValues.put("timeStamp", note.getTimeStamp());
        contentValues.put("isDone", note.getIsDone());

        long id = getWritableDatabase().insert("task_table",
                null
                , contentValues);



        return getNoteById(id);
    }

    public void updateNote(Note note) {

        ContentValues contentValues = new ContentValues();

        contentValues.put("title", note.getTitle());
        contentValues.put("content", note.getDescription());
        contentValues.put("timeStamp", note.getTimeStamp());
        contentValues.put("isDone", note.getIsDone());

        getWritableDatabase().update("task_table",
                contentValues,
                "id = ?",
                new String[]{note.getId().toString()});

    }

    public void deleteNote(Note note) {
        getWritableDatabase().delete("task_table",
                "id = ?",
                new String[]{note.getId().toString()});
    }

    public Note getNoteById(Long noteId) {

        Note note = null;

        Cursor c = getReadableDatabase().query("task_table",
                null,
                "id = ?",
                new String[]{noteId.toString()},
                null,
                null,
                null);

        if (c.moveToNext()) {
            Integer id = c.getInt(0);
            String title = c.getString(1);
            String description = c.getString(c.getColumnIndex("content"));
            String timeStamp = c.getString(c.getColumnIndex("timeStamp"));
            Integer isDone = c.getInt(c.getColumnIndex("isDone"));

            note = new Note(title, description, timeStamp, isDone, id);
        }

        c.close();
        return note;
    }

    public ArrayList<Note> getAllNotes() {

        ArrayList<Note> notes = new ArrayList<>();
        //Populate the notes ArrayList

        Cursor c = getReadableDatabase().query(
                "task_table",
                null,
                null,
                null,
                null,
                null,
                "timeStamp DESC"
        );


        while (c.moveToNext()) {

            Integer id = c.getInt(0);
            String title = c.getString(1);
            String description = c.getString(c.getColumnIndex("content"));
            String timeStamp = c.getString(c.getColumnIndex("timeStamp"));
            Integer isDone = c.getInt(c.getColumnIndex("isDone"));

            Note note = new Note(title, description, timeStamp, isDone, id);

            notes.add(note);
        }

        c.close();
        return notes;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
