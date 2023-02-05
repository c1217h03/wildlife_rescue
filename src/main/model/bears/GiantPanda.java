package model.bears;

import model.Bear;

//represents a Giant Panda that is a Bear with its specified name, status, population, and habitat.
public class GiantPanda extends Bear {
    public GiantPanda() {
        this.name = "Giant Panda";
        this.status = "V";
        this.population = 1864;
        this.habitat = "Chinese Forest";
    }
}
