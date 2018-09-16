package com.codingblocks.decouplingadapter;

public class SuperHero {

    private String name,universe,superPower;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniverse() {
        return universe;
    }

    public void setUniverse(String universe) {
        this.universe = universe;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public SuperHero(String name, String universe, String superPower) {
        this.name = name;
        this.universe = universe;
        this.superPower = superPower;
    }
}
