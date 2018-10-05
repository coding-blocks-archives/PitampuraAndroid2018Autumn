package com.example.android.heterogenousrv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Object> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayList.add(new TextClass("Hello", "World"));
        arrayList.add(new ImageClass("Hello", "World", "https://randomuser.me/api/portraits/women/44.jpg"));
        arrayList.add(new ImageClass("Hello2", "World2", "https://randomuser.me/api/portraits/women/40.jpg"));
        arrayList.add(new TextClass("Hello1", "World"));
        arrayList.add(new TextClass("Hello2", "World"));
        arrayList.add(new TextClass("Hello3", "World"));
        arrayList.add(new ImageClass("Hello3", "World3", "https://randomuser.me/api/portraits/women/35.jpg"));
        arrayList.add(new ImageClass("Hello4", "World4", "https://randomuser.me/api/portraits/women/33.jpg"));
        arrayList.add(new ImageClass("Hello5", "World5", "https://randomuser.me/api/portraits/women/32.jpg"));
        arrayList.add(new ImageClass("Hello6", "World6", "https://randomuser.me/api/portraits/women/50.jpg"));
        arrayList.add(new TextClass("Hello4", "World"));
        arrayList.add(new TextClass("Hello5", "World"));
        arrayList.add(new TextClass("Hello6", "World"));
        arrayList.add(new ImageClass("Hello7", "World7", "https://randomuser.me/api/portraits/women/39.jpg"));
        arrayList.add(new ImageClass("Hello8", "World8", "https://randomuser.me/api/portraits/women/60.jpg"));
        arrayList.add(new ImageClass("Hello9", "World9", "https://randomuser.me/api/portraits/women/61.jpg"));
        arrayList.add(new ImageClass("Hello10", "World10", "https://randomuser.me/api/portraits/women/62.jpg"));
        arrayList.add(new ImageClass("Hello11", "World11", "https://randomuser.me/api/portraits/women/65.jpg"));
        arrayList.add(new ImageClass("Hello12", "World12", "https://randomuser.me/api/portraits/women/63.jpg"));
        arrayList.add(new ImageClass("Hello13", "World13", "https://randomuser.me/api/portraits/women/66.jpg"));
        arrayList.add(new ImageClass("Hello14", "World14", "https://randomuser.me/api/portraits/women/54.jpg"));
        arrayList.add(new TextClass("Hello7", "World"));
        arrayList.add(new TextClass("Hello8", "World"));
        arrayList.add(new TextClass("Hello9", "World"));
        arrayList.add(new TextClass("Hello10", "World"));
        arrayList.add(new ImageClass("Hello13", "World13", "https://randomuser.me/api/portraits/women/66.jpg"));
        arrayList.add(new ImageClass("Hello14", "World14", "https://randomuser.me/api/portraits/women/54.jpg"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        HeterogeneousAdapter heterogeneousAdapter = new HeterogeneousAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(heterogeneousAdapter);



    }
}
