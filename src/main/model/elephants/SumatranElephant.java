package model.elephants;

import model.Elephant;

//represents a Sumatran Elephant that is an Elephant with its specified name, status, population, and habitat.
public class SumatranElephant extends Elephant {
    public SumatranElephant() {
        this.name = "Sumatran Elephant";
        this.status = "CE";
        this.population = 2400;
        this.habitat = "Tropical Forest";
    }
}
