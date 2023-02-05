package model;

import model.bigcats.SnowLeopard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SnowLeopardTest {
    private SnowLeopard snowLeopard;

    @BeforeEach
    public void setup(){
        snowLeopard = new SnowLeopard();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, snowLeopard.getDonation());
        assertEquals("Snow Leopard", snowLeopard.getName());
        assertEquals("V", snowLeopard.getStatus());
        assertEquals(5000, snowLeopard.getPopulation());
        assertEquals("High Mountains", snowLeopard.getHabitat());

    }

    @Test
    public void testAddDonation(){
        snowLeopard.addDonation(1);
        assertEquals(1, snowLeopard.getDonation());
        snowLeopard.addDonation(2500);
        assertEquals(2501, snowLeopard.getDonation());
        snowLeopard.addDonation(5000);
        assertEquals(7501, snowLeopard.getDonation());
    }
}
