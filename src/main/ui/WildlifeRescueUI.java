package ui;

import model.*;
import persistence.JsonReader;
import persistence.JsonReaderAuto;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class WildlifeRescueUI extends JFrame implements ActionListener {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 900;


    private Account account;
    private Zoo zoo;
    private List<Animal> animalList;

    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private JsonWriter jsonWriterAuto;
    private JsonReaderAuto jsonReaderAuto;

    private JPanel sideBar;

    private JSplitPane dummyPane;
    private SpeciesPanel grid;

    private JButton save;
    private JButton load;

    private static final String FILENAME = "./data/saved.json";
    private static final String AUTO_FILE = "./data/auto.json";

    public WildlifeRescueUI(Account account) {
        super("Wildlife Rescue");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.account = account;
        zoo = new Zoo();
        jsonReader = new JsonReader(FILENAME);
        jsonWriter = new JsonWriter(FILENAME);
        jsonReaderAuto = new JsonReaderAuto(AUTO_FILE);
        jsonWriterAuto = new JsonWriter(AUTO_FILE);
        autoLoad();



        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setBackground(new Color(126, 166, 96));

        animalList = zoo.getAnimalList();

        JLabel welcomeString = setWelcomeLabel();

        grid = setGridPanel();

        JScrollPane scrollPane = new JScrollPane(grid);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        sideBar = new JPanel();
        sideBar.setSize(350, HEIGHT);
        sideBar.setAlignmentX(Component.LEFT_ALIGNMENT);

        sideBar.add(welcomeString);
        JPanel dummy = new JPanel(new GridLayout(1, 2, 10, 0));
        initializeOtherButtons(dummy);
        sideBar.add(dummy);

        dummyPane =  new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sideBar, scrollPane);
        dummyPane.setDividerLocation(350);
        this.add(dummyPane);

    }

    //EFFECTS: initializes other buttons aside from animal buttons.
    private void initializeOtherButtons(JPanel panel) {
        save = new JButton("Save");
        save.addActionListener(this);
        load = new JButton("Load");
        load.addActionListener(this);

        panel.add(save);
        panel.add(load);
    }

    //EFFECTS: sets the welcome label and returns it.
    private JLabel setWelcomeLabel() {
        JLabel welcomeString = new JLabel();
        welcomeString.setText("Welcome " + this.account.getUsername() + " to Wildlife Rescue!");
        welcomeString.setVerticalAlignment(SwingConstants.TOP);
        welcomeString.setHorizontalAlignment(JLabel.CENTER);
        welcomeString.setForeground(null);
        welcomeString.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 15));
        welcomeString.setForeground(new Color(51, 94, 17));
        return welcomeString;
    }

    //EFFECTS: sets the grid JPanel.
    private SpeciesPanel setGridPanel() {
        SpeciesPanel grid =  new SpeciesPanel(this, account, zoo);
        return grid;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == save) {
            this.saveFile();
        } else if (source == load) {
            this.loadFile();
        }
        else {
            handleAnimalButtons(new WildlifeRescueUI(account), e);
        }
    }

    public void handleAnimalButtons(WildlifeRescueUI parent, ActionEvent e) {
    grid.handleActions(new WildlifeRescueUI(account), e);
    }

    private void saveFile() {
        try {
            jsonWriter.openFile();
            jsonWriter.writeToFile(account);
            jsonWriter.close();
            //System.out.println("Saved " + account.getUsername() + " to " + FILENAME);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "File Not Found.", null,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadFile() {
        try {
            account = jsonReader.read();
            System.out.println("Loaded " + account.getUsername() + "'s account from " + FILENAME);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File Not Found.", null,
                    JOptionPane.ERROR_MESSAGE);
        } catch (NotValidCardException e) {
            JOptionPane.showMessageDialog(null, "Invalid card.", null,
                    JOptionPane.ERROR_MESSAGE);

        }
    }


    //MODIFIES: this
    //EFFECTS: load the user's favorites list from file.
    private void autoLoad() {
        try {
            zoo = jsonReaderAuto.read();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "File Not Found.", null,
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public JSplitPane getDummyPane() {
        return dummyPane;
    }

    public JPanel getSideBar() {
        return sideBar;
    }
}
