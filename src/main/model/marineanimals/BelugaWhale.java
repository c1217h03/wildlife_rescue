package model.marineanimals;

import model.MarineAnimal;

//represents a Beluga Whale that is a Marine Animal with its specified name, status, population, and habitat.
public class BelugaWhale extends MarineAnimal {
    public BelugaWhale() {
        this.name = "Beluga Whale";
        this.status = "NT";
        this.population = 150000;
        this.habitat = "Ocean";
    }
}
