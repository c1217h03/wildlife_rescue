package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

//a class that represents an account containing a username, card, favourite list, animals donated to list.
public class Account implements Writable {

    private String username;
    private String card;
    private List<Animal> favorites;
    private List<Animal> donatedto;

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
            this.favorites = new ArrayList<>();
            this.donatedto = new ArrayList<>();
            EventLog.getInstance().logEvent(new Event("Created an account with name: " + this.username));
        } else {
            throw new NotValidCardException();
        }
    }

    //REQUIRES: 0 < amount <= 5000
    //MODIFIES: animal
    //EFFECTS: donate the given amount to the given animal
    public void donate(int amount, Animal animal) {
        animal.addDonation(amount);
        EventLog.getInstance().logEvent(new Event("Donated " + amount + " to " + animal.getName() + "s."));
        this.addToDonatedTo(animal);
        EventLog.getInstance().logEvent(new Event("Added " + animal.getName()
                + " to account's donated to list."));
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
        EventLog.getInstance().logEvent(new Event("Added " + animal.getName() + " to favorites list."));
    }


    //REQUIRES: the account's favorite list is not empty
    //MODIFIES: this
    //EFFECTS: removes the given animal from the account's favorites list.
    public void removeFromFavorites(Animal animal) {
        favorites.remove(animal);
        EventLog.getInstance().logEvent(new Event("Removed " + animal.getName() + " from favorites list."));
    }

    //REQUIRES: card should be a string with 16 digits and a space character separating every 4 digits.
    //EFFECTS: returns true if the given card begins with 4.
    public boolean hasValidCard(String card) {
        if ('4' == (card.charAt(0))) {
            return true;
        }
        return false;
    }

    //EFFECTS: returns an account into a json array.
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("card", card);
        json.put("favorites", favesToJson());
        json.put("donatedto", donatedToJson());
        return json;
    }

    //EFFECTS: returns a list of animals into a json array.
    private JSONArray favesToJson() {
        JSONArray jsonFaves = new JSONArray();

        for (Animal a : favorites) {
            jsonFaves.put(a.toJson());
        }

        return jsonFaves;
    }

    //EFFECTS: returns a list of animals into a json array.
    private JSONArray donatedToJson() {
        JSONArray jsonDonatedTo = new JSONArray();

        for (Animal a : donatedto) {
            jsonDonatedTo.put(a.toJson());
        }

        return jsonDonatedTo;
    }



    //getters
    public String getUsername() {
        return this.username;
    }

    public String getCard() {
        return this.card;
    }

    public List<Animal> getFavorites() {
        return this.favorites;
    }

    public List<Animal> getDonatedTo() {
        return this.donatedto;
    }

    public static int getMaxDonation() {
        return MAX_DONATION;
    }

    public static int getMinDonation() {
        return MIN_DONATION;
    }


}



