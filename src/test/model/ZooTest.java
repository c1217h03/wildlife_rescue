package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testAddToAnimalList() {
        Animal animal = new Animal("Rhino", "Black Rhino", "CE", "Savannah",
                5500);
        animal.addDonation(50);
        assertTrue(zoo.addToAnimalList(animal));
        Animal blackRhino = zoo.getSpecificAnimal("Black Rhino");
        assertEquals(50, blackRhino.getDonation());
    }

    @Test
    public void testAddToAnimalNonExisting() {
        Animal animal = new Animal("Bird", "Blue Macau", "CE", "Rainforests",
                80);
        animal.addDonation(50);
        assertFalse(zoo.addToAnimalList(animal));
    }

    @Test
    public void testNonExistentRhino() {
        Rhino rhino = new Rhino("African Rhino", "CE", "Savannah", 500);
        assertFalse(zoo.rhinoReinitialized(rhino));
    }

    @Test
    public void testNonExistentBear() {
        Bear bear = new Bear("Black Bear", "NT", "Forests", 500);
        assertFalse(zoo.bearsReinitialized(bear));
    }

    @Test
    public void testNonExistentMarineAnimal() {
        MarineAnimal seal = new MarineAnimal("Seal", "V", "Ocean", 500);
        assertFalse(zoo.marineAnimalsReinitialized(seal));
    }

    @Test
    public void testNonExistentElephant() {
        Elephant elephant = new Elephant("Elephant", "E", "Savannah", 45);
        assertFalse(zoo.elephantsReinitialized(elephant));
    }

    @Test
    public void testNonExistentBigCat() {
        BigCat bigCat = new BigCat("Lion", "CE", "Savannah", 500);
        assertFalse(zoo.bigCatsReinitialized(bigCat));
    }

}
