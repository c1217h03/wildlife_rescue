package ui;

import model.*;

import javax.swing.text.InternationalFormatter;

//represents the class that starts the program.
public class Main {

    private static InfoManager info;

    //EFFECTS: starts the program.
    public static void main(String[] args) {
        info = new InfoManager();
        info.handleUserInput();
    }

}
