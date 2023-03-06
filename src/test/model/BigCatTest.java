package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


//represents a class for big cat testing
public class BigCatTest {
    private BigCat snowLeopard;
    private BigCat tiger;

    @BeforeEach
    public void setup(){
        snowLeopard = new BigCat("Snow Leopard", "V", "High Mountains", 5000);
        tiger = new BigCat("Tiger", "E", "Rainforests", 4500);
    }

    @Test
    public void testBigCatConstructorSnowLeopard(){
        assertEquals("Snow Leopard", snowLeopard.getName());
        assertEquals("V", snowLeopard.getStatus());
        assertEquals(0, snowLeopard.getDonation());
        assertEquals(5000, snowLeopard.getPopulation());
        assertEquals("High Mountains", snowLeopard.getHabitat());
        assertEquals("Big Cat", snowLeopard.getSpecies());

    }

    @Test
    public void testBigCatConstructorTiger(){
        assertEquals(0, tiger.getDonation());
        assertEquals(4500, tiger.getPopulation());
        assertEquals("E", tiger.getStatus());
        assertEquals("Tiger", tiger.getName());
        assertEquals("Rainforests", tiger.getHabitat());
        assertEquals("Big Cat", tiger.getSpecies());
    }

    @Test
    public void testAddDonation1(){
        tiger.addDonation(getMinDonation());
        assertEquals(getMinDonation(), tiger.getDonation());
    }

    @Test
    public void testAddDonationMiddle(){
        tiger.addDonation(getMaxDonation() / 2);
        assertEquals(getMaxDonation() / 2, tiger.getDonation());

    }

    @Test
    public void testAddDonationOneLessThanMax(){
        tiger.addDonation(getMaxDonation() - 1);
        assertEquals(getMaxDonation() - 1, tiger.getDonation() );
    }

    @Test
    public void testAddDonationMaximum(){
        tiger.addDonation(getMaxDonation());
        assertEquals(getMaxDonation(), tiger.getDonation());
    }
}
