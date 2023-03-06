package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//represents a class for marine animal testing
public class MarineAnimalTest {

    private MarineAnimal belugaWhale;
    private MarineAnimal narWhale;
    private MarineAnimal whaleShark;



    @BeforeEach
    public void setup() {
        narWhale = new MarineAnimal("North Atlantic Right Whale", "CE", "Ocean", 366);
        belugaWhale = new MarineAnimal("Beluga Whale", "NT", "Ocean", 150000);
        whaleShark = new MarineAnimal("Whale Shark", "E", "Ocean", 200000);
    }

    @Test
    public void testMarineAnimalsNARWhale(){
        assertEquals(0, narWhale.getDonation());
        assertEquals("North Atlantic Right Whale", narWhale.getName());
        assertEquals("Marine Animal", narWhale.getSpecies());
        assertEquals("CE", narWhale.getStatus());
        assertEquals(366, narWhale.getPopulation());
        assertEquals("Ocean", narWhale.getHabitat());
    }

    @Test
    public void testMarineAnimalBeluga(){
        assertEquals(0, belugaWhale.getDonation());
        assertEquals(150000, belugaWhale.getPopulation());
        assertEquals("NT", belugaWhale.getStatus());
        assertEquals("Ocean", belugaWhale.getHabitat());
        assertEquals("Beluga Whale", belugaWhale.getName());
        assertEquals("Marine Animal", belugaWhale.getSpecies());
    }

    @Test
    public void testMarineAnimalWhaleShark(){
        assertEquals(0, whaleShark.getDonation());
        assertEquals("Ocean", whaleShark.getHabitat());
        assertEquals("Whale Shark", whaleShark.getName());
        assertEquals("E", whaleShark.getStatus());
        assertEquals(200000, whaleShark.getPopulation());
        assertEquals("Marine Animal", whaleShark.getSpecies());
    }

    @Test
    public void testAddDonation1(){
        narWhale.addDonation(getMinDonation());
        assertEquals(getMinDonation(), narWhale.getDonation());
    }

    @Test
    public void testAddDonationMiddle(){
        narWhale.addDonation(getMaxDonation()/2);
        assertEquals(getMaxDonation()/2, narWhale.getDonation());

    }

    @Test
    public void testAddDonationOneLessThanMax(){
        narWhale.addDonation(getMaxDonation() - 1);
        assertEquals(getMaxDonation() - 1,narWhale.getDonation() );
    }

    @Test
    public void testAddDonationMaximum(){
        narWhale.addDonation(getMaxDonation());
        assertEquals(getMaxDonation(), narWhale.getDonation());
    }

}
