package com.example.android.keepit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class KeepAdapter extends BaseAdapter {
    ArrayList<KeepV> notes;

    public KeepAdapter(ArrayList<KeepV> notes) {
        this.notes = notes;
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public KeepV getItem(int position) {
        return notes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater li =LayoutInflater.from(parent.getContext());
        View inflatedView;

        if(convertView == null){
            inflatedView = li.inflate(R.layout.item_row,parent,false);
        }else{
            inflatedView = convertView;
        }
        final KeepV currentNote = getItem(position);
        TextView noteTitle = inflatedView.findViewById(R.id.noteTitle);
        TextView noteTime = inflatedView.findViewById(R.id.noteTime);

        Button btnDelete =inflatedView.findViewById(R.id.btndelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notes.remove(position);
                notifyDataSetChanged();
            }
        });
        noteTime.setText(currentNote.getTime());
        noteTitle.setText(currentNote.getTitle());
        return inflatedView;
    }
}
