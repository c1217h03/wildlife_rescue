package model;

import model.bears.GiantPanda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GiantPandaTest {
    private GiantPanda giantPanda;

    @BeforeEach
    public void setup(){
        giantPanda = new GiantPanda();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, giantPanda.getDonation());
        assertEquals("Giant Panda", giantPanda.getName());
        assertEquals("V", giantPanda.getStatus());
        assertEquals(1864, giantPanda.getPopulation());
        assertEquals("Chinese Forest", giantPanda.getHabitat());
        assertEquals("Bear", giantPanda.getSpecies());
    }

    @Test
    public void testAddDonation(){
        giantPanda.addDonation(1);
        assertEquals(1, giantPanda.getDonation());
        giantPanda.addDonation(2500);
        assertEquals(2501, giantPanda.getDonation());
        giantPanda.addDonation(5000);
        assertEquals(7501, giantPanda.getDonation());
    }
}
