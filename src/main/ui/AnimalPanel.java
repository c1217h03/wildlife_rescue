package ui;

import model.Account;
import model.Animal;
import model.Zoo;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class AnimalPanel extends JPanel implements ActionListener {
    private JLabel name;
    private JLabel status;
    private JLabel species;
    private JLabel population;
    private JLabel habitat;
    private JLabel donations;

    private JOptionPane donatingPane;

    private JPanel masterPanel;
    private CardLayout cl;

    private JButton faves;
    private JButton donate;
    private JButton remove;

    private Account account;
    private Animal animal;
    private Zoo zoo;
    private JsonWriter jsonWriterAuto;


    private static final String AUTO_FILE = "./data/auto.json";

    public AnimalPanel(String animal, Zoo zoo, Account account) {
        super();
        this.setSize(WildlifeRescueUI.WIDTH, WildlifeRescueUI.HEIGHT);
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.account = account;
        this.zoo = zoo;
        this.jsonWriterAuto = new JsonWriter(AUTO_FILE);

        this.animal = zoo.getSpecificAnimal(animal);
        initializeLabels();

        this.add(name);
        this.add(status);
        this.add(species);
        this.add(population);
        this.add(habitat);
        this.add(donations);
        this.setVisible(true);

        initializeButtons();

    }

    private void initializeLabels() {
        name = new JLabel("\n" + this.animal.getName() + "\n");
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        name.setForeground(new Color(54, 94, 17));

        status = new JLabel("\nStatus: " + this.animal.getStatus());
        status.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        species = new JLabel("\nSpecies:" + this.animal.getSpecies());
        species.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        population = new JLabel("\nPopulation: " + this.animal.getPopulation());
        population.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        habitat = new JLabel("\nHabitat: " + this.animal.getHabitat());
        habitat.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        donations = new JLabel("\nCurrent Donations: " + this.animal.getDonation());
        donations.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
    }

    private void initializeButtons() {
        faves = new JButton("Add To Favorites");
        faves.addActionListener(this);
        faves.setVisible(true);

        donate = new JButton("Donate");
        donate.addActionListener(this);
        donate.setVisible(true);

        remove = new JButton("Remove From Favorites");
        remove.addActionListener(this);
        remove.setHorizontalAlignment(SwingConstants.CENTER);
        remove.setVisible(true);


        this.add(faves);
        this.add(donate);
        this.add(remove);
    }

    private String setDonatingPane() {
        String amount = JOptionPane.showInputDialog(this, "Enter donation amount");
        return amount;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == faves) {
            account.addToFavorites(animal);
        } else if (e.getSource() == donate) {
            String amount = setDonatingPane();
            account.donate(Integer.parseInt(amount), animal);
            account.addToDonatedTo(animal);
            donations.setText("\nCurrent Donations: " + animal.getDonation());
            autoSave();
        } else if (e.getSource() == remove) {
            account.removeFromFavorites(animal);
        }
    }

    //EFFECTS: save the user's favorites list to file.
    private void autoSave() {
        try {
            jsonWriterAuto.openFile();
            jsonWriterAuto.autoWrite(zoo);
            jsonWriterAuto.close();
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + AUTO_FILE);
        }
    }
}
