package com.codingblocks.customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class SuperheroAdapter extends BaseAdapter {

    private ArrayList<SuperHero> arrayList;
    private Context ctx;

    public SuperheroAdapter(@NonNull ArrayList<SuperHero> arrayList, Context context) {
        this.arrayList = arrayList;
        this.ctx = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public SuperHero getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        TextView power, name, universe;
//        LayoutInflater layoutInflater = (LayoutInflater)
//                ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        LayoutInflater li = LayoutInflater.from(ctx);
        View inflatedView = li.inflate(R.layout.layout_row,parent,false);

        SuperHero currentHero = getItem(position);

        TextView name = inflatedView.findViewById(R.id.superheroName);
        TextView universe = inflatedView.findViewById(R.id.superheroUniverse);
        TextView power = inflatedView.findViewById(R.id.superheroPower);

        name.setText(currentHero.getName());
        universe.setText(currentHero.getUniverse());
        power.setText(currentHero.getSuperPower());

        return inflatedView;
    }

}
