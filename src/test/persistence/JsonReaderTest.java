package persistence;

import model.Account;
import model.BigCat;
import model.MarineAnimal;
import model.NotValidCardException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


//represents a class for JsonReader testing
class JsonReaderTest {

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

    //EFFECTS: test reading an account with empty lists
    @Test
    void testReaderEmptyList() {
        Account acc = null;
        try {
            acc = new Account("Charm", "4444");
        } catch (NotValidCardException e) {
            fail();
        }
        JsonWriter writer = new JsonWriter("./data/testReaderAccountWithEmptyList.json");
        try {
            writer.openFile();
        } catch (FileNotFoundException e) {
            fail();
        }
        writer.writeToFile(acc);
        writer.close();


        JsonReader reader = new JsonReader("./data/testReaderAccountWithEmptyList.json");
        try {
            acc = reader.read();
            assertEquals("Charm", acc.getUsername());
            assertEquals("4444", acc.getCard());
            assertEquals(0, acc.getDonatedTo().size());
            assertEquals(0, acc.getFavorites().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        } catch (NotValidCardException e) {
            fail();
        }
    }


    //EFFECTS: testing an account with filled lists.
    @Test
    void testReaderGeneralWorkRoom() {
        Account acc = null;
        try {
            acc = new Account("Pho", "4545");
        } catch (NotValidCardException e) {
           fail();
        }
        acc.addToDonatedTo(new BigCat("Lion", "E", "Savannah", 15000));
        acc.addToFavorites(new BigCat("Lion", "E", "Savannah", 15000));
        acc.addToFavorites(new MarineAnimal("Seal", "V", "Oceans", 200000));
        JsonWriter writer = new JsonWriter("./data/testReaderGeneralAccount.json");
        try {
            writer.openFile();
        } catch (FileNotFoundException e) {
           fail();
        }
        writer.writeToFile(acc);
        writer.close();

        JsonReader reader = new JsonReader("./data/testReaderGeneralAccount.json");
        try {
            acc = reader.read();
        } catch (IOException e) {
            fail();
        } catch (NotValidCardException e) {
           fail();
        }
        assertEquals("Pho", acc.getUsername());
        assertEquals("4545", acc.getCard());
        assertEquals(2, acc.getFavorites().size());
        assertEquals(1, acc.getDonatedTo().size());
    }

}
