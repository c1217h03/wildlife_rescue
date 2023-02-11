package ui;

import model.*;

import javax.swing.text.InternationalFormatter;


public class Main {

    private static Bear giantPanda;
    private static Bear polarBear;
    private static Elephant afElephant;
    private static Elephant sElephant;
    private static Rhino blackRhino;
    private static Rhino sumatranRhino;
    private static BigCat snowLeopard;
    private static BigCat tiger;
    private static MarineAnimal whaleShark;
    private static MarineAnimal narWhale;
    private static MarineAnimal belugaWhale;
    private static InfoManager info;


    public static void main(String[] args) {
//        blackRhino = new Rhino("Black Rhino", "CE", "Savannah", 5500);
//        sumatranRhino = new Rhino("Sumatran Rhino", "CE", "Tropical Forests", 80);
//        narWhale = new MarineAnimal("North Atlantic Right Whale", "CE", "Ocean", 366);
//        belugaWhale = new MarineAnimal("Beluga Whale", "NT", "Ocean", 150000);
//        polarBear = new Bear("Polar Bear", "V", "Arctic Ocean", 265000);
//        giantPanda = new Bear("Giant Panda", "V", "Chinese Forests", 1864);
//        snowLeopard = new BigCat("Snow Leopard", "V", "High Mountains", 5000);
//        tiger = new BigCat("Tiger", "E", "Rainforests", 4500);
//        afElephant = new Elephant("African Forest Elephant", "CE", "African Forests",
//                415000);
//        sElephant = new Elephant("Sumatran Elephant", "CE", "Tropical Forests", 2400);
//        whaleShark = new MarineAnimal("Whale Shark", "E", "Ocean", 200000);

        info = new InfoManager();
        info.handleUserInput();
    }

}
