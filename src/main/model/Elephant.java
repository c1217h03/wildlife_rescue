package model;
//class representing a bear with a name, status, habitat, and population, with species as Elephant.

public class Elephant extends Animal {
    //creates an elephant. with the given name, status, habitat, and population.
    public Elephant(String name, String status, String habitat, double population) {
        super("Elephant", name, status, habitat, population);
    }
}
