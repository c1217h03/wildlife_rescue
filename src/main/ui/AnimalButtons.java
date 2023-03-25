package ui;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class AnimalButtons {
    private Map<String, AnimalButton> animalButtons;
    private AnimalButton tigerButton;
    private AnimalButton snowLeopardButton;
    private AnimalButton giantPandaButton;
    private AnimalButton polarBearButton;
    private AnimalButton blackRhinoButton;
    private AnimalButton sumatranrRhinoButton;
    private AnimalButton sumatranElephantButton;
    private AnimalButton afElephantButton;
    private AnimalButton whaleSharkButton;
    private AnimalButton belugaWhaleButton;
    private AnimalButton narWhaleButton;


    public AnimalButtons() {
        this.animalButtons = new HashMap<>();
        initializeAnimalButtons();
        addButtonsToMap();
    }

    private void initializeAnimalButtons() {
        tigerButton = new AnimalButton("./data/tigerC.png", null);

        snowLeopardButton = new AnimalButton("./data/snowleopardC.jpeg", null);

        giantPandaButton = new AnimalButton("./data/giantpandaC.jpeg", null);

        polarBearButton = new AnimalButton("./data/polarbearC.jpeg", null);

        blackRhinoButton = new AnimalButton("./data/blackrhinoC.jpeg", null);

        sumatranrRhinoButton = new AnimalButton("./data/sumatranrhinoC.jpeg", null);

        sumatranElephantButton = new AnimalButton("./data/sumatranelephantC.jpeg",
                null);
        afElephantButton = new AnimalButton("./data/afelephantC.jpeg", null);

        whaleSharkButton = new AnimalButton("./data/whalesharkC.jpeg", null);

        belugaWhaleButton = new AnimalButton("./data/belugaC.jpeg", null);

        narWhaleButton = new AnimalButton("./data/narwhaleC.jpeg", null);

    }

    private void addButtonsToMap() {
        animalButtons.put("Tiger", tigerButton);
        animalButtons.put("Snow Leopard", snowLeopardButton);
        animalButtons.put("Giant Panda", giantPandaButton);
        animalButtons.put("Polar Bear", polarBearButton);
        animalButtons.put("Black Rhino", blackRhinoButton);
        animalButtons.put("Sumatran Rhino", sumatranrRhinoButton);
        animalButtons.put("African Forest Elephant", afElephantButton);
        animalButtons.put("Sumatran Elephant", sumatranElephantButton);
        animalButtons.put("Beluga Whale", belugaWhaleButton);
        animalButtons.put("Whale Shark", whaleSharkButton);
        animalButtons.put("North Atlantic Right Whale", narWhaleButton);
    }

    public Map<String, AnimalButton> getAnimalButtons() {
        return animalButtons;
    }

    public AnimalButton getAnimalButton(String name) {
        return animalButtons.get(name);
    }

}
