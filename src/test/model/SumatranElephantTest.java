package model;

import model.elephants.SumatranElephant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumatranElephantTest {
    private SumatranElephant sumatranElephant;

    @BeforeEach
    public void setup(){
        sumatranElephant = new SumatranElephant();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, sumatranElephant.getDonation());
        assertEquals("Sumatran Elephant", sumatranElephant.getName());
        assertEquals(2400, sumatranElephant.getPopulation());
        assertEquals("CE", sumatranElephant.getStatus());
        assertEquals("Tropical Forest", sumatranElephant.getHabitat());
    }

    @Test
    public void testAddDonation(){
        sumatranElephant.addDonation(1);
        assertEquals(1, sumatranElephant.getDonation());
        sumatranElephant.addDonation(2500);
        assertEquals(2501, sumatranElephant.getDonation());
        sumatranElephant.addDonation(5000);
        assertEquals(7501, sumatranElephant.getDonation());
    }
}
