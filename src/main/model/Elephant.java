package model;
//class representing a bear with a name, status, habitat, and population, with species as Elephant.

public class Elephant extends Animal {
    public Elephant(String name, String status, String habitat, double population) {
        this.species = "Elephant";
        this.name = name;
        this.status = status;
        this.habitat = habitat;
        this.population = population;
    }
}
