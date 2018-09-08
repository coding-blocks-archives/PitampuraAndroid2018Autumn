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

        Log.e("TAG", "getView: " + convertView);

        LayoutInflater li = LayoutInflater.from(ctx);
        SuperheroHolder holder;
        View inflatedView;

        if (convertView == null) {
            inflatedView = li.inflate(R.layout.layout_row, parent, false);

            holder = new SuperheroHolder(inflatedView);
//            holder.name = inflatedView.findViewById(R.id.superheroName);
//            holder.universe = inflatedView.findViewById(R.id.superheroUniverse);
//            holder.power = inflatedView.findViewById(R.id.superheroPower);
//            holder.initialize(inflatedView);

            inflatedView.setTag(holder);
        } else {
            inflatedView = convertView;
            holder = (SuperheroHolder) inflatedView.getTag();
        }

        SuperHero currentHero = getItem(position);

        holder.name.setText(currentHero.getName());
        holder.universe.setText(currentHero.getUniverse());
        holder.power.setText(currentHero.getSuperPower());

        return inflatedView;
    }

    class SuperheroHolder {

        TextView name, universe, power;

        public SuperheroHolder(View view) {
            name = view.findViewById(R.id.superheroName);
            universe = view.findViewById(R.id.superheroUniverse);
            power = view.findViewById(R.id.superheroPower);
        }

    }

}
