package com.example.android.recyclerviewfragments;

import android.widget.ImageView;

public class Planetclass  {
    private String name ,position, url;

    public Planetclass(String name, String position, String url) {
        this.name = name;
        this.position = position;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public String getUrl() {
        return url;
    }
}
