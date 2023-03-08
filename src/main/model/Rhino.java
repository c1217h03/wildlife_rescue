package model;
//class representing a bear with a name, status, habitat, and population, with species as Rhino.

public class Rhino extends Animal {
    //creates a rhino with the given name, status, habitat, and population.
    public Rhino(String name, String status, String habitat, double population) {
        super("Rhino", name, status, habitat, population);
    }
}
