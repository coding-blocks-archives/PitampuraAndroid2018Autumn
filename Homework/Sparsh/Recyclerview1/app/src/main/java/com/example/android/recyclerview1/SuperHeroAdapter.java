package com.example.android.recyclerview1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.superheroHolder>{

    ArrayList<SuperHero>superHeroes;

    public SuperHeroAdapter(ArrayList<SuperHero> superHeroes) {
        this.superHeroes = superHeroes;
    }

    @NonNull
    @Override
    public superheroHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View inflatedView = li.inflate(R.layout.row_layout,parent,false);
        return new superheroHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull superheroHolder holder, int position) {
        SuperHero currentHero = superHeroes.get(position);

        holder.name.setText(currentHero.getName());
        holder.universe.setText(currentHero.getUniverse());
        holder.superPower.setText(currentHero.getSuperPower());
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    class superheroHolder extends RecyclerView.ViewHolder {
        TextView name ,universe,superPower;
        public superheroHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.superheroName);
            universe = itemView.findViewById(R.id.superheroUniverse);
            superPower = itemView.findViewById(R.id.superheroPower) ;
        }
    }

}
