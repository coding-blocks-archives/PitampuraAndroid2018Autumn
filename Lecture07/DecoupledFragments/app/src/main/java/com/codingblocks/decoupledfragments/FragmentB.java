package com.codingblocks.decoupledfragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class FragmentB extends Fragment {

    String input;

    public FragmentB() {
    }

    public static FragmentB newInstance(String input) {
        Bundle args = new Bundle();
        args.putString("KEY", input);

        FragmentB fragment = new FragmentB();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Intent intent = getActivity().getIntent();

        if (intent.hasExtra("KEY")) {
            input = intent.getStringExtra("KEY");
        } else {
            input = getArguments().getString("KEY");
        }

        TextView textView = view.findViewById(R.id.tViewFragB);

        textView.setText(input);

    }

}