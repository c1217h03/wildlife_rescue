package persistence;

import model.*;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


//represents a class for JsonWriter testing
public class JsonWriterTest{

    //EFFECTS: testing writing data into an invalid file.
    @Test
    public void testWriterInvalidFile() {
        try {
            Account acc = new Account("Charm", "4444");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.openFile();
            fail("IOException expected.");
        }catch (IOException e) {
            //pass
        } catch (NotValidCardException e) {
           fail("No exceptions expected, card is Visa.");
        }
    }

    //EFFECTS: testing an account with empty lists
    @Test
    public void testAccountWithEmptyLists() {
        try {
            Account acc = new Account("Charm", "4444");
            JsonWriter writer = new JsonWriter("./data/testWriterAccountWithEmptyList.json");
            writer.openFile();
            writer.writeToFile(acc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterAccountWithEmptyList.json");
            acc = reader.read();
            assertEquals("Charm", acc.getUsername());
            assertEquals("4444", acc.getCard());
        } catch (FileNotFoundException e) {
            fail();
        } catch (IOException e) {
            fail();
        } catch (NotValidCardException e) {
            fail();
        }
    }

    //EFFECTS: testing writing to a file an account with lists that have elements.
    @Test
    void testWriterAccountWithFilledLists() {
        try {
            Account acc = new Account("Pho", "4545");
            acc.addToDonatedTo(new BigCat("Lion", "E", "Savannah", 15000));
            acc.addToFavorites(new BigCat("Lion", "E", "Savannah", 15000));
            acc.addToFavorites(new MarineAnimal("Seal", "V", "Oceans", 200000));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralAccount.json");
            writer.openFile();
            writer.writeToFile(acc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralAccount.json");
            acc = reader.read();
            assertEquals("Pho", acc.getUsername());
            assertEquals("4545", acc.getCard());
            List<Animal> favorites = acc.getFavorites();
            List<Animal> donatedTo = acc.getDonatedTo();
            assertEquals(2, favorites.size());
            assertEquals(1, donatedTo.size());

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        } catch (NotValidCardException e) {
            fail();
        }
    }
}
