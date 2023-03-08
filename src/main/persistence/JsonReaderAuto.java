package persistence;

import model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

//class representing a reader for loading data for objects that are automatically saved.
public class JsonReaderAuto {
    private String source;

    //EFFECTS: constructs a JsonReaderAuto to read from given source file.
    public JsonReaderAuto(String source) {
        this.source = source;
    }

    //From JsonSerializationDemo
    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public Zoo read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseZoo(jsonObject);
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
    private Zoo parseZoo(JSONObject jsonObject) {
        Zoo zoo = new Zoo();
        addAnimalList(zoo, jsonObject);
        return zoo;
    }

    // MODIFIES: zoo
    // EFFECTS: parses thingies from JSON object and adds them to account
    private void addAnimalList(Zoo zoo, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("animalList");
        for (Object json : jsonArray) {
            JSONObject nextThingy = (JSONObject) json;
            addAnimalToAnimalList(zoo, nextThingy);
        }
    }

    // MODIFIES: zoo
    // EFFECTS: parses animal from JSON object and adds it to account
    private void addAnimalToAnimalList(Zoo zoo, JSONObject jsonObject) {
        double donations = jsonObject.getDouble("donations");
        String name = jsonObject.getString("name");
        String habitat = jsonObject.getString("habitat");
        Double population = jsonObject.getDouble("population");
        String status = jsonObject.getString("status");
        String species = jsonObject.getString("species");
        Animal animal = new Animal(species, name, status, habitat, population);
        animal.addDonation(donations);
        zoo.addToAnimalList(animal);
    }
}
