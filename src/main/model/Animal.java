package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.Objects;

//represents an endangered animal with the amount of donations it has, name, population, species, status, and habitat
public class Animal implements Writable {
    protected double donations = 0;
    protected String name;
    protected double population;
    protected String species;
    protected String status;
    protected String habitat;

    //EFFECTS: constructs a new animal with the given name, species, status, habitat, and population.
    public Animal(String species, String name, String status, String habitat, double population) {
        this.species = species;
        this.name = name;
        this.status = status;
        this.habitat = habitat;
        this.population = population;
    }

    //MODIFIES: this
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

    //EFFECTS: returns the animal as a JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("donations", donations);
        json.put("habitat", habitat);
        json.put("population", population);
        json.put("status", status);
        json.put("species", species);
        return json;
    }

    //EFFECTS: overrides the equals method. Returns true if the given object is equal to the object it's called on.
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Animal)) {
            return false;
        }
        Animal animal = (Animal) o;
        return name.equals(animal.name);
    }

    //EFFECTS: overrides the hashCode method/
    //         returns hashcode.
    @Override
    public int hashCode() {
        return Objects.hash(name, population, species, habitat);
    }
}
