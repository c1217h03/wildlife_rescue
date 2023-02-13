package ui;

import model.*;

import javax.swing.text.InternationalFormatter;


public class Main {

    private static InfoManager info;

    public static void main(String[] args) {
        info = new InfoManager();
        info.handleUserInput();
    }

}
