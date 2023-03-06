package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

//represents the class that deals with user input.
public class InfoManager {
    private static final Rhino blackRhino = new Rhino("Black Rhino", "CE", "Savannah",
            5500);
    private static final Rhino sumatranRhino = new Rhino("Sumatran Rhino", "CE", "Tropical Forests",
            80);
    private static final MarineAnimal narWhale = new MarineAnimal("North Atlantic Right Whale", "CE",
            "Ocean", 366);
    private static final MarineAnimal belugaWhale = new MarineAnimal("Beluga Whale", "NT", "Ocean",
            150000);
    private static final Bear polarBear = new Bear("Polar Bear", "V", "Arctic Ocean",
            265000);
    private static final Bear giantPanda = new Bear("Giant Panda", "V", "Chinese Forests",
            1864);
    private static final BigCat snowLeopard = new BigCat("Snow Leopard", "V", "High Mountains",
            5000);
    private static final BigCat tiger = new BigCat("Tiger", "E", "Rainforests", 4500);
    private static final Elephant afElephant = new Elephant("African Forest Elephant", "CE",
            "African Forests", 415000);
    private static final Elephant sElephant = new Elephant("Sumatran Elephant", "CE",
            "Tropical Forests",2400);
    private static final MarineAnimal whaleShark = new MarineAnimal("Whale Shark", "E", "Ocean",
            200000);

    //Sign up commands
    private static final String SIGN_UP = "sign up";
    //private static final String LOG_IN = "log in";

    //The Welcome Page Commands
    private static final String FAVORITES = "faves";
    private static final String DONATED_TO = "donated to";
    private static final String SPECIES = "species";
    private static final String QUIT = "quit";

    //Species Commands
    private static final String BEAR = "bears";
    private static final String BIG_CATS = "big cats";
    private static final String ELEPHANT = "elephants";
    private static final String MARINE_ANIMALS = "marine";
    private static final String RHINO = "rhinos";

    //Animal Commands
    private static final String GIANT_PANDA = "giant panda";
    private static final String POLAR_BEAR = "polar bear";
    private static final String SNOW_LEOPARD = "snow leopard";
    private static final String TIGER = "tiger";
    private static final String AF_ELEPHANT = "af elephant";
    private static final String S_ELEPHANT = "sumatran elephant";
    private static final String WHALE_SHARK = "whale shark";
    private static final String NAR_WHALE = "nar whale";
    private static final String BELUGA_WHALE = "beluga";
    private static final String BLACK_RHINO = "black rhino";
    private static final String SUMATRAN_RHINO = "sumatran rhino";

    //Extra Commands
    private static final String ADD_TO_FAVES = "add";
    private static final String DONATE = "donate";
    private static final String BACK_COMMAND = "back";
    private static final String CRITICAL = "critical";
    private static final String ENDANGERED = "endangered";
    private static final String VULNERABLE = "vulnerable";
    private static final String SAVE = "save";
    private static final String LOAD = "load";

    private static final String FILENAME = "./data/saved.json";

    private final Scanner input;
    private boolean runProgram;
    private Account account;
    private List<Animal> animals = new ArrayList<>();
    private List<Animal> animalList = addingAnimals();
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    public InfoManager() {
        input = new Scanner(System.in);
        runProgram = true;
        jsonReader = new JsonReader(FILENAME);
        jsonWriter = new JsonWriter(FILENAME);

    }

    //FROM FitLifeGymChain
    //EFFECTS: handles user input until they quit the program.
    public void handleUserInput() {
        printSignUpInstruction();
        String string;

        while (runProgram) {
            string = getUserInput();
            parseInput(string);
        }
    }

    //FROM FitLifeGymChain
    //EFFECTS: handles the user inputs in the sign-up page.
    private void parseInput(String string) {
        switch (string) {
            case SIGN_UP:
                handleSignUpInput(string);
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
            default:
                defaultMessage();
                printSignUpInstruction();
                break;
        }
    }

    //EFFECTS: print the instructions for a Sign-up or log-in.
    private void printSignUpInstruction() {
        System.out.println("\nPlease sign up to enter Wildlife Rescue.\n");
        System.out.println("To sign up enter: " + SIGN_UP);
        System.out.println("To quit enter: " + QUIT);
    }

    //EFFECTS: handles the user input for signing up.
    private void handleSignUpInput(String str) {
        String username;
        String card;
        if (str.equals(SIGN_UP)) {
            System.out.println("Enter your new username");
            username = input.nextLine();
            System.out.println("Enter your card number. We only accept Visa.");
            card = input.nextLine();
            try {
                this.account = new Account(username, card);
                System.out.println("Username: " + this.account.getUsername() + "\n");
                printWelcomeInstruction();
            } catch (NotValidCardException e) {
                System.out.println("The card you entered is not valid. Please try signing up again.");
                printSignUpInstruction();
            }

        }
    }


    //EFFECTS: print the instructions for the welcome page
    private void printWelcomeInstruction() {
        System.out.println("Welcome " + account.getUsername() + " to Wildlife Rescue!");
        System.out.println("To see animals enter: " + SPECIES);
        System.out.println("To see your favorite animals enter: " + FAVORITES);
        System.out.println("To see your previous donations enter: " + DONATED_TO);
        System.out.println("To see critically endangered animals enter: " + CRITICAL);
        System.out.println("To see endangered animals enter: " + ENDANGERED);
        System.out.println("To see vulnerable animals enter: " + VULNERABLE);
        System.out.println("Would you like to save your favorites list? enter: " + SAVE);
        System.out.println("If you would like to load your favorites list enter: " + LOAD);
        System.out.println("To quit enter: " + QUIT);
        handleWelcomeInput();
    }

    private void welcomeInputPrintListOfAnimal(String s) {
        switch (s) {
            case FAVORITES:
                printListOfAnimals((this.account).getFavorites());
                break;
            case DONATED_TO:
                printListOfAnimals((this.account).getDonatedTo());
                break;
            case CRITICAL:
                printListOfAnimals(getCritical(animalList));
                break;
            case ENDANGERED:
                printListOfAnimals(getEndangered(animalList));
                break;
            case VULNERABLE:
                printListOfAnimals(getVulnerable(animalList));
                break;

        }
    }

    private void welcomeInputSavingLoadingAndQuitting(String s) {
        switch (s) {
            case LOAD:
                loadFile();
                printWelcomeInstruction();
                break;
            case SAVE:
                saveFile();
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
        }
    }

    //EFFECTS: handles the user's input for the welcome instructions
    private void handleWelcomeInput() {
        String str = input.nextLine();
        switch (str) {
            case SPECIES:
                printSpeciesInstruction();
                break;
            case FAVORITES:
            case DONATED_TO:
            case CRITICAL:
            case ENDANGERED:
            case VULNERABLE:
                welcomeInputPrintListOfAnimal(str);
                break;
            case LOAD:
            case SAVE:
            case QUIT:
                welcomeInputSavingLoadingAndQuitting(str);
                break;
            default:
                defaultMessage();
                printWelcomeInstruction();
                break;
        }
    }

    //EFFECTS: print the instructions to look at species
    private void printSpeciesInstruction() {
        System.out.println("To see bears enter: " + BEAR);
        System.out.println("To see big cats enter: " + BIG_CATS);
        System.out.println("To see elephants enter: " + ELEPHANT);
        System.out.println("To see marine animals enter: " + MARINE_ANIMALS);
        System.out.println("To see rhinos enter: " + RHINO);
        System.out.println("To go back enter: " + BACK_COMMAND);
        System.out.println("To quit enter: " + QUIT);
        handleSpeciesInput();
    }

    private void speciesInputSpecificSpecies(String str) {
        switch (str) {
            case BEAR:
                printBearsInstruction();
                break;
            case BIG_CATS:
                printBigCatsInstruction();
                break;
            case ELEPHANT:
                printElephantsInstruction();
                break;
            case MARINE_ANIMALS:
                printMarineAnimalsInstructions();
                break;
            case RHINO:
                printRhinosInstruction();
                break;
        }

    }

    //EFFECTS: handles user inputs for species instructions.
    private void handleSpeciesInput() {
        String str = input.nextLine();
        switch (str) {
            case BEAR:
            case MARINE_ANIMALS:
            case BIG_CATS:
            case ELEPHANT:
            case RHINO:
                speciesInputSpecificSpecies(str);
                break;
            case BACK_COMMAND:
                printWelcomeInstruction();
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
            default:
                defaultMessage();
                printSpeciesInstruction();
                break;
        }
    }

    //EFFECTS: print the instructions to look at bears
    private void printBearsInstruction() {
        System.out.println("To see the Polar Bear enter: " + POLAR_BEAR);
        System.out.println("To see the Giant Panda enter: " + GIANT_PANDA);
        System.out.println("To go back enter: " + BACK_COMMAND);
        System.out.println("To quit enter: " + QUIT);
        handleBearInstructions();
    }

    //EFFECTS: handles the user input for bear instructions
    private void handleBearInstructions() {
        String str = input.nextLine();
        switch (str) {
            case POLAR_BEAR:
                printAnimalInfo(polarBear);
                break;
            case GIANT_PANDA:
                printAnimalInfo(giantPanda);
                break;
            case BACK_COMMAND:
                printSpeciesInstruction();
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
            default:
                defaultMessage();
                printBearsInstruction();
                break;
        }
    }


    //EFFECTS: print the instructions to look at big cats
    private void printBigCatsInstruction() {
        System.out.println("To see the Snow Leopard enter: " + SNOW_LEOPARD);
        System.out.println("To see the Tiger enter: " + TIGER);
        System.out.println("To go back enter: " + BACK_COMMAND);
        System.out.println("To quit enter: " + QUIT);
        handleBigCatsInstructions();
    }

    //EFFECTS: handles the user input for big cat instructions
    private void handleBigCatsInstructions() {
        String str = input.nextLine();
        switch (str) {
            case TIGER:
                printAnimalInfo(tiger);
                break;
            case SNOW_LEOPARD:
                printAnimalInfo(snowLeopard);
                break;
            case BACK_COMMAND:
                printSpeciesInstruction();
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
            default:
                defaultMessage();
                printBigCatsInstruction();
                break;
        }
    }


    //EFFECTS: print the instructions to look at elephants
    private void printElephantsInstruction() {
        System.out.println("To see the African Forest Elephant enter: " + AF_ELEPHANT);
        System.out.println("To see the Sumatran Elephant enter:" + S_ELEPHANT);
        System.out.println("To go back enter: " + BACK_COMMAND);
        System.out.println("To quit enter: " + QUIT);
        handleElephantsInstructions();
    }

    //EFFECTS: handles the user input for elephant instructions
    private void handleElephantsInstructions() {
        String str = input.nextLine();
        switch (str) {
            case AF_ELEPHANT:
                printAnimalInfo(afElephant);
                break;
            case S_ELEPHANT:
                printAnimalInfo(sElephant);
                break;
            case BACK_COMMAND:
                printSpeciesInstruction();
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
            default:
                defaultMessage();
                printElephantsInstruction();
                break;
        }
    }


    //EFFECTS: print the instructions to look at rhinos
    private void printRhinosInstruction() {
        System.out.println("To see the Black Rhino enter: " + BLACK_RHINO);
        System.out.printf("To see the Sumatran Rhino enter: " + SUMATRAN_RHINO);
        System.out.println("\nTo go back enter: " + BACK_COMMAND);
        System.out.println("To quit enter: " + QUIT);
        handleRhinosInstructions();
    }

    //EFFECTS:  handle the user input for rhino instructions
    private void handleRhinosInstructions() {
        String str = input.nextLine();
        switch (str) {
            case BLACK_RHINO:
                printAnimalInfo(blackRhino);
                break;
            case SUMATRAN_RHINO:
                printAnimalInfo(sumatranRhino);
                break;
            case BACK_COMMAND:
                printSpeciesInstruction();
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
            default:
                defaultMessage();
                printRhinosInstruction();
                break;
        }
    }

    //EFFECTS: print the instructions to look at marine animals
    private void printMarineAnimalsInstructions() {
        System.out.println("To see the Whale Shark enter: " + WHALE_SHARK);
        System.out.println("To see the North Atlantic Right Whale enter: " + NAR_WHALE);
        System.out.println("To see the Beluga Whale enter:" + BELUGA_WHALE);
        System.out.println("To go back enter: " + BACK_COMMAND);
        System.out.println("To quit enter: " + QUIT);
        handleMarineAnimalsInstructions();
    }

    //EFFECTS: handle the user input for marine animal instructions
    private void handleMarineAnimalsInstructions() {
        String str = input.nextLine();
        switch (str) {
            case WHALE_SHARK:
                printAnimalInfo(whaleShark);
                break;
            case NAR_WHALE:
                printAnimalInfo(narWhale);
                break;
            case BELUGA_WHALE:
                printAnimalInfo(belugaWhale);
                break;
            case BACK_COMMAND:
                printSpeciesInstruction();
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
            default:
                defaultMessage();
                printMarineAnimalsInstructions();
                break;

        }
    }

    //EFFECTS: prints an animal's information
    private void printAnimalInfo(Animal animal) {
        System.out.println("\n" + animal.getName() + "\n");
        System.out.println("Status: " + animal.getStatus());
        System.out.println("Species:" + animal.getSpecies());
        System.out.println("Population: " + animal.getPopulation());
        System.out.println("Habitat: " + animal.getHabitat());
        System.out.println("Current Donations: " + animal.getDonation());
        System.out.println("Add to favorites? Enter: " + ADD_TO_FAVES);
        System.out.println("To donate enter: " + DONATE);
        System.out.println("To go back enter: " + BACK_COMMAND);
        System.out.println("To quit enter: " + QUIT);
        handleAnimalInfoInstructions(animal);
    }

    //EFFECTS: handles the instructions in the animal info page.
    private void handleAnimalInfoInstructions(Animal animal) {
        String str = input.nextLine();
        switch (str) {
            case BACK_COMMAND:
                printSpeciesInstruction();
                break;
            case QUIT:
                runProgram = false;
                endProgram();
                break;
            case ADD_TO_FAVES:
                this.account.addToFavorites(animal);
                System.out.println(animal.getName() + " was added to your favorites list.\n");
                printWelcomeInstruction();
                break;
            case DONATE:
                handleDonateInstructions(animal);
                break;
            default:
                defaultMessage();
                printAnimalInfo(animal);
                break;
        }
    }

    //EFFECTS: handles the donations the account is making
    private void handleDonateInstructions(Animal animal) {
        System.out.println("Enter the amount you want to donate.");
        String str = input.nextLine();
        this.account.donate(parseInt(str), animal);
        System.out.println(animal.getName() + "s " + "thank you for your donations\n");
        printWelcomeInstruction();
    }

    //EFFECTS: prints out the names of all the animals in the list.
    private void printListOfAnimals(List<Animal> animalList) {
        String listOfAnimals = "";

        for (int i = 0; i < animalList.size(); i++) {
            listOfAnimals = listOfAnimals + "\n" + (animalList.get(i)).getName();
        }
        if (listOfAnimals.equals("")) {
            System.out.println("You have no animals in your list.\n");
            printWelcomeInstruction();
        } else {
            System.out.printf(listOfAnimals + "\n\n");
            System.out.println("To go back enter: " + BACK_COMMAND);
            handlePrintListInstructions(animalList);
        }
    }

    private void handlePrintListInstructions(List<Animal> animalList) {
        String str = input.nextLine();
        if (BACK_COMMAND.equals(str)) {
            printWelcomeInstruction();
        } else {
            defaultMessage();
            printListOfAnimals(animalList);
        }
    }


    //FROM FitLifeGymChain
    //EFFECTS: quit the program.
    private void endProgram() {
        System.out.println("Quitting...");
        input.close();
    }

    //EFFECTS: prints out this message if the message is not the one specified.
    private void defaultMessage() {
        System.out.println("\nSorry we didn't understand that command. Please try again.\n");
    }

    //FROM FitLifeGymChain
    //EFFECTS: removes white space and quotation marks around s and returns the new string
    private String makePrettyString(String s) {
        s = s.toLowerCase();
        s = s.trim();
        s = s.replaceAll("\"|'", "");
        return s;
    }

    //FROM FitLifeGymChain
    //EFFECTS: returns the input the user entered.
    public String getUserInput() {
        String string = "";
        if (input.hasNext()) {
            string = input.nextLine();
            string = makePrettyString(string);
        }
        return string;
    }

    //EFFECTS: returns the animals that are "critically" endangered from the animals list.
    private List<Animal> getCritical(List<Animal> animalsList) {
        List<Animal> critical = new ArrayList<>();
        for (Animal a : animalsList) {
            if (a.getStatus() == "CE") {
                critical.add(a);
            }
        }
        return critical;
    }

    //EFFECTS: returns the animals that are "endangered" from the animals list.
    private List<Animal> getEndangered(List<Animal> animalsList) {
        List<Animal> endangered = new ArrayList<>();
        for (Animal a : animalsList) {
            if (a.getStatus() == "E" || a.getStatus() == "CE") {
                endangered.add(a);
            }
        }
        return endangered;
    }

    //EFFECTS: returns the animals that are "vulnerable" from the animals list.
    private List<Animal> getVulnerable(List<Animal> animalsList) {
        List<Animal> endangered = new ArrayList<>();
        for (Animal a : animalsList) {
            if (a.getStatus() == "V") {
                endangered.add(a);
            }
        }
        return endangered;
    }

    public boolean getProgramStatus() {
        return runProgram;
    }

    //EFFECTS: adds the animals to the animals list.
    private List<Animal> addingAnimals() {
        animals.add(blackRhino);
        animals.add(sumatranRhino);
        animals.add(afElephant);
        animals.add(sElephant);
        animals.add(polarBear);
        animals.add(giantPanda);
        animals.add(snowLeopard);
        animals.add(tiger);
        animals.add(whaleShark);
        animals.add(belugaWhale);
        animals.add(narWhale);

        return animals;
    }

    //MODIFIES: this
    //EFFECTS: load the user's favorites list from file.
    private void loadFile() {
        try {
            account = jsonReader.read();
            System.out.println("Loaded " + account.getUsername() + "'s account from " + FILENAME);
        } catch (IOException e) {
            System.out.println("File Not Found. Couldn't load data.");
            printWelcomeInstruction();
        } catch (NotValidCardException e) {
            System.out.println("The card you entered is not valid. Please try signing up again.");
            printWelcomeInstruction();
        }
    }

    //EFFECTS: save the user's favorites list to file.
    private void saveFile() {
        try {
            jsonWriter.openFile();
            jsonWriter.writeToFile(account);
            jsonWriter.close();
            System.out.println("Saved " + account.getUsername() + " to " + FILENAME);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + FILENAME);
        }
    }


}



