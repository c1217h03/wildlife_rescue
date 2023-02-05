package model;

import java.util.ArrayList;

//a class that represents an account containing a username, card, favourite list, animals donated to list.
public class Account {

    private String username;
    private String card;
    private ArrayList<Animal> favorites;
    private ArrayList<Animal> donatedto;

    public static int MAX_DONATION = 5000;
    public static int MIN_DONATION = 1;

    //EFFECTS: create a new Account object.
    //         sets the username with the given name.
    //         sets the user's card with the given card.
    //         initializes favorites and dontatedto lists to new ArrayLists.
    public  Account(String username, String card){
        this.username = username;
        this.card = card;
        this.favorites = new ArrayList<Animal>();
        this.donatedto = new ArrayList<Animal>();

    }

    //REQUIRES: 0 < amount <= 5000
    //MODIFIES: animal
    //EFFECTS: donate the given amount to the given animal
    public void donate(int amount, Animal animal) {
        //stub
    }

    //REQUIRES: card should be a string with 16 digits and a space character separating every 4 digits.
    //EFFECTS: returns true if the given username and card matches the user's fields
    public boolean validUser(String username, String card){
        return false;
    }

    //REQUIRES: the animal is not already in the list.
    //MODIFIES: this
    //EFFECTS: adds the given animal to the account's donated to lists
    public void addToDonatedTo(Animal animal) {
        //stub
    }

    //MODIFIES: this
    //EFFECTS: adds the given animal to the account's favourites list
    public void addToFavorites(Animal animal) {
        //stub
    }

    //REQUIRES: the account's favorite list is not empty
    //MODIFIES: this
    //EFFECTS: removes the given animal from the account's favorites list.
    public void removeFromFavorites(Animal animal){
        //stub
    }

    //REQUIRES: card should be a string with 16 digits and a space character separating every 4 digits.
    //EFFECTS: returns true if the given card begins with 4.
    public boolean hasValidCard(String card){
        return false;
    }

    public String getUsername() {
        return null;
    }

    public String getCard() {
        return null;
    }

    public ArrayList<Animal> getFavorites() {
        return null;
    }

    public ArrayList<Animal> getDonatedTo(){
        return null;
    }

}



