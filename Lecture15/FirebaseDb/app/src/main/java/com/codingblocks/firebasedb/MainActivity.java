package com.codingblocks.firebasedb;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    ArrayList<Note> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btnCloseActivity);

        final EditText etMessage = findViewById(R.id.etMessage);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = etMessage.getText().toString();

                //Send the message to firebase
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

                DatabaseReference rootRef = firebaseDatabase.getReference();

                rootRef.push()
                        .setValue(new Note(message,
                                "Subtitle is " + message,
                                "" + System.currentTimeMillis()));
            }
        });

        Button btnFetch = findViewById(R.id.btnFetch);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Fetch the data from the DatabaseReference
                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

                rootRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        arrayList.clear();

                        Iterable<DataSnapshot> data = dataSnapshot.getChildren();

                        for (DataSnapshot ds : data) {
                            Note note = ds.getValue(Note.class);
                            arrayList.add(note);
                            Log.e("TAG", "onDataChange: Note Title " + note.title);
                            Log.e("TAG", "onDataChange: Note Subtitle " + note.subtitle);
                            Log.e("TAG", "onDataChange: Note Time " + note.time);
                        }

                        //ArrayList has some size

                        Log.e("TAG", "onDataChange: ArrayList size : " + arrayList.size());


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });


        Button btnFetchChild = findViewById(R.id.btnFetchChild);

        btnFetchChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();

                rootRef.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        Note note = dataSnapshot.getValue(Note.class);

                        Log.e("TAG", "onDataChange: Note Title " + note.title);
                        Log.e("TAG", "onDataChange: Note Subtitle " + note.subtitle);
                        Log.e("TAG", "onDataChange: Note Time " + note.time);

                        arrayList.add(note);

                        Log.e("TAG", "onChildAdded: arraylist size " + arrayList.size());

                    }

                    @Override
                    public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
