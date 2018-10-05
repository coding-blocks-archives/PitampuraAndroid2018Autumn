package com.example.android.recyclerview1;

public class SuperHero {
    private String name,universe,superPower;

    public SuperHero(String name, String universe, String superPower) {
        this.name = name;
        this.universe = universe;
        this.superPower = superPower;
    }

    public String getName() {
        return name;
    }

    public String getUniverse() {
        return universe;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }
}
