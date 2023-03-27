package ui;

import model.Animal;
import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

//class that represents an animal button.
public class AnimalButton extends JButton {
    String name;
    String imageFile;

    //EFFECTS: constructs an animal button with the given image.
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

    //EFFECTS: overrides the equals method for the animal button.
    //         returns true if the given object is equal to the object the method is called on.
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

    //EFFECTS: overrides the hashcode method, returns the hashcode.
    @Override
    public int hashCode() {
        return Objects.hash(imageFile);
    }
}
