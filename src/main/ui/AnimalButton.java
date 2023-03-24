package ui;

import model.Animal;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;

public class AnimalButton extends JButton {

    public AnimalButton(String image, String animal) {
        super(animal);
        ImageIcon icon = new ImageIcon(image);
        this.setText(animal);
        this.setIcon(icon);
        this.setVisible(true);
        this.setSize(100, 100);
        this.setOpaque(false);
        this.setSize(800, 480);
    }

}
