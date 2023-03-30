package ui;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

//class that represents a collection of animal buttons.
public class AnimalButtons {
    private Map<String, AnimalButton> animalButtons;
    private AnimalButton tigerButton;
    private AnimalButton snowLeopardButton;
    private AnimalButton giantPandaButton;
    private AnimalButton polarBearButton;
    private AnimalButton blackRhinoButton;
    private AnimalButton sumatranRhinoButton;
    private AnimalButton sumatranElephantButton;
    private AnimalButton afElephantButton;
    private AnimalButton whaleSharkButton;
    private AnimalButton belugaWhaleButton;
    private AnimalButton narWhaleButton;


    //EFFECTS: constructs a map that stores animal buttons and the names of the animal.
    public AnimalButtons() {
        this.animalButtons = new HashMap<>();
        initializeAnimalButtons();
        addButtonsToMap();
    }

    //EFFECTS: initializes the animal buttons of all the species.
    private void initializeAnimalButtons() {
        tigerButton = new AnimalButton("./data/tigerC.png", null);

        snowLeopardButton = new AnimalButton("./data/snowleopardC.jpeg", null);

        giantPandaButton = new AnimalButton("./data/giantpandaC.jpeg", null);

        polarBearButton = new AnimalButton("./data/polarbearC.jpeg", null);

        blackRhinoButton = new AnimalButton("./data/blackrhinoC.jpeg", null);

        sumatranRhinoButton = new AnimalButton("./data/sumatranrhinoC.jpeg", null);

        sumatranElephantButton = new AnimalButton("./data/sumatranelephantC.jpeg",
                null);
        afElephantButton = new AnimalButton("./data/afelephantC.jpeg", null);

        whaleSharkButton = new AnimalButton("./data/whalesharkC.jpeg", null);

        belugaWhaleButton = new AnimalButton("./data/belugaC.jpeg", null);

        narWhaleButton = new AnimalButton("./data/narwhaleC.jpeg", null);

    }

    //MODIFIES: this
    //EFFECTS: adds the buttons to the map, with their name as a key.
    private void addButtonsToMap() {
        animalButtons.put("Tiger", tigerButton);
        animalButtons.put("Snow Leopard", snowLeopardButton);
        animalButtons.put("Giant Panda", giantPandaButton);
        animalButtons.put("Polar Bear", polarBearButton);
        animalButtons.put("Black Rhino", blackRhinoButton);
        animalButtons.put("Sumatran Rhino", sumatranRhinoButton);
        animalButtons.put("African Forest Elephant", afElephantButton);
        animalButtons.put("Sumatran Elephant", sumatranElephantButton);
        animalButtons.put("Beluga Whale", belugaWhaleButton);
        animalButtons.put("Whale Shark", whaleSharkButton);
        animalButtons.put("North Atlantic Right Whale", narWhaleButton);
    }

    //getters:

    public Map<String, AnimalButton> getAnimalButtons() {
        return animalButtons;
    }

    public AnimalButton getAnimalButton(String name) {
        return animalButtons.get(name);
    }

}
