package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "SUPERHERO";

    ArrayList<String> superHeroes = new ArrayList<>(Arrays.asList("Batman", "Superman", "Wonder Woman", "Flash", "Aquaman", "Cyborg",
            "Iron Man", "Captain America", "Black Widow", "Hulk", "Thor",
            "Shaktiman", "Krrish", "Drona"));
//    String[] superHeroes = {"Batman", "Superman", "Wonder Woman", "Flash", "Aquaman", "Cyborg",
//        "Iron Man", "Captain America", "Black Widow", "Hulk", "Thor",
//        "Shaktiman", "Krrish", "Drona"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvSuperheroes = findViewById(R.id.lvSuperheroes);
        final ArrayAdapter<String> superHeroAdapter = new ArrayAdapter<>(
                this,
                R.layout.list_item_superhero,
                R.id.tvName,
                superHeroes
        );
        lvSuperheroes.setAdapter(superHeroAdapter);

        Button btnAddSuperhero = findViewById(R.id.btnAddSuperhero);
        btnAddSuperhero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String[] oldSuperHeroes = superHeroes;
//                superHeroes = new String[oldSuperHeroes.length + 1];
//                for (int i = 0; i < oldSuperHeroes.length; i++) {
//                    superHeroes[i] = oldSuperHeroes[i];
//                }
//                superHeroes[oldSuperHeroes.length] = newSuperHero;


                Log.d(TAG, "size = " + superHeroes.size());
                String newSuperHero = ((EditText) findViewById(R.id.etNewSuperhero)).getText().toString();
//                superHeroes.add(newSuperHero);


                superHeroes.clear();
                superHeroes.add(newSuperHero);
                superHeroAdapter.notifyDataSetChanged();
                Log.d(TAG, "size = " + superHeroes.size());
            }
        });
    }
}
