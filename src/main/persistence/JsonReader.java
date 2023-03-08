package persistence;


import model.Account;
import model.Animal;
import model.NotValidCardException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//class that represents a reader that reads an account from file.
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    //From JsonSerializationDemo
    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Account read() throws IOException, NotValidCardException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseAccount(jsonObject);
    }

    //From JsonSerializationDemo
    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private Account parseAccount(JSONObject jsonObject) throws NotValidCardException {
        String name = jsonObject.getString("username");
        String card = jsonObject.getString("card");
        Account acc = new Account(name, card);
        addFaves(acc, jsonObject);
        addDonatedTo(acc, jsonObject);
        return acc;
    }

    // MODIFIES: acc
    // EFFECTS: parses thingies from JSON object and adds them to account
    private void addFaves(Account acc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("favorites");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addAnimalToFavorites(acc, nextThingy);
        }
    }

    //MODIFIES: acc
    //EFFECTS: parses thingies from JSON object and adds them to account
    private void addDonatedTo(Account acc, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("donatedto");
        for (Object json : jsonArray) {
            JSONObject nextAnimal = (JSONObject) json;
            addAnimalToDonatedTo(acc, nextAnimal);
        }
    }

    // MODIFIES: acc
    // EFFECTS: parses animal from JSON object and adds it to account
    private void addAnimalToFavorites(Account acc, JSONObject jsonObject) {
        double donations = jsonObject.getDouble("donations");
        String name = jsonObject.getString("name");
        String habitat = jsonObject.getString("habitat");
        Double population = jsonObject.getDouble("population");
        String status = jsonObject.getString("status");
        String species = jsonObject.getString("species");
        Animal animal = new Animal(species, name, status, habitat, population);
        animal.addDonation(donations);
        acc.addToFavorites(animal);
    }

    // MODIFIES: acc
    // EFFECTS: parses animal from JSON object and adds it to account
    private void addAnimalToDonatedTo(Account acc, JSONObject jsonObject) {
        double donations = jsonObject.getDouble("donations");
        String name = jsonObject.getString("name");
        String habitat = jsonObject.getString("habitat");
        Double population = jsonObject.getDouble("population");
        String status = jsonObject.getString("status");
        String species = jsonObject.getString("species");
        Animal animal = new Animal(species, name, status, habitat, population);
        animal.addDonation(donations);
        acc.addToDonatedTo(animal);
    }
}

