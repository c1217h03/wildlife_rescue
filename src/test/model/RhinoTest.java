package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RhinoTest {
    private Rhino blackRhino;
    private Rhino sumatranRhino;


    @BeforeEach
    public void setup(){
        blackRhino = new Rhino("Black Rhino", "CE", "Savannah", 5500);
        sumatranRhino = new Rhino("Sumatran Rhino", "CE", "Tropical Forests", 80);
    }

    @Test
    public void testRhinoBlack(){
        assertEquals(0, blackRhino.getDonation());
        assertEquals("CE", blackRhino.getStatus());
        assertEquals("Black Rhino", blackRhino.getName());
        assertEquals("Rhino", blackRhino.getSpecies());
        assertEquals("Savannah", blackRhino.getHabitat());
        assertEquals(5500, blackRhino.getPopulation());
    }

    @Test
    public void testRhinoSumatran(){
        assertEquals(0, sumatranRhino.getDonation());
        assertEquals(80, sumatranRhino.getPopulation());
        assertEquals("CE", sumatranRhino.getStatus());
        assertEquals("Sumatran Rhino", sumatranRhino.getName());
        assertEquals("Tropical Forests", sumatranRhino.getHabitat());
        assertEquals("Rhino", sumatranRhino.getSpecies());
    }

    @Test
    public void testAddDonationMinimum(){
        sumatranRhino.addDonation(getMinDonation());
        assertEquals(getMinDonation(), sumatranRhino.getDonation());
    }

    @Test
    public void testAddDonationMiddle(){
        sumatranRhino.addDonation(getMaxDonation() / 2);
        assertEquals(getMaxDonation() / 2, sumatranRhino.getDonation());

    }

    @Test
    public void testAddDonationOneLessThanMax(){
        sumatranRhino.addDonation(getMaxDonation() - 1);
        assertEquals(getMaxDonation() - 1, sumatranRhino.getDonation() );
    }

    @Test
    public void testAddDonationMaximum(){
        sumatranRhino.addDonation(getMaxDonation());
        assertEquals(getMaxDonation(), sumatranRhino.getDonation());
    }
}
