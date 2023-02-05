package model.bigcats;

import model.BigCat;

//represents a Tiger that is a Big Cat with its specified name, status, population, and habitat.
public class Tiger extends BigCat {
    public Tiger() {
        this.name = "Tiger";
        this.status = "E";
        this.population = 4500;
        this.habitat = "Rainforests";
    }
}
