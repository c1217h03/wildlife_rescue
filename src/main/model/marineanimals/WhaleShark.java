package model.marineanimals;

import model.MarineAnimal;

//represents a Whale Shark that is a Marine Animal with its specified name, status, population, and habitat.
public class WhaleShark extends MarineAnimal {
    public WhaleShark() {
        this.name = "Whale Shark";
        this.status = "E";
        this.population = 200000;
        this.habitat = "Ocean";
    }
}
