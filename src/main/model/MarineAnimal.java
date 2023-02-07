package model;

public class MarineAnimal extends Animal {
    public MarineAnimal(String name, String status, String habitat, double population) {
        this.species = "Marine Animal";
        this.name = name;
        this.status = status;
        this.habitat = habitat;
        this.population = population;
    }
}
