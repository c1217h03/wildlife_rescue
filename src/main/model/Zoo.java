package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

public class Zoo implements Writable{
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

    List<Animal> animalList;

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
    //        if not found throws a not found exception.
    public Animal getSpecificAnimal(String name) throws AnimalNotFoundException {
        for (Animal a : animalList) {
            if (a.getName().equals(name)) {
                return a;
            }
        }
        throw new AnimalNotFoundException();
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

    }

    //REQUIRES: animal not null
    //MODIFIES: this
    //EFFECTS: adds the given animal to the animal list.
    public void addToAnimalList(Animal animal) {
        animalList.add(animal);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("animalList", animalListToJson());
        return json;
    }

    public JSONArray animalListToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Animal a : animalList) {
            jsonArray.put(a.toJson());
        }
        return jsonArray;
    }

}
