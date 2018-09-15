package com.codingblocks.recyclerviewfragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class SuperheroAdapter extends RecyclerView.Adapter<SuperheroAdapter.SuperheroHolder> {

    private ArrayList<SuperHero> superHeroes;
    private Context ctx;
    private AppCompatActivity appCompatActivity;

    public SuperheroAdapter(ArrayList<SuperHero> superHeroes, AppCompatActivity activity) {
        this.superHeroes = superHeroes;
        this.appCompatActivity = activity;
    }

    @NonNull
    @Override
    public SuperheroHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ctx = viewGroup.getContext();
        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
        View inflatedView = li.inflate(R.layout.layout_row, viewGroup, false);
        return new SuperheroHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull SuperheroHolder superheroHolder, int position) {
        final SuperHero currentHero = superHeroes.get(position);
        superheroHolder.name.setText(currentHero.getName());
        superheroHolder.power.setText(currentHero.getSuperPower());
        superheroHolder.universe.setText(currentHero.getUniverse());
    }

    @Override
    public int getItemCount() {
        return superHeroes.size();
    }

    class SuperheroHolder extends RecyclerView.ViewHolder {

        TextView name, universe, power;

        public SuperheroHolder(@NonNull View view) {
            super(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SuperHero currentHero = superHeroes.get(getAdapterPosition());

                    if (appCompatActivity.findViewById(R.id.container) == null) {
                        startIntent(currentHero.getName());
                    } else
                        addFragment(currentHero.getName());


                }
            });
            name = view.findViewById(R.id.superheroName);
            universe = view.findViewById(R.id.superheroUniverse);
            power = view.findViewById(R.id.superheroPower);
        }

    }

    private void startIntent(String name) {
        Intent intent = new Intent(ctx, DetailActivity.class);
        intent.putExtra("NAME", name);
        ctx.startActivity(intent);
    }

    private void addFragment(String name) {

        FragmentManager fm = appCompatActivity.getSupportFragmentManager();
        fm.beginTransaction()
                .add(R.id.container, new DetailActivityFragment(name))
                .commit();
    }

}
