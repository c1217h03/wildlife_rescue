package model;

import model.marineanimals.BelugaWhale;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BelugaWhaleTest {
    private BelugaWhale belugaWhale;

    @BeforeEach
    public void setup(){
        belugaWhale = new BelugaWhale();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, belugaWhale.getDonation());
        assertEquals("Beluga Whale", belugaWhale.getName());
        assertEquals("NT", belugaWhale.getStatus());
        assertEquals(150000, belugaWhale.getPopulation());
        assertEquals("Ocean", belugaWhale.getHabitat());
    }
}
