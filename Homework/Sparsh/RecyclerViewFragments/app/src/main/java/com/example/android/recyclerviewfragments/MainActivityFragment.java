package com.example.android.recyclerviewfragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class MainActivityFragment extends Fragment {
    ArrayList<Planetclass> arrayList  = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arrayList.add(new Planetclass("Mercury","1","https://www.google.co.in/search?rlz=1C1NHXL_enIN751IN751&biw=1396&bih=649&tbm=isch&sa=1&ei=WwGgW9u3LsX8vgSbjJGIBg&q=Mercury&oq=Mercury&gs_l=img.3...1464.1464.0.1657.0.0.0.0.0.0.0.0..0.0....0...1c.1.64.img..0.0.0....0.pfB5sfIIPiY#imgrc=1rIHNLnW8w-aXM:"));

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        PlanetAdapter planetAdapter = new PlanetAdapter(arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(planetAdapter);
    }
}
