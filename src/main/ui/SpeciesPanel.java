package ui;

import model.Account;
import model.Animal;
import model.Zoo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SpeciesPanel extends JPanel implements ActionListener {
    private Zoo zoo;
    private List<Animal> animalList;
    private WildlifeRescueUI parentFrame;
    private Account account;

    private JButton tigerButton;
    private JButton snowLeopardButton;
    private JButton giantPandaButton;
    private JButton polarBearButton;
    private JButton blackRhinoButton;
    private JButton sumatranrRhinoButton;
    private JButton sumatranElephantButton;
    private JButton afElephantButton;
    private JButton whaleSharkButton;
    private JButton belugaWhaleButton;
    private JButton narWhaleButton;



    public SpeciesPanel(WildlifeRescueUI parent, Account account, Zoo zoo) {
        this.zoo = zoo;
        animalList = zoo.getAnimalList();
        parentFrame = parent;
        this.account = account;
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
        tigerButton = new AnimalButton("./data/tigerC.png", null);
        tigerButton.addActionListener(this);
        snowLeopardButton = new AnimalButton("./data/snowleopardC.jpeg", null);
        snowLeopardButton.addActionListener(this);
        giantPandaButton = new AnimalButton("./data/giantpandaC.jpeg", null);
        giantPandaButton.addActionListener(this);
        polarBearButton = new AnimalButton("./data/polarbearC.jpeg", null);
        polarBearButton.addActionListener(this);
        blackRhinoButton = new AnimalButton("./data/blackrhinoC.jpeg", null);
        blackRhinoButton.addActionListener(this);
        sumatranrRhinoButton = new AnimalButton("./data/sumatranrhinoC.jpeg", null);
        sumatranrRhinoButton.addActionListener(this);
        sumatranElephantButton = new AnimalButton("./data/sumatranelephantC.jpeg",
                null);
        sumatranElephantButton.addActionListener(this);
        afElephantButton = new AnimalButton("./data/afelephantC.jpeg", null);
        afElephantButton.addActionListener(this);
        whaleSharkButton = new AnimalButton("./data/whalesharkC.jpeg", null);
        whaleSharkButton.addActionListener(this);
        belugaWhaleButton = new AnimalButton("./data/belugaC.jpeg", null);
        belugaWhaleButton.addActionListener(this);
        narWhaleButton = new AnimalButton("./data/narwhaleC.jpeg", null);
        narWhaleButton.addActionListener(this);
    }

    private void addButtons(JPanel panel) {
        panel.add(tigerButton);
        panel.add(snowLeopardButton);
        panel.add(giantPandaButton);
        panel.add(polarBearButton);
        panel.add(blackRhinoButton);
        panel.add(sumatranrRhinoButton);
        panel.add(sumatranElephantButton);
        panel.add(afElephantButton);
        panel.add(whaleSharkButton);
        panel.add(belugaWhaleButton);
        panel.add(narWhaleButton);

    }

    public void handleActions(WildlifeRescueUI parent, ActionEvent e) {
        actionPerformed(e);
    }

    private void hideButtons() {
        tigerButton.hide();
        snowLeopardButton.hide();
        giantPandaButton.hide();
        polarBearButton.hide();
        blackRhinoButton.hide();
        sumatranElephantButton.hide();
        sumatranrRhinoButton.hide();
        afElephantButton.hide();
        whaleSharkButton.hide();
        narWhaleButton.hide();
        belugaWhaleButton.hide();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == tigerButton || source == snowLeopardButton) {
            handleBigCats(e);
        } else if (source == giantPandaButton || source == polarBearButton) {
            handleBears(e);
        } else if (source == blackRhinoButton || source == sumatranrRhinoButton) {
            handleRhinos(e);
        } else if (source == afElephantButton || source == sumatranElephantButton) {
            handleElephants(e);
        } else  {
            handleMarine(e);
        }
    }

    private void handleBigCats(ActionEvent e) {
        Object source = e.getSource();
        parentFrame.getDummyPane().setVisible(false);
        AnimalPanel panel = null;
        if (source == tigerButton) {
            panel = new AnimalPanel("Tiger", zoo, account);
        }
        else {
            panel = new AnimalPanel("Snow Leopard", zoo, account);
        }
        panel.setVisible(true);
        JPanel sidebar = parentFrame.getSideBar();
        parentFrame.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, panel));

    }

    private void handleBears(ActionEvent e) {
        Object source = e.getSource();
        parentFrame.getDummyPane().setVisible(false);
        AnimalPanel panel = null;
        if (source == giantPandaButton) {
            panel = new AnimalPanel("Giant Panda", zoo, account);
        } else {
            panel = new AnimalPanel("Polar Bear", zoo, account);
        }
        panel.setVisible(true);
        JPanel sidebar = parentFrame.getSideBar();
        parentFrame.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, panel));
    }

    private void handleRhinos(ActionEvent e) {
        Object source = e.getSource();
        parentFrame.getDummyPane().setVisible(false);
        AnimalPanel panel = null;
        if (source == giantPandaButton) {
            panel = new AnimalPanel("Black Rhino", zoo, account);
        } else {
            panel = new AnimalPanel("Sumatran Rhino", zoo, account);
        }
        panel.setVisible(true);
        JPanel sidebar = parentFrame.getSideBar();
        parentFrame.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, panel));
    }

    private void handleElephants(ActionEvent e) {
        Object source = e.getSource();
        parentFrame.getDummyPane().setVisible(false);
        AnimalPanel panel = null;
        if (source == giantPandaButton) {
            panel = new AnimalPanel("African Forest Elephant", zoo, account);
        } else {
            panel = new AnimalPanel("Sumatran Elephant", zoo, account);
        }
        panel.setVisible(true);
        JPanel sidebar = parentFrame.getSideBar();
        parentFrame.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, panel));
    }

    private void handleMarine(ActionEvent e) {
        Object source = e.getSource();
        parentFrame.getDummyPane().setVisible(false);
        AnimalPanel panel = null;
        if (source == giantPandaButton) {
            panel = new AnimalPanel("Beluga Whale", zoo, account);
        } else if (source == whaleSharkButton) {
            panel = new AnimalPanel("Whale Shark", zoo, account);
        } else {
            panel = new AnimalPanel("North Atlantic Right Whale", zoo, account);
        }
        panel.setVisible(true);
        JPanel sidebar = parentFrame.getSideBar();
        parentFrame.add(new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, panel));
    }
}

