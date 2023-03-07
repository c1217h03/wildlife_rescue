package model;

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
    public void testAnimalNotInZoo() {
        Animal animal = null;
        try {
            animal = zoo.getSpecificAnimal("Piii");
            fail("AnimalNotFoundException Expected");

        } catch (AnimalNotFoundException e) {
            //pass
        }
        assertEquals(null, animal);
    }

    @Test
    public void testAnimalInZoo() {
        Animal animal = null;
        try {
             animal = zoo.getSpecificAnimal("Polar Bear");

        } catch (AnimalNotFoundException e) {
            fail("Exception not expected.");
        }
        assertEquals("Polar Bear", animal.getName());
        assertEquals("Arctic Ocean", animal.getHabitat());
    }

}
