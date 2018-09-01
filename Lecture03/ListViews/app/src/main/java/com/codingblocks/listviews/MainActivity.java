package com.codingblocks.listviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String superHeroes[] = {
            "Batman", "Superman", "Wonder Woman", "Flash", "Aquaman", "Cyborg",
            "Iron Man", "Captain America", "Black Widow", "Hulk", "Thor",
            "Shaktiman", "Krrish", "Drona",

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvSuperheroes = findViewById(R.id.lvSuperheroes);
        ArrayAdapter<String> superHeroAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                superHeroes
        );
        lvSuperheroes.setAdapter(superHeroAdapter);
    }
}
