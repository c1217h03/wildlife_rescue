package ui;

import model.Account;
import model.NotValidCardException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSInput;
import ui.InfoManager;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

//Testing code found from https://www.danvega.dev/blog/2020/12/16/testing-standard-in-out-java/
public class InfoManagerTest {
    private InfoManager info;
    private Scanner input;

    @BeforeEach
    public void setup() {
        info = new InfoManager();
        input = new Scanner(System.in);

    }

    @Test
    public void testInfoManagerConstructor()  {
        assertTrue(info.getProgramStatus());
    }

    @Test
    public void testNotValidCardExceptionNotThrown() throws NotValidCardException {

        try {
            Account account = new Account("charm", "4555 5555 5555 5555");
        } catch (NotValidCardException exception) {
            fail("The card you entered is not valid. Please try signing up again.");
        }
    }


    @Test
    public void testQuittingUserInput() {
        String userInput = String.format("quit");
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testSigningUpInput() {
        String userInput = String.format("sign up%sc%s4%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testSigningUpWithInvalidCardAtFirstInput() {
        String userInput = String.format("sign up%sc%s3%sc%s4%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookingAtFaves() {
        String userInput = String.format("sign up%sc%s4%sspecies%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }


    @Test
    public void testInvalidUserInput() {
        String userInput = String.format("s%squit",
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testInvalidCardInput() {
        String userInput = String.format("sign up%sc%s5%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookingAtPolarBear() {
        String userInput = String.format("sign up%sc%s4%sspecies%sbears%spolar bear%sadd%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testBackInput() {
        String userInput = String.format("sign up%sc%s4%sspecies%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testMarineAnimalInput() {
        String userInput = String.format("sign up%sc%s4%sspecies%s" +
                        "%smarine%sbeluga%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testInvalidSignUpInstruction() {
        String userInput = String.format("s%squit",
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testBelugaInput() {
        String userInput = String.format("sign up%sc%s4%species%s" +
                        "%smarine%sbeluga%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testWhaleSharkInput() {
        String userInput = String.format("sign up%sc%s4%species%s" +
                        "%smarine%swhale shark%sadd%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtFavesInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%smarine%swhale shark%sadd%sfaves%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtDonatedInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%smarine%snar whale%sdonate%s50%sdonated to%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtBigCatsInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sbig cats%ssnow leopard%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testWrongInputAnimalInfoPageInput() {
        String userInput = String.format("sign up%sc%s4%sspecies%srhinos%sblack rhino%sd%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtMarineAndBackInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%smarine%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtSumatranRhinoInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%srhinos%ssumatran rhino%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtRhinoAndBackInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%srhinos%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtRhinosAndQuitInput() {
        String userInput = String.format("sign up%sc%s4%sspecies%s" +
                        "rhinos%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtAFElephantInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%selephants%saf elephant%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtSumatranElephantInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%selephants%ssumatran elephant%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtElephantAndBackInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%selephants%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtGiantPandaInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sbears%sgiant panda%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtBearAndBackInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sbears%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtBearWrongInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sbears%sk%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtTigerInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sbig cats%stiger%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtTigerAndBackInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sbig cats%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtEmptyFavesInput() {
        String userInput = String.format("sign up%sc%s4%sfaves" +
                        "%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtBigCatsAndQuitInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sbig cats%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtBigCatsAndWrongInputInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sbig cats%sd%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtElephantsAndQuitInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%selephants%sNo%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtElephantsAndWrongInputInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%selephants%skl%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtAnimalNotInZoo() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%srhinos%safrican rhino",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "That animal doesn't exist.";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        try {
            Main.main(null); // call the main method
            fail();
        } catch (NullPointerException e) {
            //pass
        }

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtRhinoAndWrongInputInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%selephants%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtMarineAnimalsAndQuitInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%smarine%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtMarineAnimalsAndWrongInputInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%smarine%st%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtFavesAndWrongInputInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%smarine%sbeluga%sadd%sfaves%sd%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtCritical() {
        String userInput = String.format("sign up%sc%s4%scritical" +
                        "%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtEndangered() {
        String userInput = String.format("sign up%sc%s4%sendangered" +
                        "%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtVulnerable() {
        String userInput = String.format("sign up%sc%s4%svulnerable" +
                        "%sback%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLookAtRhinoAndWrongInput() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%srhinos%sblack rino%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testAddingAnAnimalAndSaving() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%srhinos%sblack rhino%sadd%ssave%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

    @Test
    public void testLoadingFromFile() {
        String userInput = String.format("sign up%sc%s4%sload" +
                        "%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);

    }

    @Test
    public void testAnimalNotInZoo() {
        String userInput = String.format("sign up%sc%s4%sspecies" +
                        "%sppolar%squit",
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator(),
                System.lineSeparator());
        ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(bais);

        String expected = "Quitting...";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);

        Main.main(null); // call the main method

        String[] lines = baos.toString().split(System.lineSeparator());
        String actual = lines[lines.length-1];

        // checkout output
        assertEquals(expected,actual);
    }

}
