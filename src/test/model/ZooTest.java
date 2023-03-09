package model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Objects.isNull;
import static org.junit.jupiter.api.Assertions.*;

public class ZooTest {
    private Zoo zoo;

    @BeforeEach
    public void setup() {
        zoo = new Zoo();
    }

    @Test
    public void testConstructor() {
        assertEquals(11, zoo.getAnimalList().size());
    }


    @Test
    public void testAnimalInZoo() {
        Animal animal;
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

    //test toJson
    @Test
    public void testtoJson() {
        JSONObject json = zoo.toJson();
        JSONArray jsonAnimalList = json.getJSONArray("animalList");
        assertEquals(11, jsonAnimalList.length());
        JSONObject blackRhino = (JSONObject) jsonAnimalList.get(0);
        String name = blackRhino.getString("name");
        assertEquals("Black Rhino", name);
        JSONObject giantPanda = (JSONObject) jsonAnimalList.get(10);
        String name2 = giantPanda.getString("name");
        assertEquals("Giant Panda", name2);

    }


    //test getSpecificAnimal
    @Test
    public void testgetSpecificAnimalNull() {
        assertTrue(isNull(zoo.getSpecificAnimal("African Rhino")));
    }


    //test getCritical
    @Test
    public void testgetCritical() {
        List<Animal> criticals = zoo.getCritical();
        assertEquals(5, criticals.size());
        Animal blackRhino = zoo.getSpecificAnimal("Black Rhino");
        Animal afElephant = zoo.getSpecificAnimal("African Forest Elephant");
        Animal sumatranRhino = zoo.getSpecificAnimal("Sumatran Rhino");
        Animal narWhale = zoo.getSpecificAnimal("North Atlantic Right Whale");
        Animal sumatranE = zoo.getSpecificAnimal("Sumatran Elephant");
        assertTrue(criticals.contains(blackRhino));
        assertTrue(criticals.contains(narWhale));
        assertTrue(criticals.contains(sumatranRhino));
        assertTrue(criticals.contains(sumatranE));
        assertTrue(criticals.contains(afElephant));
        Animal beluga = zoo.getSpecificAnimal("Beluga Whale");
        assertFalse(criticals.contains(beluga));
    }


    //test getEndangered
    @Test
    public void testgetEndangered() {
        List<Animal> endangered = zoo.getEndangered();
        assertEquals(7, endangered.size());
        Animal blackRhino = zoo.getSpecificAnimal("Black Rhino");
        Animal afElephant = zoo.getSpecificAnimal("African Forest Elephant");
        Animal sumatranRhino = zoo.getSpecificAnimal("Sumatran Rhino");
        Animal narWhale = zoo.getSpecificAnimal("North Atlantic Right Whale");
        Animal sumatranE = zoo.getSpecificAnimal("Sumatran Elephant");
        Animal tiger = zoo.getSpecificAnimal("Tiger");
        assertTrue(endangered.contains(blackRhino));
        assertTrue(endangered.contains(narWhale));
        assertTrue(endangered.contains(sumatranRhino));
        assertTrue(endangered.contains(sumatranE));
        assertTrue(endangered.contains(afElephant));
        assertTrue(endangered.contains(tiger));
        Animal beluga = zoo.getSpecificAnimal("Beluga Whale");
        assertFalse(endangered.contains(beluga));
    }

    //test getVulnerable
    @Test
    public void testgetVulnerable() {
        List<Animal> vulnerable = zoo.getVulnerable();
        assertEquals(3, vulnerable.size());
        Animal snowLeopard = zoo.getSpecificAnimal("Snow Leopard");
        Animal giant_panda = zoo.getSpecificAnimal("Giant Panda");
        Animal polar_bear = zoo.getSpecificAnimal("Polar Bear");
        assertTrue(vulnerable.contains(polar_bear));
        assertTrue(vulnerable.contains(giant_panda));
        assertTrue(vulnerable.contains(snowLeopard));
        Animal beluga = zoo.getSpecificAnimal("Beluga Whale");
        assertFalse(vulnerable.contains(beluga));
    }

}
