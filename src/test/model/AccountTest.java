package model;


import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static model.Account.*;
import static org.junit.jupiter.api.Assertions.*;

//represents a class for account testing

class AccountTest {
    private Account acc1;
    private Rhino blackRhino;
    private Rhino sumatranRhino;
    private Bear polarBear;
    private Bear giantPanda;
    private BigCat snowLeopard;
    private BigCat tiger;
    private Elephant afElephant;
    private Elephant sElephant;
    private MarineAnimal belugaWhale;
    private MarineAnimal narWhale;
    private MarineAnimal whaleShark;
    private Animal animal;


    @BeforeEach
    public void setup() throws NotValidCardException {
        acc1 = new Account("user1", "4536 0022 3144 1702");
        blackRhino = new Rhino("Black Rhino", "CE", "Savannah", 5500);
        sumatranRhino = new Rhino("Sumatran Rhino", "CE", "Tropical Forests", 80);
        narWhale = new MarineAnimal("North Atlantic Right Whale", "CE", "Ocean", 366);
        belugaWhale = new MarineAnimal("Beluga Whale", "NT", "Ocean", 150000);
        polarBear = new Bear("Polar Bear", "V", "Arctic Ocean", 265000);
        giantPanda = new Bear("Giant Panda", "V", "Chinese Forests", 1864);
        snowLeopard = new BigCat("Snow Leopard", "V", "High Mountains", 5000);
        tiger = new BigCat("Tiger", "E", "Rainforests", 4500);
        afElephant = new Elephant("African Forest Elephant", "CE", "African Forests",
                415000);
        sElephant = new Elephant("Sumatran Elephant", "CE", "Tropical Forests", 2400);
        whaleShark = new MarineAnimal("Whale Shark", "E", "Ocean", 200000);
    }

    @Test
    public void testConstructor() {
        assertEquals("user1", acc1.getUsername());
        assertEquals("4536 0022 3144 1702", acc1.getCard());
        assertEquals(new ArrayList<Animal>(), acc1.getFavorites());
        assertEquals(new ArrayList<Animal>(), acc1.getDonatedTo());

    }


    @Test
    public void testDonatePolarBears() {
        acc1.donate(getMinDonation(), polarBear);
        assertEquals(getMinDonation(), polarBear.getDonation());
        acc1.donate(2000, polarBear);
        assertEquals(2000 + getMinDonation(), polarBear.getDonation());
        acc1.donate(getMaxDonation(), polarBear);
        assertEquals(2000 + getMinDonation() + getMaxDonation(), polarBear.getDonation());
        acc1.donate(getMaxDonation() - 1, polarBear);
        assertEquals(2000 + getMinDonation() + getMaxDonation() + getMaxDonation() - 1, polarBear.getDonation());
    }

    @Test
    public void testDonateGiantPanda() {
        acc1.donate(getMinDonation(), giantPanda);
        assertEquals(getMinDonation(), giantPanda.getDonation());
        acc1.donate(1500, giantPanda);
        assertEquals(1500 + getMinDonation(), giantPanda.getDonation());
        acc1.donate(getMaxDonation(), giantPanda);
        assertEquals(1500 + getMinDonation() + getMaxDonation(), giantPanda.getDonation());
    }

    @Test
    public void testDonateAFElephant() {
        acc1.donate(getMinDonation(), afElephant);
        assertEquals(getMinDonation(), afElephant.getDonation());
        acc1.donate(10, afElephant);
        assertEquals(10 + getMinDonation(), afElephant.getDonation());
        acc1.donate(getMaxDonation(), afElephant);
        assertEquals(10 + getMinDonation() + getMaxDonation(), afElephant.getDonation());
    }

    @Test
    public void testDonateSElephant() {
        acc1.donate(getMinDonation(), sElephant);
        assertEquals(getMinDonation(), sElephant.getDonation());
        acc1.donate(200, sElephant);
        assertEquals(200 + getMinDonation(), sElephant.getDonation());
        acc1.donate(getMaxDonation(), sElephant);
        assertEquals(200 + getMinDonation() + getMaxDonation(), sElephant.getDonation());
    }

    @Test
    public void testDonateNARWhale() {
        acc1.donate(getMinDonation(), narWhale);
        assertEquals(getMinDonation(), narWhale.getDonation());
        acc1.donate(2000, narWhale);
        assertEquals(2000 + getMinDonation(), narWhale.getDonation());
        acc1.donate(getMaxDonation(), narWhale);
        assertEquals(2000 + getMinDonation() + getMaxDonation(), narWhale.getDonation());

    }

    @Test
    public void testDonateWhaleShark() {
        acc1.donate(getMinDonation(), whaleShark);
        assertEquals(getMinDonation(), whaleShark.getDonation());
        acc1.donate(1500, whaleShark);
        assertEquals(1500 + getMinDonation(), whaleShark.getDonation());
        acc1.donate(getMaxDonation(), whaleShark);
        assertEquals(1500 + getMinDonation() + getMaxDonation(), whaleShark.getDonation());

    }

    @Test
    public void testDonateBelugaWhale() {
        acc1.donate(getMinDonation(), belugaWhale);
        assertEquals(getMinDonation(), belugaWhale.getDonation());
        acc1.donate(10, belugaWhale);
        assertEquals(10 + getMinDonation(), belugaWhale.getDonation());
        acc1.donate(getMaxDonation(), belugaWhale);
        assertEquals(10 + getMinDonation() + getMaxDonation(), belugaWhale.getDonation());

    }

    @Test
    public void testDonateBlackRhinos() {
        acc1.donate(getMinDonation(), blackRhino);
        assertEquals(getMinDonation(), blackRhino.getDonation());
        acc1.donate(200, blackRhino);
        assertEquals(200 + getMinDonation(), blackRhino.getDonation());
        acc1.donate(getMaxDonation(), blackRhino);
        assertEquals(200 + getMinDonation() + getMaxDonation(), blackRhino.getDonation());

    }

    @Test
    public void testDonateSRhinos() {
        acc1.donate(getMinDonation(), sumatranRhino);
        assertEquals(getMinDonation(), sumatranRhino.getDonation());
        acc1.donate(2000, sumatranRhino);
        assertEquals(2000 + getMinDonation(), sumatranRhino.getDonation());
        acc1.donate(getMaxDonation(), sumatranRhino);
        assertEquals(2000 + getMinDonation() + getMaxDonation(), sumatranRhino.getDonation());

    }

    @Test
    public void testDonateSnowLeopard() {
        acc1.donate(getMinDonation(), snowLeopard);
        assertEquals(getMinDonation(), snowLeopard.getDonation());
        acc1.donate(1500, snowLeopard);
        assertEquals(1500 + getMinDonation(), snowLeopard.getDonation());
        acc1.donate(getMaxDonation(), snowLeopard);
        assertEquals(1500 + getMinDonation() + getMaxDonation(), snowLeopard.getDonation());

    }

    @Test
    public void testDonateTiger() {
        acc1.donate(getMinDonation(), tiger);
        assertEquals(getMinDonation(), tiger.getDonation());
        acc1.donate(10, tiger);
        assertEquals(10 + getMinDonation(), tiger.getDonation());
        acc1.donate(getMaxDonation(), tiger);
        assertEquals(10 + getMinDonation() + getMaxDonation(), tiger.getDonation());

    }


    @Test
    public void testAddToFavoritesAnimalOnce(){
        acc1.addToFavorites(animal);
        assertEquals(animal, (acc1.getFavorites()).get(0));
    }

    public void testAddToFavoritesAnimalTwice(){
        acc1.addToFavorites(afElephant);
        acc1.addToFavorites(polarBear);
        assertEquals(afElephant, (acc1.getFavorites()).get(0));
        assertEquals(polarBear, (acc1.getFavorites()).get(1));
    }

    public void testAddToFavoritesAnimalThrice(){
        acc1.addToFavorites(giantPanda);
        acc1.addToFavorites(narWhale);
        acc1.addToDonatedTo(snowLeopard);
        assertEquals(giantPanda, (acc1.getFavorites()).get(0));
        assertEquals(narWhale, (acc1.getFavorites()).get(1));
        assertEquals(snowLeopard, (acc1.getFavorites()).get(2));
    }

    @Test
    public void testRemoveFromFavoritesOneItemInTheList(){
        acc1.addToFavorites(blackRhino);
        acc1.removeFromFavorites(blackRhino);
        assertEquals(0, (acc1.getFavorites()).size());
    }

    public void testRemoveFromFavoritesTwoItemsInTheList(){
        acc1.addToFavorites(blackRhino);
        acc1.addToFavorites(sumatranRhino);
        acc1.removeFromFavorites(blackRhino);
        assertEquals(1, (acc1.getFavorites()).size());
        assertEquals(sumatranRhino, (acc1.getFavorites()).get(0));
    }

    public void testRemoveFromFavoritesThreeItemsInTheList(){
        acc1.addToFavorites(blackRhino);
        acc1.addToFavorites(sumatranRhino);
        acc1.addToFavorites(tiger);
        acc1.removeFromFavorites(sumatranRhino);
        assertEquals(2, (acc1.getFavorites()).size());
        assertEquals(blackRhino, (acc1.getFavorites()).get(0));
        assertEquals(tiger, (acc1.getFavorites()).get(1));
    }

    @Test
    public void testAddToDonatedToOnce(){
        acc1.donate(50, belugaWhale);
        acc1.addToDonatedTo(belugaWhale);
        assertEquals(1, (acc1.getDonatedTo()).size());
        assertEquals(belugaWhale, (acc1.getDonatedTo()).get(0));
    }

    @Test
    public void testAddToDonatedToTwice(){
        acc1.donate(50, belugaWhale);
        acc1.addToDonatedTo(belugaWhale);
        acc1.donate(50, tiger);
        acc1.addToDonatedTo(tiger);
        assertEquals(2, (acc1.getDonatedTo()).size());
        assertEquals(belugaWhale, (acc1.getDonatedTo()).get(0));
        assertEquals(tiger, (acc1.getDonatedTo()).get(1));
    }

    @Test
    public void testAddToDonatedToAlreadyInList(){
        acc1.donate(50, belugaWhale);
        acc1.donate(100, belugaWhale);
        assertEquals(1, (acc1.getDonatedTo()).size());
        assertEquals(belugaWhale, (acc1.getDonatedTo()).get(0));
    }

    @Test
    public void testValidCardWith4AsFirstDigit(){
        assertTrue(acc1.hasValidCard(acc1.getCard()));
    }

    @Test
    public void testNotValidCardNotValidCardExceptionThrown()  {
        Account acc2 = null;
        try {
             acc2 = new Account("c", "5555 5555 5555 5555");
        } catch (NotValidCardException e) {

        }
        assertEquals(null, acc2);
    }

    @Test
    public void testValidCardNotThrown()  {
        Account testAcc = null;
        try {
             testAcc = new Account("c", "4444 4444 4444 4444");
        } catch(NotValidCardException e) {
            fail();
        }
        assertEquals("c", testAcc.getUsername());
        assertEquals("4444 4444 4444 4444", testAcc.getCard());
    }

    @Test
    public void testtoJson() {
        JSONObject json = acc1.toJson();
        String username = json.getString("username");
        String card = json.getString("card");
        JSONArray faves = json.getJSONArray("favorites");
        int favesSize = faves.length();
        JSONArray donatedTo = json.getJSONArray("donatedto");
        int donatedSize = donatedTo.length();
        assertEquals(username, "user1");
        assertEquals(card, "4536 0022 3144 1702");
        assertEquals(0, favesSize);
        assertEquals(0, donatedSize);
    }
}