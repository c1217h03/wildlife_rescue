package model;

//class representing a bear with a name, status, habitat, and population, with species as Bear.

public class Bear extends Animal {
    //creates a bear object with the given name, status, habitat, and population.
    public Bear(String name, String status, String habitat, double population) {
        super("Bear", name, status, habitat, population);
    }
}
