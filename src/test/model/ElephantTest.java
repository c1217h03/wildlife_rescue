package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


//represents a class for elephant testing
public class ElephantTest {
    private Elephant afElephant;
    private Elephant sElephant;

    @BeforeEach
    public void setup(){
        afElephant = new Elephant("African Forest Elephant", "CE", "African Forests",
                415000);
        sElephant = new Elephant("Sumatran Elephant", "CE", "Tropical Forests", 2400);
    }

    @Test
    public void testElephantAF(){
        assertEquals(0, afElephant.getDonation());
        assertEquals("CE", afElephant.getStatus());
        assertEquals("African Forest Elephant", afElephant.getName());
        assertEquals(415000, afElephant.getPopulation());
        assertEquals("Elephant", afElephant.getSpecies());
        assertEquals("African Forests", afElephant.getHabitat());
    }

    @Test
    public void testElephantSumatran(){
        assertEquals(0, sElephant.getDonation());
        assertEquals(2400, sElephant.getPopulation());
        assertEquals("Sumatran Elephant", sElephant.getName());
        assertEquals("Elephant", sElephant.getSpecies());
        assertEquals("CE", sElephant.getStatus());
        assertEquals("Tropical Forests", sElephant.getHabitat());
    }

    @Test
    public void testAddDonation1(){
        afElephant.addDonation(getMinDonation());
        assertEquals(getMinDonation(), afElephant.getDonation());
    }

    @Test
    public void testAddDonationMiddle(){
        afElephant.addDonation(getMaxDonation() / 2);
        assertEquals(getMaxDonation() / 2, afElephant.getDonation());

    }

    @Test
    public void testAddDonationOneLessThanMax(){
        afElephant.addDonation(getMaxDonation() - 1);
        assertEquals(getMaxDonation() - 1, afElephant.getDonation() );
    }

    @Test
    public void testAddDonationMaximum(){
        afElephant.addDonation(getMaxDonation());
        assertEquals(getMaxDonation(), afElephant.getDonation());
    }

    @Test
    public void testAfElephanttoJson() {
        JSONObject json = afElephant.toJson();
        String name = json.getString("name");
        assertEquals(name, "African Forest Elephant");
        String habitat = json.getString("habitat");
        assertEquals(habitat, "African Forests");
        Double population = json.getDouble("population");
        assertEquals(population, 415000);
        Double donations = json.getDouble("donations");
        assertEquals(donations, 0);
        String species = json.getString("species");
        assertEquals(species, "Elephant");
        String status = json.getString("status");
        assertEquals(status, "CE");
    }

    @Test
    public void testSElephanttoJson() {
        JSONObject json = sElephant.toJson();
        String name = json.getString("name");
        assertEquals(name, "Sumatran Elephant");
        String habitat = json.getString("habitat");
        assertEquals(habitat, "Tropical Forests");
        Double population = json.getDouble("population");
        assertEquals(population, 2400);
        Double donations = json.getDouble("donations");
        assertEquals(donations, 0);
        String species = json.getString("species");
        assertEquals(species, "Elephant");
        String status = json.getString("status");
        assertEquals(status, "CE");

    }
}
