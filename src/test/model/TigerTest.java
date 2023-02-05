package model;

import model.bigcats.Tiger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TigerTest {
    private Tiger tiger;

    @BeforeEach
    public void setup(){
        tiger = new Tiger();
    }

    @Test
    public void testConstructor(){
        assertEquals(0,tiger.getDonation());
        assertEquals("Tiger", tiger.getName());
        assertEquals(4500, tiger.getPopulation());
        assertEquals("E", tiger.getStatus());
        assertEquals("Rainforests", tiger.getHabitat());
    }

    @Test
    public void testAddDonation(){
        tiger.addDonation(1);
        assertEquals(1, tiger.getDonation());
        tiger.addDonation(2500);
        assertEquals(2501, tiger.getDonation());
        tiger.addDonation(5000);
        assertEquals(7501, tiger.getDonation());
    }


}
