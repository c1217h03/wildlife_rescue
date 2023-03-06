package model;
//class representing a bear with a name, status, habitat, and population, with species as Marine Animal.

public class MarineAnimal extends Animal {
    public MarineAnimal(String name, String status, String habitat, double population) {
        super("Marine Animal", name, status, habitat, population);
        this.species = "Marine Animal";
        this.name = name;
        this.status = status;
        this.habitat = habitat;
        this.population = population;
    }
}
