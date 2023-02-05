package model.rhinos;

import model.Rhino;

//represents a Sumatran Rhino that is a Rhino with its specified name, status, population, and habitat.
public class SumatranRhino extends Rhino {
    public SumatranRhino() {
        this.name = "Sumatran Rhino";
        this.status = "CE";
        this.population = 80;
        this.habitat = "Tropical Forests";

    }
}
