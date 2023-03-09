package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//class representing a collection of animals.
public class Zoo implements Writable {
    private Rhino blackRhino;
    private Rhino sumatranRhino;
    private MarineAnimal narWhale;
    private MarineAnimal belugaWhale;
    private MarineAnimal whaleShark;
    private Bear polarBear;
    private Bear giantPanda;
    private BigCat snowLeopard;
    private BigCat tiger;
    private Elephant afElephant;
    private Elephant suElephant;

    private List<Animal> animalList;

    //constructs a collection of animals.
    public Zoo() {
        initializingAnimals();
        animalList = new ArrayList<>();

        animalList.add(blackRhino);
        animalList.add(sumatranRhino);
        animalList.add(suElephant);
        animalList.add(afElephant);
        animalList.add(narWhale);
        animalList.add(belugaWhale);
        animalList.add(whaleShark);
        animalList.add(tiger);
        animalList.add(snowLeopard);
        animalList.add(polarBear);
        animalList.add(giantPanda);
    }

    //EFFECTS:returns the given animal
    //        if not found returns a null object
    public Animal getSpecificAnimal(String name) {
        for (Animal a : animalList) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        System.out.println("That animal doesn't exist.");
        return null;
    }

    //EFFECTS: returns the animals that are "critically" endangered from the animals list.
    public List<Animal> getCritical() {
        List<Animal> critical = new ArrayList<>();
        for (Animal a : animalList) {
            if (a.getStatus() == "CE") {
                critical.add(a);
            }
        }
        return critical;
    }

    //EFFECTS: returns the animals that are "endangered" from the animals list.
    public List<Animal> getEndangered() {
        List<Animal> endangered = new ArrayList<>();
        for (Animal a : animalList) {
            if (a.getStatus() == "E" || a.getStatus() == "CE") {
                endangered.add(a);
            }
        }
        return endangered;
    }

    //EFFECTS: returns the animals that are "vulnerable" from the animals list.
    public List<Animal> getVulnerable() {
        List<Animal> endangered = new ArrayList<>();
        for (Animal a : animalList) {
            if (a.getStatus() == "V") {
                endangered.add(a);
            }
        }
        return endangered;
    }

    //EFFECTS: initializes the animals in the zoo.
    public void initializingAnimals() {
        this.blackRhino = new Rhino("Black Rhino", "CE", "Savannah",
                5500);
        this.sumatranRhino = new Rhino("Sumatran Rhino", "CE", "Tropical Forests",
                80);
        this.narWhale = new MarineAnimal("North Atlantic Right Whale", "CE",
                "Ocean", 366);
        this.belugaWhale = new MarineAnimal("Beluga Whale", "NT", "Ocean",
                150000);
        this.polarBear = new Bear("Polar Bear", "V", "Arctic Ocean",
                265000);
        this.giantPanda = new Bear("Giant Panda", "V", "Chinese Forests",
                1864);
        this.snowLeopard = new BigCat("Snow Leopard", "V", "High Mountains",
                5000);
        this.tiger = new BigCat("Tiger", "E", "Rainforests", 4500);
        this.afElephant = new Elephant("African Forest Elephant", "CE",
                "African Forests", 415000);
        this.suElephant = new Elephant("Sumatran Elephant", "CE",
                "Tropical Forests", 2400);
        this.whaleShark = new MarineAnimal("Whale Shark", "E", "Ocean",
                200000);
        //5 criticals
        //7 endangered
        //3 vulnerables
    }

    //REQUIRES: animal not null
    //MODIFIES: this
    //EFFECTS: adds re-initializes the animals.
    //         used when autoloading the data.
    //         returns true if the animal is found.
    //         false if it doesn't exist.
    public boolean addToAnimalList(Animal animal) {
        switch (animal.getSpecies()) {
            case "Rhino":
                rhinoReinitialized(animal);
                return true;
            case "Big Cat":
                bigCatsReinitialized(animal);
                return true;
            case "Elephant":
                elephantsReinitialized(animal);
                return true;
            case "Marine Animal":
                marineAnimalsReinitialized(animal);
                return true;
            case "Bear":
                bearsReinitialized(animal);
                return true;
            default:
                return false;
        }
    }

    //REQUIRES: animal not null
    //MODIFIES: this (giant panda or polar bear)
    //EFFECTS: changes the donation of the bear to the given animal's current donations.
    //         returns true if animal is found
    public boolean bearsReinitialized(Animal animal) {
        switch (animal.getName()) {
            case "Giant Panda":
                giantPanda.addDonation(animal.getDonation());
                return true;
            case "Polar Bear":
                polarBear.addDonation(animal.getDonation());
                return true;
            default:
                return false;
        }
    }

    //REQUIRES: animal not null
    //MODIFIES: this (black rhino or sumatran rhino)
    //EFFECTS: changes the donation of the rhino to the given animal's current donations.
    //         returns true if animal is found
    public boolean rhinoReinitialized(Animal animal) {
        switch (animal.getName()) {
            case "Black Rhino":
                blackRhino.addDonation(animal.getDonation());
                return true;
            case "Sumatran Rhino":
                sumatranRhino.addDonation(animal.getDonation());
                return true;
            default:
                return false;
        }
    }

    //REQUIRES: animal not null
    //MODIFIES: this (tiger or snow leopard)
    //EFFECTS: changes the donation of the big cat to the given animal's current donations.
    public boolean bigCatsReinitialized(Animal animal) {
        switch (animal.getName()) {
            case "Tiger":
                tiger.addDonation(animal.getDonation());
                return true;
            case "Snow Leopard":
                snowLeopard.addDonation(animal.getDonation());
                return true;
            default:
                return false;
        }
    }

    //REQUIRES: animal not null
    //MODIFIES: this (sumatran elephant or african forest elephant)
    //EFFECTS: changes the donation of the elephant to the given animal's current donations.
    public boolean elephantsReinitialized(Animal animal) {
        switch (animal.getName()) {
            case "African Forest Elephant":
                afElephant.addDonation(animal.getDonation());
                return true;
            case "Sumatran Elephant":
                suElephant.addDonation(animal.getDonation());
                return true;
            default:
                return false;
        }
    }

    //REQUIRES: animal not null
    //MODIFIES: this (beluga, whale shark or north atlantic right whale)
    //EFFECTS: changes the donation of the marine animal to the given animal's current donations.
    public boolean marineAnimalsReinitialized(Animal animal) {
        switch (animal.getName()) {
            case "Beluga Whale":
                belugaWhale.addDonation(animal.getDonation());
                return true;
            case "Whale Shark":
                whaleShark.addDonation(animal.getDonation());
                return true;
            case "North Atlantic Right Whale":
                narWhale.addDonation(animal.getDonation());
                return true;
            default:
                return false;
        }
    }

    //EFFECT: returns the animalList
    public List<Animal> getAnimalList() {
        return animalList;
    }


    //EFFECTS: converts the collection of animals (Zoo) into a JSONObject
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("animalList", animalListToJson());
        return json;
    }

    //EFFECTS: converts the animalList into a JSONArray
    public JSONArray animalListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Animal a : animalList) {
            jsonArray.put(a.toJson());
        }
        return jsonArray;
    }

}