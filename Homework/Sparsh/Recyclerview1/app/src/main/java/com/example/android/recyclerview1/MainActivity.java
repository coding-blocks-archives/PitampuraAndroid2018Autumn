package com.example.android.recyclerview1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<SuperHero> superHeroes = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        superHeroes.add(new SuperHero("Batman", "DC", "Rich"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman abilities"));
        superHeroes.add(new SuperHero("Captain America", "Marvel", "American"));
        superHeroes.add(new SuperHero("Ironman", "Marvel", "Rich"));
        superHeroes.add(new SuperHero("Green Lantern", "DC", "Magic Ring"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's man"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));
        superHeroes.add(new SuperHero("Batman", "DC", "Rich"));
        superHeroes.add(new SuperHero("Superman", "DC", "Superhuman abilities"));
        superHeroes.add(new SuperHero("Captain America", "Marvel", "American"));
        superHeroes.add(new SuperHero("Ironman", "Marvel", "Rich"));
        superHeroes.add(new SuperHero("Green Lantern", "DC", "Magic Ring"));
        superHeroes.add(new SuperHero("Black Widow", "Marvel", "Agent"));
        superHeroes.add(new SuperHero("Shazam", "DC", "God's man"));
        superHeroes.add(new SuperHero("Hulk", "Marvel", "Smash"));

        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        SuperHeroAdapter superheroAdapter = new SuperHeroAdapter(superHeroes);

        recyclerView.setAdapter(superheroAdapter);

    }
}
