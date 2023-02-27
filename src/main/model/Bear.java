package model;
//class representing a bear with a name, status, habitat, and population, with species as Bear.

public class Bear extends Animal {
    public Bear(String name, String status, String habitat, double population) {
        this.species = "Bear";
        this.name = name;
        this.status = status;
        this.habitat = habitat;
        this.population = population;
    }
}
