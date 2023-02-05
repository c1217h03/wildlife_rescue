package model.bears;

import model.Bear;

//represents a Polar Bear that is a Bear with its specified name, status, population, and habitat.
public class PolarBear extends Bear {
    public PolarBear() {
        this.name = "Polar Bear";
        this.status = "V";
        this.population = 26500;
        this.habitat = "Arctic Ocean";
    }
}
