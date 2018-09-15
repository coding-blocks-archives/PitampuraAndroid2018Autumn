package com.codingblocks.recyclerviewfragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DetailActivityFragment extends Fragment {

    String name;

    public DetailActivityFragment() {
    }

    public DetailActivityFragment(String name) {
        this.name = name;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvName = view.findViewById(R.id.tvName);
        Intent i = getActivity().getIntent();

        if (i.hasExtra("NAME")) {
            String receivedName = i.getStringExtra("NAME");
            tvName.setText(receivedName);
        } else
            tvName.setText(name);
    }
}
