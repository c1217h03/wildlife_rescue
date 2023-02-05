package model;

import model.marineanimals.NorthAtlanticRWhale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NorthARWhaleTest {
    private NorthAtlanticRWhale northAtlanticRWhale;

    @BeforeEach
    public void setup(){
        northAtlanticRWhale = new NorthAtlanticRWhale();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, northAtlanticRWhale.getDonation());
        assertEquals("North Atlantic Right Whale", northAtlanticRWhale.getName());
        assertEquals("CE", northAtlanticRWhale.getStatus());
        assertEquals(366, northAtlanticRWhale.getPopulation());
        assertEquals("Ocean", northAtlanticRWhale.getHabitat());
    }

    @Test
    public void addDonation(){
        northAtlanticRWhale.addDonation(1);
        assertEquals(1, northAtlanticRWhale.getDonation());
        northAtlanticRWhale.addDonation(2500);
        assertEquals(2501, northAtlanticRWhale.getDonation());
        northAtlanticRWhale.addDonation(5000);
        assertEquals(7501, northAtlanticRWhale.getDonation());
    }
}
