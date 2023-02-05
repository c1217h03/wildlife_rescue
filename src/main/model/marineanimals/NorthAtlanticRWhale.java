package model.marineanimals;

import model.MarineAnimal;

//represents a North Atlantic R. Whale that is a Marine Animal with its specified name, status, population, and habitat.
public class NorthAtlanticRWhale extends MarineAnimal {
    public NorthAtlanticRWhale() {
        this.name = "North Atlantic Right Whale";
        this.status = "CE";
        this.population = 366;
        this.habitat = "Ocean";

    }
}
