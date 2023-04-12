package ui;

import model.Account;
import model.Animal;
import model.Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//class that represents the panel beside the sidebar that shows all the species.
public class SpeciesPanel extends JPanel implements ActionListener {
    private Zoo zoo;
    private List<Animal> animalList;
    private Account account;

    private AnimalButtons animalButtons;

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


    private JPanel masterPanel;
    private CardLayout cl;


    //EFFECTS: constructs a species panel
    public SpeciesPanel(Account account, Zoo zoo, JPanel master, CardLayout cards) {
        this.zoo = zoo;
        animalList = zoo.getAnimalList();
        this.animalButtons = new AnimalButtons();
        this.account = account;
        this.masterPanel = master;
        this.cl = cards;
        this.setOpaque(true);
        this.setBackground(new Color(51, 94, 17));
        this.setVisible(true);
        this.setBounds(500, 900, 750, 900);
        this.setLayout(new GridLayout(animalList.size(), 1));

        initializeAnimalButtons();
        addButtons(this);
    }

    //EFFECTS: initializes buttons that would lead to an animal.
    private void initializeAnimalButtons() {
        tigerButton = animalButtons.getAnimalButton("Tiger");
        tigerButton.addActionListener(this);
        snowLeopardButton = animalButtons.getAnimalButton("Snow Leopard");
        snowLeopardButton.addActionListener(this);
        giantPandaButton = animalButtons.getAnimalButton("Giant Panda");
        giantPandaButton.addActionListener(this);
        polarBearButton = animalButtons.getAnimalButton("Polar Bear");
        polarBearButton.addActionListener(this);
        blackRhinoButton = animalButtons.getAnimalButton("Black Rhino");
        blackRhinoButton.addActionListener(this);
        sumatranRhinoButton = animalButtons.getAnimalButton("Sumatran Rhino");
        sumatranRhinoButton.addActionListener(this);
        sumatranElephantButton = animalButtons.getAnimalButton("Sumatran Elephant");
        sumatranElephantButton.addActionListener(this);
        afElephantButton = animalButtons.getAnimalButton("African Forest Elephant");
        afElephantButton.addActionListener(this);
        whaleSharkButton = animalButtons.getAnimalButton("Whale Shark");
        whaleSharkButton.addActionListener(this);
        belugaWhaleButton = animalButtons.getAnimalButton("Beluga Whale");
        belugaWhaleButton.addActionListener(this);
        narWhaleButton = animalButtons.getAnimalButton("North Atlantic Right Whale");
        narWhaleButton.addActionListener(this);
    }

    //EFFECTS: adds the buttons to the given panel.
    private void addButtons(JPanel panel) {
        panel.add(tigerButton);
        panel.add(snowLeopardButton);
        panel.add(giantPandaButton);
        panel.add(polarBearButton);
        panel.add(blackRhinoButton);
        panel.add(sumatranRhinoButton);
        panel.add(sumatranElephantButton);
        panel.add(afElephantButton);
        panel.add(whaleSharkButton);
        panel.add(belugaWhaleButton);
        panel.add(narWhaleButton);

    }

    //EFFECTS: jumps to the actionPerformed method of the species panel class.
    public void handleActions(ActionEvent e) {
        actionPerformed(e);
    }


    //EFFECTS: manages the user actions.
    @Override
    public void actionPerformed(ActionEvent e) {
        AnimalButton source = (AnimalButton) e.getSource();
        if (source.equals(tigerButton) || source.equals(snowLeopardButton)) {
            handleBigCats(e);
        } else if (source.equals(giantPandaButton) || source.equals(polarBearButton)) {
            handleBears(e);
        } else if (source.equals(blackRhinoButton) || source.equals(sumatranRhinoButton)) {
            handleRhinos(e);
        } else if (source.equals(afElephantButton) || source.equals(sumatranElephantButton)) {
            handleElephants(e);
        } else {
            handleMarine(e);
        }
    }

    //EFFECTS: handles action if a big cat button was clicked.
    private void handleBigCats(ActionEvent e) {
        AnimalButton source = (AnimalButton) e.getSource();
        AnimalPanel panel = null;
        if (source.equals(tigerButton)) {
            panel = new AnimalPanel("Tiger", zoo, account);
        } else {
            panel = new AnimalPanel("Snow Leopard", zoo, account);
        }
        panel.setVisible(true);
        masterPanel.add(panel, "7");
        cl.show(masterPanel, "7");

    }

    //EFFECTS: handles action if a bear button was clicked.
    private void handleBears(ActionEvent e) {
        AnimalButton source = (AnimalButton) e.getSource();
        AnimalPanel panel = null;
        if (source.equals(giantPandaButton)) {
            panel = new AnimalPanel("Giant Panda", zoo, account);
        } else {
            panel = new AnimalPanel("Polar Bear", zoo, account);
        }
        panel.setVisible(true);
        masterPanel.add(panel, "7");
        cl.show(masterPanel, "7");
    }

    //EFFECTS: handles action if a rhino button was clicked.
    private void handleRhinos(ActionEvent e) {
        AnimalButton source = (AnimalButton) e.getSource();
        AnimalPanel panel = null;
        if (source.equals(blackRhinoButton)) {
            panel = new AnimalPanel("Black Rhino", zoo, account);
        } else {
            panel = new AnimalPanel("Sumatran Rhino", zoo, account);
        }
        panel.setVisible(true);
        masterPanel.add(panel, "7");
        cl.show(masterPanel, "7");
    }

    //EFFECTS: handles action if an elephant button was clicked.
    private void handleElephants(ActionEvent e) {
        AnimalButton source = (AnimalButton) e.getSource();
        AnimalPanel panel = null;
        if (source.equals(afElephantButton)) {
            panel = new AnimalPanel("African Forest Elephant", zoo, account);
        } else {
            panel = new AnimalPanel("Sumatran Elephant", zoo, account);
        }
        panel.setVisible(true);
        masterPanel.add(panel, "7");
        cl.show(masterPanel, "7");
    }

    //EFFECTS: handles action if a marine animal button was clicked.
    private void handleMarine(ActionEvent e) {
        AnimalButton source = (AnimalButton) e.getSource();
        AnimalPanel panel = null;
        if (source.equals(belugaWhaleButton)) {
            panel = new AnimalPanel("Beluga Whale", zoo, account);
        } else if (source.equals(whaleSharkButton)) {
            panel = new AnimalPanel("Whale Shark", zoo, account);
        } else {
            panel = new AnimalPanel("North Atlantic Right Whale", zoo, account);
        }
        panel.setVisible(true);
        masterPanel.add(panel, "7");
        cl.show(masterPanel, "7");
    }

    //EFFECTS: sets the account to the given account.
    public void setAccount(Account account) {
        this.account = account;
    }

}

