package model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.*;

//represents a class for rhino testing
public class RhinoTest {
    private Rhino blackRhino;
    private Rhino sumatranRhino;


    @BeforeEach
    public void setup(){
        blackRhino = new Rhino("Black Rhino", "CE", "Savannah", 5500);
        sumatranRhino = new Rhino("Sumatran Rhino", "CE", "Tropical Forests", 80);
    }

    @Test
    public void testRhinoBlack(){
        assertEquals(0, blackRhino.getDonation());
        assertEquals("CE", blackRhino.getStatus());
        assertEquals("Black Rhino", blackRhino.getName());
        assertEquals("Rhino", blackRhino.getSpecies());
        assertEquals("Savannah", blackRhino.getHabitat());
        assertEquals(5500, blackRhino.getPopulation());
    }

    @Test
    public void testRhinoSumatran(){
        assertEquals(0, sumatranRhino.getDonation());
        assertEquals(80, sumatranRhino.getPopulation());
        assertEquals("CE", sumatranRhino.getStatus());
        assertEquals("Sumatran Rhino", sumatranRhino.getName());
        assertEquals("Tropical Forests", sumatranRhino.getHabitat());
        assertEquals("Rhino", sumatranRhino.getSpecies());
    }

    @Test
    public void testAddDonationMinimum(){
        sumatranRhino.addDonation(getMinDonation());
        assertEquals(getMinDonation(), sumatranRhino.getDonation());
    }

    @Test
    public void testAddDonationMiddle(){
        sumatranRhino.addDonation(getMaxDonation() / 2);
        assertEquals(getMaxDonation() / 2, sumatranRhino.getDonation());

    }

    @Test
    public void testAddDonationOneLessThanMax(){
        sumatranRhino.addDonation(getMaxDonation() - 1);
        assertEquals(getMaxDonation() - 1, sumatranRhino.getDonation() );
    }

    @Test
    public void testAddDonationMaximum(){
        sumatranRhino.addDonation(getMaxDonation());
        assertEquals(getMaxDonation(), sumatranRhino.getDonation());
    }

    @Test
    public void testBlackRhinotoJson() {
        JSONObject json = blackRhino.toJson();
        String name = json.getString("name");
        assertEquals(name, "Black Rhino");
        String habitat = json.getString("habitat");
        assertEquals(habitat, "Savannah");
        Double population = json.getDouble("population");
        assertEquals(population, 5500);
        Double donations = json.getDouble("donations");
        assertEquals(donations, 0);
        String species = json.getString("species");
        assertEquals(species, "Rhino");
        String status = json.getString("status");
        assertEquals(status, "CE");
    }

    @Test
    public void testSumatranRhinotoJson() {
        JSONObject json = sumatranRhino.toJson();
        String name = json.getString("name");
        assertEquals(name, "Sumatran Rhino");
        String habitat = json.getString("habitat");
        assertEquals(habitat, "Tropical Forests");
        Double population = json.getDouble("population");
        assertEquals(population, 80);
        Double donations = json.getDouble("donations");
        assertEquals(donations, 0);
        String species = json.getString("species");
        assertEquals(species, "Rhino");
        String status = json.getString("status");
        assertEquals(status, "CE");

    }

    @Test
    public void testEquals() {
        Rhino testRhino = new Rhino("Black Rhino", "CE", "Savannah", 5500);
        assertTrue(blackRhino.equals(testRhino));
        assertEquals(blackRhino.hashCode(), testRhino.hashCode());
    }

    @Test
    public void testNotEquals() {
        Rhino testRhino = new Rhino("Black Rhino", "CE", "Savannah", 5500);
        assertFalse(sumatranRhino.equals(testRhino));
        assertFalse(blackRhino.equals("Black Rhino"));
        assertNotEquals(sumatranRhino.hashCode(), testRhino.hashCode());
    }

}
