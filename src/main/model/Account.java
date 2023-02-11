package model;

import java.util.ArrayList;

//a class that represents an account containing a username, card, favourite list, animals donated to list.
public class Account {

    private String username;
    private String card;
    private ArrayList<Animal> favorites;
    private ArrayList<Animal> donatedto;

    private static int MAX_DONATION = 5000;
    private static int MIN_DONATION = 1;

    //EFFECTS: create a new Account object.
    //         sets the username with the given name.
    //         sets the user's card with the given card.
    //         initializes favorites and dontatedto lists to new ArrayLists.
    public Account(String username, String card) throws NotValidCardException {
        if (hasValidCard(card)) {
            this.username = username;
            this.card = card;
            this.favorites = new ArrayList<Animal>();
            this.donatedto = new ArrayList<Animal>();
        } else {
            throw new NotValidCardException();
        }
    }

    //REQUIRES: 0 < amount <= 5000
    //MODIFIES: animal
    //EFFECTS: donate the given amount to the given animal
    public void donate(int amount, Animal animal) {
        animal.addDonation(amount);
        this.addToDonatedTo(animal);
    }
    

    //REQUIRES: the animal is not already in the list.
    //MODIFIES: this
    //EFFECTS: adds the given animal to the account's donated to lists
    public void addToDonatedTo(Animal animal) {
        if (!((this.donatedto).contains(animal))) {
            donatedto.add(animal);
        }
    }

    //MODIFIES: this
    //EFFECTS: adds the given animal to the account's favourites list
    public void addToFavorites(Animal animal) {
        (this.favorites).add(animal);
    }

    //REQUIRES: the account's favorite list is not empty
    //MODIFIES: this
    //EFFECTS: removes the given animal from the account's favorites list.
    public void removeFromFavorites(Animal animal) {
        favorites.remove(animal);
    }

    //REQUIRES: card should be a string with 16 digits and a space character separating every 4 digits.
    //EFFECTS: returns true if the given card begins with 4.
    public boolean hasValidCard(String card) {
        if ('4' == (card.charAt(0))) {
            return true;
        }
        return false;
    }



    public String getUsername() {
        return this.username;
    }

    public String getCard() {
        return this.card;
    }

    public ArrayList<Animal> getFavorites() {
        return this.favorites;
    }

    public ArrayList<Animal> getDonatedTo() {
        return this.donatedto;
    }

    public static int getMaxDonation() {
        return MAX_DONATION;
    }

    public static int getMinDonation() {
        return MIN_DONATION;
    }
}



