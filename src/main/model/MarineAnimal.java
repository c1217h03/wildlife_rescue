package model;
//class representing a bear with a name, status, habitat, and population, with species as Marine Animal.

public class MarineAnimal extends Animal {
    //creates a marine animal with the given name, status, habitat, and population.
    public MarineAnimal(String name, String status, String habitat, double population) {
        super("Marine Animal", name, status, habitat, population);
    }
}
