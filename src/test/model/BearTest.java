package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BearTest {
    private Bear polarBear;
    private Bear giantPanda;

    @BeforeEach
    public void setup(){
        polarBear = new Bear("Polar Bear", "V", "Arctic Ocean", 265000);
        giantPanda = new Bear("Giant Panda", "V", "Chinese Forests", 1864);
    }

    @Test
    public void testBearPolar(){
        assertEquals(0, polarBear.getDonation());
        assertEquals("Polar Bear", polarBear.getName());
        assertEquals("Bear", polarBear.getSpecies());
        assertEquals("V", polarBear.getStatus());
        assertEquals(265000, polarBear.getPopulation());
        assertEquals("Arctic Ocean", polarBear.getHabitat());
    }

    @Test
    public void testBearPanda(){
        assertEquals(0, giantPanda.getDonation());
        assertEquals("Giant Panda", giantPanda.getName());
        assertEquals("Bear", giantPanda.getSpecies());
        assertEquals("Chinese Forests", giantPanda.getHabitat());
        assertEquals("V", giantPanda.getStatus());
        assertEquals(1864, giantPanda.getPopulation());
    }

    @Test
    public void testAddDonation1(){
        giantPanda.addDonation(getMinDonation());
        assertEquals(getMinDonation(), giantPanda.getDonation());
    }

    @Test
    public void testAddDonationMiddle(){
        giantPanda.addDonation(getMaxDonation()/2);
        assertEquals(getMaxDonation()/2, giantPanda.getDonation());

    }

    @Test
    public void testAddDonationOneLessThanMax(){
        giantPanda.addDonation(getMaxDonation() - 1);
        assertEquals(getMaxDonation() - 1,giantPanda.getDonation() );
    }

    @Test
    public void testAddDonationMaximum(){
        giantPanda.addDonation(getMaxDonation());
        assertEquals(getMaxDonation(), giantPanda.getDonation());
    }
}
