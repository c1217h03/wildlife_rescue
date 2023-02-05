package model;

import model.elephants.AfricanForestElephant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AFElephantTest {
    private AfricanForestElephant africanForestElephant;

    @BeforeEach
    public void setup(){
        africanForestElephant = new AfricanForestElephant();
    }

    @Test
    public void testConstructor(){
        assertEquals("African Forest Elephant", africanForestElephant.getName());
        assertEquals(0, africanForestElephant.getDonation());
        assertEquals("CE", africanForestElephant.getStatus());
        assertEquals(415000, africanForestElephant.getPopulation());
        assertEquals("African Forests", africanForestElephant.getHabitat());
    }

    @Test
    public void testAddDonation(){
        africanForestElephant.addDonation(1);
        assertEquals(1, africanForestElephant.getDonation());
        africanForestElephant.addDonation(2500);
        assertEquals(2501, africanForestElephant.getDonation());
        africanForestElephant.addDonation(5000);
        assertEquals(7501, africanForestElephant.getDonation());
    }

}
