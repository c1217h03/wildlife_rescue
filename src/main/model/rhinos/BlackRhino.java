package model.rhinos;

import model.Rhino;

//represents a Black Rhino that is a Rhino with its specified name, status, population, and habitat.
public class BlackRhino extends Rhino {
    public BlackRhino() {
        this.name = "Black Rhino";
        this.status = "CE";
        this.population = 5500;
        this.habitat = "Savannah";
    }
}
