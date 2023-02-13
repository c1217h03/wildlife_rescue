package model;

//represents an endangered animal with the amount of donations it has, name, population, species, status, and habitat
public class Animal {
    protected double donations = 0;
    protected String name;
    protected double population;
    protected String species;
    protected String status;
    protected String habitat;


    //EFFECTS: add the given amount into the animal's donation.
    public void addDonation(double amount) {
        this.donations += amount;
    }

    //EFFECTS: returns the name of the animal objects its called on.
    public String getName() {
        return this.name;
    }

    //EFFECTS: returns the amount of donations an animal has
    public double getDonation() {
        return this.donations;
    }

    //EFFECTS: returns the location of an animal
    public String getHabitat() {
        return this.habitat;
    }

    //EFFECTS: returns the animal status
    //         either: critically endangered (CE), endangered (E), near threatened (NY), or vulnerable (V).
    public String getStatus() {
        return this.status;
    }

    //EFFECTS: returns the population of the endangered animal.
    public double getPopulation() {
        return this.population;
    }

    //EFFECTS: returns the type of species an animal is.
    public String getSpecies() {
        return this.species;
    }


}
