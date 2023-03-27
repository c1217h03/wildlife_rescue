package ui;

import javax.swing.*;
import java.awt.*;

//class that represents a panel that shows all the vulnerable species.
public class VulnerablePanel extends JPanel {

    //EFFECTS: constructs a vulnerable panel.
    public VulnerablePanel() {
        super();
        this.setOpaque(true);
        this.setSize(WildlifeRescueUI.WIDTH, WildlifeRescueUI.HEIGHT);
        this.setBackground(Color.WHITE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(51, 94, 17));
        this.setVisible(true);
        this.setBounds(500, 900, 750, 900);
        this.setLayout(new GridLayout(getComponentCount(), 1));
    }
}
