package com.avi.abhishek.notetakingapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        ListView listView;
        listView = findViewById(R.id.listView);


        notes= loadArray(this);

        final NotesAdapter notesAdapter = new NotesAdapter(notes);

        listView.setAdapter(notesAdapter);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title,time;
                title = noteTitle.getText().toString();
                noteTitle.setText("");

                time = String.valueOf(System.currentTimeMillis());
                Note note = new Note(title, time);

                notes.add(note);
                notesAdapter.notifyDataSetChanged();

            }
        });
    }

    @Override
    protected void onStop() {

        saveArray();
        super.onStop();
    }



    public void saveArray() {
        SharedPreferences sp = getSharedPreferences("my_pref", MODE_PRIVATE);
        SharedPreferences.Editor mEdit1 = sp.edit();

        mEdit1.putInt("Status_size", notes.size());

        for (int i = 0; i < notes.size(); i++) {
            //  mEdit1.remove("Status_" + i);
            mEdit1.putString("Note_Message"+i , String.valueOf(notes.get(i).getTitle()));
            mEdit1.putString("Note_Time"+i , String.valueOf(notes.get(i).getTime()));
        }

        mEdit1.apply();
    }


    public ArrayList<Note> loadArray(Context mContext) {
//        SharedPreferences mSharedPreference1 =   PreferenceManager.getDefaultSharedPreferences(mContext);

        ArrayList<Note> notesArrayList =new ArrayList<>();
        SharedPreferences mSharedPreference1 = getSharedPreferences("my_pref", MODE_PRIVATE);
        notes.clear();
        int size = mSharedPreference1.getInt("Status_size", 0);

        for (int i = 0; i < size; i++) {
            String notes_mesg = mSharedPreference1.getString("Note_Message"+i, null);
            String notes_time = mSharedPreference1.getString("Note_Time"+i, null);

            Log.e("TAG", "loadArray: ---------"+notes_mesg+"--"+notes_time);
            Log.e("TAG", "loadArray111111: ********"+notesArrayList.size() );

            notesArrayList.add(new Note(notes_mesg, notes_time));

            Log.e("TAG", "loadArray222222: ********"+notesArrayList.size() );
        }

        return notesArrayList;
    }
}

