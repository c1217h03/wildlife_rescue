package model;

import model.rhinos.SumatranRhino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumatranRhinoTest {
    private SumatranRhino sumatranRhino;

    @BeforeEach
    public void setup(){
        sumatranRhino = new SumatranRhino();
    }

    @Test
    public void testConstructor(){
        assertEquals(0, sumatranRhino.getDonation());
        assertEquals("Sumatran Rhino", sumatranRhino.getName());
        assertEquals(80, sumatranRhino.getPopulation());
        assertEquals("CE", sumatranRhino.getStatus());
        assertEquals("Tropical Forests", sumatranRhino.getHabitat());
    }
}
