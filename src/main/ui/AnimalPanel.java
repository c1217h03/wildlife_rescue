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

    private JButton faves;
    private JButton donate;
    private JButton remove;

    private Account account;
    private Animal a;
    private Zoo zoo;
    private JsonWriter jsonWriterAuto;

    private static final String AUTO_FILE = "./data/auto.json";

    public AnimalPanel(String animal, Zoo zoo, Account account) {
        super();
        this.setSize(WildlifeRescueUI.WIDTH, WildlifeRescueUI.HEIGHT);
        this.setBackground(Color.WHITE);
        this.setLayout(new GridLayout(8, 1));

        this.account = account;
        this.zoo = zoo;
        this.jsonWriterAuto = new JsonWriter(AUTO_FILE);

        a = zoo.getSpecificAnimal(animal);

        name = new JLabel("\n" + a.getName() + "\n");
        name.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 50));
        name.setForeground(new Color(54, 94, 17));

        status = new JLabel("\nStatus: " + a.getStatus());
        status.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        species = new JLabel("\nSpecies:" + a.getSpecies());
        species.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        population = new JLabel("\nPopulation: " + a.getPopulation());
        population.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        habitat = new JLabel("\nHabitat: " + a.getHabitat());
        habitat.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        donations = new JLabel("\nCurrent Donations: " + a.getDonation());
        donations.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        this.add(name);
        this.add(status);
        this.add(species);
        this.add(population);
        this.add(habitat);
        this.add(donations);
        this.setVisible(true);

        initializeButtons();

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
            account.addToFavorites(a);
        } else if (e.getSource() == donate) {
            String amount = setDonatingPane();
            account.donate(Integer.parseInt(amount), a);
            donations.setText("\nCurrent Donations: " + a.getDonation());
            autoSave();
        } else if (e.getSource() == remove) {
            account.removeFromFavorites(a);
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
