package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.*;


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
    public void testAddDonationOneLessThanMax() {
        tiger.addDonation(getMaxDonation() - 1);
        assertEquals(getMaxDonation() - 1, tiger.getDonation() );
    }

    @Test
    public void testAddDonationMaximum() {
        tiger.addDonation(getMaxDonation());
        assertEquals(getMaxDonation(), tiger.getDonation());
    }

    @Test
    public void testTigertoJson() {
        JSONObject json = tiger.toJson();
        String name = json.getString("name");
        assertEquals(name, "Tiger");
        String habitat = json.getString("habitat");
        assertEquals(habitat, "Rainforests");
        Double population = json.getDouble("population");
        assertEquals(population, 4500);
        Double donations = json.getDouble("donations");
        assertEquals(donations, 0);
        String species = json.getString("species");
        assertEquals(species, "Big Cat");
        String status = json.getString("status");
        assertEquals(status, "E");

    }

    @Test
    public void testSnowLeopard() {
        JSONObject json = snowLeopard.toJson();
        String name = json.getString("name");
        assertEquals(name, "Snow Leopard");
        String habitat = json.getString("habitat");
        assertEquals(habitat, "High Mountains");
        Double population = json.getDouble("population");
        assertEquals(population, 5000);
        Double donations = json.getDouble("donations");
        assertEquals(donations, 0);
        String species = json.getString("species");
        assertEquals(species, "Big Cat");
        String status = json.getString("status");
        assertEquals(status, "V");
    }

    @Test
    public void testEquals() {
        BigCat testBigCat = new BigCat("Snow Leopard", "V", "High Mountains", 5000);
        assertTrue(snowLeopard.equals(testBigCat));
        assertEquals(snowLeopard.hashCode(), testBigCat.hashCode());
    }

    @Test
    public void testNotEquals() {
        BigCat testBigCat = new BigCat("Snow Leopard", "V", "High Mountains", 5000);
        assertFalse(tiger.equals(testBigCat));
        assertNotEquals(tiger.hashCode(), testBigCat.hashCode());
        assertFalse(snowLeopard.equals("Snow Leopard"));
    }

}
