package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ZooTest {
    private Zoo zoo;

    @BeforeEach
    public void setup() {
        zoo = new Zoo();
    }


    @Test
    public void testAnimalInZoo() {
        Animal animal = null;
        animal = zoo.getSpecificAnimal("Polar Bear");
        assertEquals("Polar Bear", animal.getName());
        assertEquals("Arctic Ocean", animal.getHabitat());
    }

    @Test
    public void testGetAnimalList() {
        assertEquals(11, zoo.getAnimalList().size());
    }

    @Test
    public void testZootoJson() {
        JSONObject json = zoo.toJson();
        JSONArray animalList= json.getJSONArray("animalList");
        assertEquals(11, animalList.length());
    }

}
