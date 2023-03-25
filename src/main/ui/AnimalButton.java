package ui;

import model.Animal;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class AnimalButton extends JButton {
    String name;
    String imageFile;

    public AnimalButton(String image, String animal) {
        super(animal);
        this.name = animal;
        this.imageFile = image;
        ImageIcon icon = new ImageIcon(image);
        this.setText(animal);
        this.setIcon(icon);
        this.setVisible(true);
        this.setSize(100, 100);
        this.setOpaque(false);
        this.setSize(800, 480);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AnimalButton animalButton = (AnimalButton) obj;
        return imageFile == animalButton.imageFile;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageFile);
    }
}
