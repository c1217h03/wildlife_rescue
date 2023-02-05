package model;

import model.bears.GiantPanda;
import model.bears.PolarBear;
import model.bigcats.SnowLeopard;
import model.bigcats.Tiger;
import model.elephants.AfricanForestElephant;
import model.elephants.SumatranElephant;
import model.marineanimals.BelugaWhale;
import model.marineanimals.NorthAtlanticRWhale;
import model.marineanimals.WhaleShark;
import model.rhinos.BlackRhino;
import model.rhinos.SumatranRhino;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static model.Account.MAX_DONATION;
import static model.Account.MIN_DONATION;
import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private Account acc1;
    private Account acc2;
    private BlackRhino blackRhino;
    private SumatranRhino sumatranRhino;
    private PolarBear polarBear;
    private GiantPanda giantPanda;
    private SnowLeopard snowLeopard;
    private Tiger tiger;
    private AfricanForestElephant afElephant;
    private SumatranElephant sElephant;
    private BelugaWhale belugaWhale;
    private NorthAtlanticRWhale narWhale;
    private WhaleShark whaleShark;
    private Animal animal;


    @BeforeEach
    public void setup() {
        acc1 = new Account("user1", "4536 0022 3144 1702");
        acc2 = new Account("Emma", "1111 1111 1111 1111");
        blackRhino = new BlackRhino();
        sumatranRhino = new SumatranRhino();
        narWhale = new NorthAtlanticRWhale();
        belugaWhale = new BelugaWhale();
        polarBear = new PolarBear();
        giantPanda = new GiantPanda();
        snowLeopard = new SnowLeopard();
        tiger = new Tiger();
        afElephant = new AfricanForestElephant();
        sElephant = new SumatranElephant();
        whaleShark = new WhaleShark();
    }

    @Test
    public void testConstructor() {
        assertEquals("user1", acc1.getUsername());
        assertEquals("4536 0022 3144 1702", acc1.getCard());
        assertEquals(new ArrayList<Animal>(), acc1.getFavorites());
        assertEquals(new ArrayList<Animal>(), acc1.getDonatedTo());

        assertEquals("Emma", acc2.getUsername());
        assertEquals("1111 1111 1111 1111", acc2.getCard());
    }

    @Test
    public void testDonatePolarBears() {
        acc1.donate(MIN_DONATION, polarBear);
        assertEquals(MIN_DONATION, polarBear.getDonation());
        acc1.donate(2000, polarBear);
        assertEquals(2000 + MIN_DONATION, polarBear.getDonation());
        acc1.donate(MAX_DONATION, polarBear);
        assertEquals(2000 + MIN_DONATION + MAX_DONATION, polarBear.getDonation());
        acc1.donate(MAX_DONATION - 1, polarBear);
        assertEquals(2000 + MIN_DONATION + MAX_DONATION + MAX_DONATION - 1, polarBear.getDonation());
    }

    @Test
    public void testDonateGiantPanda() {
        acc1.donate(MIN_DONATION, giantPanda);
        assertEquals(MIN_DONATION, giantPanda.getDonation());
        acc1.donate(1500, giantPanda);
        assertEquals(1500 + MIN_DONATION, giantPanda.getDonation());
        acc1.donate(MAX_DONATION, giantPanda);
        assertEquals(1500 + MIN_DONATION + MAX_DONATION, giantPanda.getDonation());
    }

    @Test
    public void testDonateAFElephant() {
        acc1.donate(MIN_DONATION, afElephant);
        assertEquals(MIN_DONATION, afElephant.getDonation());
        acc1.donate(10, afElephant);
        assertEquals(10 + MIN_DONATION, afElephant.getDonation());
        acc1.donate(MAX_DONATION, afElephant);
        assertEquals(10 + MIN_DONATION + MAX_DONATION, afElephant.getDonation());
    }

    @Test
    public void testDonateSElephant() {
        acc1.donate(MIN_DONATION, sElephant);
        assertEquals(MIN_DONATION, sElephant.getDonation());
        acc1.donate(200, sElephant);
        assertEquals(200 + MIN_DONATION, sElephant.getDonation());
        acc1.donate(MAX_DONATION, sElephant);
        assertEquals(200 + MIN_DONATION + MAX_DONATION, sElephant.getDonation());
    }

    @Test
    public void testDonateNARWhale() {
        acc1.donate(MIN_DONATION, narWhale);
        assertEquals(MIN_DONATION, narWhale.getDonation());
        acc1.donate(2000, narWhale);
        assertEquals(2000 + MIN_DONATION, narWhale.getDonation());
        acc1.donate(MAX_DONATION, narWhale);
        assertEquals(2000 + MIN_DONATION + MAX_DONATION, narWhale.getDonation());

    }

    @Test
    public void testDonateWhaleShark() {
        acc1.donate(MIN_DONATION, whaleShark);
        assertEquals(MIN_DONATION, whaleShark.getDonation());
        acc1.donate(1500, whaleShark);
        assertEquals(1500 + MIN_DONATION, whaleShark.getDonation());
        acc1.donate(MAX_DONATION, whaleShark);
        assertEquals(1500 + MIN_DONATION + MAX_DONATION, whaleShark.getDonation());

    }

    @Test
    public void testDonateBelugaWhale() {
        acc1.donate(MIN_DONATION, belugaWhale);
        assertEquals(MIN_DONATION, belugaWhale.getDonation());
        acc1.donate(10, belugaWhale);
        assertEquals(10 + MIN_DONATION, belugaWhale.getDonation());
        acc1.donate(MAX_DONATION, belugaWhale);
        assertEquals(10 + MIN_DONATION + MAX_DONATION, belugaWhale.getDonation());

    }

    @Test
    public void testDonateBlackRhinos() {
        acc1.donate(MIN_DONATION, blackRhino);
        assertEquals(MIN_DONATION, blackRhino.getDonation());
        acc1.donate(200, blackRhino);
        assertEquals(200 + MIN_DONATION, blackRhino.getDonation());
        acc1.donate(MAX_DONATION, blackRhino);
        assertEquals(200 + MIN_DONATION + MAX_DONATION, blackRhino.getDonation());

    }

    @Test
    public void testDonateSRhinos() {
        acc1.donate(MIN_DONATION, sumatranRhino);
        assertEquals(MIN_DONATION, sumatranRhino.getDonation());
        acc1.donate(2000, sumatranRhino);
        assertEquals(2000 + MIN_DONATION, sumatranRhino.getDonation());
        acc1.donate(MAX_DONATION, sumatranRhino);
        assertEquals(2000 + MIN_DONATION + MAX_DONATION, sumatranRhino.getDonation());

    }

    @Test
    public void testDonateSnowLeopard() {
        acc1.donate(MIN_DONATION, snowLeopard);
        assertEquals(MIN_DONATION, snowLeopard.getDonation());
        acc1.donate(1500, snowLeopard);
        assertEquals(1500 + MIN_DONATION, snowLeopard.getDonation());
        acc1.donate(MAX_DONATION, snowLeopard);
        assertEquals(1500 + MIN_DONATION + MAX_DONATION, snowLeopard.getDonation());

    }

    @Test
    public void testDonateTiger() {
        acc1.donate(MIN_DONATION, tiger);
        assertEquals(MIN_DONATION, tiger.getDonation());
        acc1.donate(10, tiger);
        assertEquals(10 + MIN_DONATION, tiger.getDonation());
        acc1.donate(MAX_DONATION, tiger);
        assertEquals(10 + MIN_DONATION + MAX_DONATION, tiger.getDonation());

    }


    @Test
    public void testValidUser(){
        assertTrue(acc1.validUser("user1", "4536 0022 3144 1702"));
        assertTrue(acc2.validUser("Emma", "1111 1111 1111 1111"));
    }

    @Test
    public void testNotValidUser(){
        assertFalse(acc1.validUser("user2", "3333 0000 1111 3333"));
        assertFalse(acc2.validUser("user2", "1212 1212 1212 1212"));
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
    public void testNotValidCard(){
        assertFalse(acc2.hasValidCard(acc2.getCard()));
    }

}