package model;

import model.Fleet;
import model.Army;

public class Country {

    protected String name;
    protected int numArmies;
    protected int numFleets;


    // EFFECTS: constructor for country
    public Country() {

    }

    public void addFleet(String location) {
        new Fleet(location);
        numFleets++;
    }

    public void addArmy(String location) {
        Army newArmy = new Army(location);
        numArmies++;
    }

    public void movesTo(String newLocation) {
        this.location = newLocation;
    }
}
