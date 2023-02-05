package model;

import model.marineanimals.WhaleShark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhaleSharkTest {
    private WhaleShark whaleShark;

    @BeforeEach
    public void setup(){
        whaleShark = new WhaleShark();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, whaleShark.getDonation());
        assertEquals("Whale Shark", whaleShark.getName());
        assertEquals("E", whaleShark.getStatus());
        assertEquals(200000, whaleShark.getPopulation());
        assertEquals("Ocean", whaleShark.getHabitat());
    }

    @Test
    public void testAddDonation(){
        whaleShark.addDonation(1);
        assertEquals(1, whaleShark.getDonation());
        whaleShark.addDonation(2500);
        assertEquals(2501, whaleShark.getDonation());
        whaleShark.addDonation(5000);
        assertEquals(7501, whaleShark.getDonation());
    }
}
