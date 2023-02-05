package model;

import model.rhinos.BlackRhino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BlackRhinoTest {
    private BlackRhino blackRhino;

    @BeforeEach
    public void setup(){
        blackRhino = new BlackRhino();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, blackRhino.getDonation());
        assertEquals("Black Rhino", blackRhino.getName());
        assertEquals("CE", blackRhino.getStatus());
        assertEquals(5500, blackRhino.getPopulation());
        assertEquals("Savannah", blackRhino.getHabitat());
    }

    @Test
    public void testAddDonation(){
        blackRhino.addDonation(1);
        assertEquals(1, blackRhino.getDonation());
        blackRhino.addDonation(2500);
        assertEquals(2501, blackRhino.getDonation());
        blackRhino.addDonation(5000);
        assertEquals(7501, blackRhino.getDonation());
    }
}
