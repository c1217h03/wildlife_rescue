package model;

import model.bears.PolarBear;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PolarBearTest {
    private PolarBear polarBear;

    @BeforeEach
    public void setup(){
        polarBear = new PolarBear();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, polarBear.getDonation());
        assertEquals("Polar Bear", polarBear.getName());
        assertEquals("Arctic Ocean", polarBear.getHabitat());
        assertEquals("V", polarBear.getStatus());
        assertEquals(26500, polarBear.getPopulation());
    }

    @Test
    public void testAddDonation(){
        polarBear.addDonation(1);
        assertEquals(1, polarBear.getDonation());
        polarBear.addDonation(2500);
        assertEquals(2501, polarBear.getDonation());
        polarBear.addDonation(5000);
        assertEquals(7501, polarBear.getDonation());
    }
}
