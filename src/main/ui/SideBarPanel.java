package ui;

import model.Account;
import model.Animal;
import model.NotValidCardException;
import model.Zoo;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

//class that represents the sidebar.
public class SideBarPanel extends JPanel implements ActionListener {
    private Account account;
    private Zoo zoo;
    private List<Animal> animalList;
    private AnimalButtons animalButtons;

    private JButton save;
    private JButton load;
    private JButton favorites;
    private JButton species;
    private JButton donatedTo;
    private JButton critical;
    private JButton endangered;
    private JButton vulnerable;

    private JPanel master;
    private CardLayout cards;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private SpeciesPanel grid;

    private static final String FILENAME = "./data/saved.json";

    //EFFECTS: constructs a sidebar panel.
    public SideBarPanel(Account account, Zoo zoo, JLabel welcomeString, JPanel master,
                        CardLayout cl, SpeciesPanel grid) {
        super();
        this.grid = grid;
        this.account = account;
        this.zoo = zoo;
        this.animalList = zoo.getAnimalList();
        this.animalButtons = new AnimalButtons();
        this.jsonWriter = new JsonWriter(FILENAME);
        this.jsonReader = new JsonReader(FILENAME);
        this.master = master;
        this.cards = cl;

        this.setSize(350, HEIGHT);
        this.setBackground(new Color(124, 155, 98));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(welcomeString);
        initializeOtherButtons(this);
    }

    //EFFECTS: initializes the buttons on the sidebar.
    public void initializeOtherButtons(JPanel panel) {
        species = new JButton("Species");
        species.addActionListener(this);
        species.setHorizontalAlignment(SwingConstants.CENTER);

        save = new JButton("Save");
        save.addActionListener(this);
        save.setHorizontalAlignment(SwingConstants.CENTER);

        load = new JButton("Load");
        load.addActionListener(this);
        load.setHorizontalAlignment(SwingConstants.CENTER);

        initializeListButtons();

        addButtons(panel);
    }

    //EFFECTS: initializes the buttons that correlate to showing a list of animals.
    private void initializeListButtons() {
        favorites = new JButton("Favorites");
        favorites.addActionListener(this);
        favorites.setHorizontalAlignment(SwingConstants.CENTER);

        donatedTo = new JButton("Animals Donated To");
        donatedTo.addActionListener(this);
        donatedTo.setHorizontalAlignment(SwingConstants.CENTER);

        critical = new JButton("Critically Endangered");
        critical.addActionListener(this);
        critical.setHorizontalAlignment(SwingConstants.CENTER);

        endangered = new JButton("Endangered Animals");
        endangered.addActionListener(this);
        endangered.setHorizontalAlignment(SwingConstants.CENTER);

        vulnerable = new JButton("Vulnerable Animals");
        vulnerable.addActionListener(this);
        vulnerable.setHorizontalAlignment(SwingConstants.CENTER);
    }

    //EFFECTS: adds the buttons to the sidebar panel.
    private void addButtons(JPanel panel) {
        panel.add(species);
        panel.add(save);
        panel.add(load);
        panel.add(favorites);
        panel.add(donatedTo);
        panel.add(critical);
        panel.add(endangered);
        panel.add(vulnerable);
    }

    //EFFECTS: manages the user actions.
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == save) {
            this.saveFile();
        } else if (source == load) {
            this.loadFile();
        } else if (source == favorites) {
            handleFavorites();
        } else if (source == species) {
            handleSpecies();
        } else if (source == donatedTo) {
            handleDonated();
        } else if (source == critical) {
            handleStatus("CE");
        } else if (source == endangered) {
            handleEndangered();
        } else if (source == vulnerable) {
            handleStatus("V");
        } else {
            handleAnimalButtons(e);
        }
    }

    //EFFECTS: jumps to the species panel
    private void handleSpecies() {
        cards.first(master);
    }

    //EFFECTS: jumps to the favorite panel
    private void handleFavorites() {
        AnimalListPanel panel = new AnimalListPanel();

        for (Animal a : this.account.getFavorites()) {
            JButton animalButton = animalButtons.getAnimalButton(a.getName());
            animalButton.addActionListener(this);
            panel.add(animalButton);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        master.add(scrollPane, "2");
        cards.show(master, "2");
    }

    //EFFECTS: jumps to the donated to panel.
    private void handleDonated() {
        AnimalListPanel panel = new AnimalListPanel();
        for (Animal animal : this.account.getDonatedTo()) {
            JButton animalButton = animalButtons.getAnimalButton(animal.getName());
            animalButton.addActionListener(this);
            panel.add(animalButton);
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        master.add(scrollPane, "3");
        cards.show(master, "3");
    }

    //EFFECTS: jumps to the critical panel
    private void handleStatus(String status) {
        AnimalListPanel panel = new AnimalListPanel();
        for (Animal animal : animalList) {
            if (animal.getStatus() == status) {
                JButton animalButton = animalButtons.getAnimalButton(animal.getName());
                animalButton.addActionListener(this);
                panel.add(animalButton);
            }
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        master.add(scrollPane, "4");
        cards.show(master, "4");
    }

    //EFFECTS jumps to the endangered panel.
    private void handleEndangered() {
        AnimalListPanel panel = new AnimalListPanel();
        for (Animal animal : animalList) {
            if (animal.getStatus() == "CE" || animal.getStatus() == "E") {
                JButton animalButton = animalButtons.getAnimalButton(animal.getName());
                animalButton.addActionListener(this);
                panel.add(animalButton);
            }
        }
        JScrollPane scrollPane = new JScrollPane(panel);
        master.add(scrollPane, "4");
        cards.show(master, "4");
    }


    //EFFECTS: handles action if the animal button was pressed.
    public void handleAnimalButtons(ActionEvent e) {
        grid.handleActions(e);
    }

    //EFFECTS: saves the user's favorites and donated to list.
    private void saveFile() {
        try {
            jsonWriter.openFile();
            jsonWriter.writeToFile(account);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Not Found.", null,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //EFFECTS: loads the user's favorites and donated to list from file.
    private void loadFile() {
        try {
            this.account = jsonReader.read();
            grid.setAccount(this.account);
            System.out.println("Loaded " + account.getUsername() + "'s account from " + FILENAME);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File Not Found.", null,
                    JOptionPane.ERROR_MESSAGE);
        } catch (NotValidCardException e) {
            JOptionPane.showMessageDialog(null, "Invalid card.", null,
                    JOptionPane.ERROR_MESSAGE);

        }
    }
}
