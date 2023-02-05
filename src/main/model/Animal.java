package model;

//represents an endangered animal with the amount of donations it has, name, population, species, status, and habitat
public class Animal {
    protected double donations = 0;
    protected  String name;
    protected double population;
    protected String species;
    protected String status;
    protected String habitat;

    //gets the name of the animal objects its called on.
    public String getName(){
        return this.name;
    }

    //gets the amount of donations an animal has
    public double getDonation() {
        return this.donations;
    }

    //REQUIRES: 0 < amount <= 5000
    //EFFECTS: add the given amount into the animal's donation.
    public void addDonation(double amount) {
        this.donations += amount;
    }

    //gets the location of an animal
    public String getHabitat() {
        return this.habitat;
    }

    //gets the animal status
    //                either: critically endangered (CE), endangered (E), near threatened (NY), or vulnerable (V).
    public String getStatus() {
        return this.status;
    }

    //gets the population of the endangered animal.
    public double getPopulation() {
        return this.population;
    }

    //gets the type of species an animal is.
    public String getSpecies() {
        return this.species;
    }


}
