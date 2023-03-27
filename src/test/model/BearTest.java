package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.*;

//represents a class for bear testing
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

    @Test
    public void testtoJsonPolar() {
        JSONObject json = polarBear.toJson();
        String name = json.getString("name");
        assertEquals(name, "Polar Bear");
        String habitat = json.getString("habitat");
        assertEquals(habitat, "Arctic Ocean");
        Double population = json.getDouble("population");
        assertEquals(population, 265000);
        Double donations = json.getDouble("donations");
        assertEquals(donations, 0);
        String species = json.getString("species");
        assertEquals(species, "Bear");
        String status = json.getString("status");
        assertEquals(status, "V");

    }

    @Test
    public void testtoJsonPanda() {
        JSONObject json = giantPanda.toJson();
        String name = json.getString("name");
        assertEquals(name, "Giant Panda");
        String habitat = json.getString("habitat");
        assertEquals(habitat, "Chinese Forests");
        Double population = json.getDouble("population");
        assertEquals(population, 1864);
        Double donations = json.getDouble("donations");
        assertEquals(donations, 0);
        String species = json.getString("species");
        assertEquals(species, "Bear");
        String status = json.getString("status");
        assertEquals(status, "V");
    }

    @Test
    public void testEquals() {
        Bear testBear = new Bear("Polar Bear", "V", "Arctic Ocean", 265000);
        assertTrue(polarBear.equals(testBear));
        assertEquals(testBear.hashCode(), polarBear.hashCode());
    }

    @Test
    public void testNotEquals() {
        Bear testBear = new Bear("Polar Bear", "V", "Arctic Ocean", 265000);
        assertFalse(giantPanda.equals(testBear));
        assertNotEquals(testBear.hashCode(), giantPanda.hashCode());
        assertFalse(polarBear.equals("Polar Bear"));
    }
}
