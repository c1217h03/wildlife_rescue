package persistence;

import model.Account;
import model.NotValidCardException;
import model.Zoo;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

//represents a testing class for a JsonReaderAuto.
public class JsonReaderAutoTest {

    //EFFECTS: tests trying to read from a non-existent file.
    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            Account acc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        } catch (NotValidCardException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testReadingZoo() {
        Zoo zoo = null;
        zoo = new Zoo();

        JsonWriter writer = new JsonWriter("./data/testJsonReaderAutoFile.json");
        try {
            writer.openFile();
        } catch (FileNotFoundException e) {
            fail();
        }
        writer.autoWrite(zoo);
        writer.close();

        JsonReaderAuto autoReader = new JsonReaderAuto("./data/testJsonReaderAutoFile.json");
        try {
            zoo = autoReader.read();
        } catch (IOException e) {
            fail();
        }
        assertEquals(11, zoo.getAnimalList().size());
    }
}
