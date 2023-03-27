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
import java.util.Map;

//represents the entire GUI of the program.
public class WildlifeRescueUI extends JFrame {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 900;


    private Account account;
    private Zoo zoo;
    private JsonReaderAuto jsonReaderAuto;

    private JPanel sideBar;
    private JPanel masterPanel;
    private CardLayout cardLayout;
    private JScrollPane scrollPane;

    private JSplitPane dummyPane;
    private SpeciesPanel grid;
    private FavoritesPanel favoritesPanel;
    private DonatedToPanel donatedToPanel;
    private CriticalPanel criticalPanel;
    private EndangeredPanel endangeredPanel;
    private VulnerablePanel vulnerablePanel;


    private static final String AUTO_FILE = "./data/auto.json";

    //EFFECTS: constructs a frame with sidebar and panels.
    public WildlifeRescueUI(Account account) {
        super("Wildlife Rescue");

        initializeFrame(account);
        initializePanels();

        masterPanel = new JPanel();
        cardLayout = new CardLayout();
        masterPanel.setLayout(cardLayout);

        JLabel welcomeString = setWelcomeLabel();

        grid = setGridPanel();

        initializeSideBar(welcomeString);

        scrollPane = new JScrollPane(grid);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        addPanelsToMasterPanel();

        dummyPane =  new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sideBar, masterPanel);
        dummyPane.setDividerLocation(350);
        cardLayout.first(masterPanel);
        this.add(dummyPane);
    }

    //EFFECTS: initializes the frame
    private void initializeFrame(Account account) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.account = account;
        zoo = new Zoo();
        jsonReaderAuto = new JsonReaderAuto(AUTO_FILE);
        autoLoad();

        this.setSize(WIDTH, HEIGHT);
        this.setVisible(true);
        this.setBackground(new Color(126, 166, 96));
        this.setLocationRelativeTo(null);
    }


    //EFFECTS: sets the welcome label and returns it.
    private JLabel setWelcomeLabel() {
        JLabel welcomeString = new JLabel();
        welcomeString.setText("Welcome " + this.account.getUsername() + " to Wildlife Rescue!");
        welcomeString.setVerticalAlignment(SwingConstants.TOP);
        welcomeString.setHorizontalAlignment(JLabel.CENTER);
        welcomeString.setForeground(null);
        welcomeString.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        welcomeString.setForeground(Color.WHITE);
        return welcomeString;
    }

    //EFFECTS: sets the sidebar of the frame
    private JPanel initializeSideBar(JLabel welcomeString) {
        sideBar = new SideBarPanel(this, account, zoo, welcomeString, masterPanel, cardLayout, grid);
        return sideBar;
    }

    //EFFECTS: sets the grid JPanel.
    private SpeciesPanel setGridPanel() {
        SpeciesPanel grid =  new SpeciesPanel(this, account, zoo, masterPanel, cardLayout);
        return grid;
    }

    //MODIFIES: this
    //EFFECTS: load the user's favorites list from file.
    private void autoLoad() {
        try {
            zoo = jsonReaderAuto.read();
        } catch (IOException e) {
//            JOptionPane.showMessageDialog(null, "File Not Found.", null,
//                    JOptionPane.ERROR_MESSAGE);
        }
    }

    //EFFECTS: initializes the panels
    private void initializePanels() {
        favoritesPanel = new FavoritesPanel(grid);
        donatedToPanel = new DonatedToPanel();
        criticalPanel = new CriticalPanel();
        endangeredPanel = new EndangeredPanel();
        vulnerablePanel = new VulnerablePanel();
    }

    //EFFECTS: adds the sub panels to the master panel which has a CardLayout.
    private void addPanelsToMasterPanel() {
        masterPanel.add(scrollPane, "1");
        masterPanel.add(favoritesPanel, "2");
        masterPanel.add(donatedToPanel,"3");
        masterPanel.add(criticalPanel, "4");
        masterPanel.add(endangeredPanel, "5");
        masterPanel.add(vulnerablePanel, "6");
    }

    //getters:

    public JSplitPane getDummyPane() {
        return dummyPane;
    }

    public JScrollPane getSpeciesScrollPane() {
        return scrollPane;
    }

    public JPanel getSideBar() {
        return sideBar;
    }

    public JPanel getMasterPanel() {
        return masterPanel;
    }
}
