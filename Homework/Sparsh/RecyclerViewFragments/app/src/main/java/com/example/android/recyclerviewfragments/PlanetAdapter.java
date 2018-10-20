package com.example.android.recyclerviewfragments;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {
    ArrayList<Planetclass> arrayList;

    public PlanetAdapter(ArrayList<Planetclass> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View view =li.inflate(R.layout.item_row,parent,false);
        return new PlanetHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetHolder holder, int position) {

        Planetclass currentObj = arrayList.get(position);
        PlanetHolder currentHolder = holder;
        Picasso.get()
                .load(currentObj.getUrl())
                .into(currentHolder.imageView);
        currentHolder.name.setText(currentObj.getName());
        currentHolder.position.setText(currentObj.getPosition());
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    class PlanetHolder extends RecyclerView.ViewHolder{
        TextView name,position;
        ImageView imageView;
        public PlanetHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tvName);
            position=itemView.findViewById(R.id.tvRank);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
