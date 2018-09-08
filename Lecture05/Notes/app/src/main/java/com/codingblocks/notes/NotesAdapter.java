package com.codingblocks.notes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {

    ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Note getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View inflatedView = li.inflate(R.layout.item_row, parent, false);

//        Note currentNote = notes.get(position);
        Note currentNote = getItem(position);

        TextView noteTitle, noteTime;
        noteTitle = inflatedView.findViewById(R.id.textViewTitle);
        noteTime = inflatedView.findViewById(R.id.textViewTime);

        noteTitle.setText(currentNote.getTitle());
        noteTime.setText(currentNote.getTime());

        return inflatedView;
    }

}
