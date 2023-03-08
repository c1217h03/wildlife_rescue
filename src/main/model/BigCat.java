package model;
//class representing a bear with a name, status, habitat, and population, with species as Big Cat.

public class BigCat extends Animal {
    //creates a big cat with the given name, status, habitat, and population.
    public BigCat(String name, String status, String habitat, double population) {
        super("Big Cat", name, status, habitat, population);
    }
}
