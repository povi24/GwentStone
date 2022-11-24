package GwentStone;

import GwentStone.Hero.*;
import fileio.Input;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * Here we assign each player the deck he starts the game with, and
 * we also assign the Hero for each player
 * We prepare the start of the game, as mentioned in the homework, initiating each player's MANA, and
 * their turn
 */
public class StartingTheGame {
    /**
     * The Deck that PlayerOne chooses to play with
     */
    private ArrayList<Card> DeckOfPlayerOne;
    /**
     * The Deck that PlayerTwo chooses to play with
     */
    private ArrayList<Card> DeckOfPlayerTwo;
    /**
     * Mana for PlayerOne at the start of each game
     */
    private int ManaOfPlayerOne;
    /**
     * Mana for PlayerTwo at the start of each game
     */
    private int ManaOfPlayerTwo;
    /**
     * Hero for PlayerOne
     */
    private Hero HeroOfPLayerOne;
    /**
     * Hero for PlayerTwo
     */
    private Hero HeroOfPlayerTwo;
    /**
     * Array for the cards that PlayerOne holds in hand
     */
    private ArrayList<Card> CardsInHandForPlayerOne;

    public ArrayList<Card> getDeckOfPlayerOne() {
        return DeckOfPlayerOne;
    }

    public void setDeckOfPlayerOne(ArrayList<Card> deckOfPlayerOne) {
        DeckOfPlayerOne = deckOfPlayerOne;
    }

    public ArrayList<Card> getDeckOfPlayerTwo() {
        return DeckOfPlayerTwo;
    }

    public void setDeckOfPlayerTwo(ArrayList<Card> deckOfPlayerTwo) {
        DeckOfPlayerTwo = deckOfPlayerTwo;
    }

    public int getManaOfPlayerOne() {
        return ManaOfPlayerOne;
    }

    public void setManaOfPlayerOne(int manaOfPlayerOne) {
        ManaOfPlayerOne = manaOfPlayerOne;
    }

    public int getManaOfPlayerTwo() {
        return ManaOfPlayerTwo;
    }

    public void setManaOfPlayerTwo(int manaOfPlayerTwo) {
        ManaOfPlayerTwo = manaOfPlayerTwo;
    }

    public Hero getHeroOfPLayerOne() {
        return HeroOfPLayerOne;
    }

    public void setHeroOfPLayerOne(Hero heroOfPLayerOne) {
        HeroOfPLayerOne = heroOfPLayerOne;
    }

    public Hero getHeroOfPlayerTwo() {
        return HeroOfPlayerTwo;
    }

    public void setHeroOfPlayerTwo(Hero heroOfPlayerTwo) {
        HeroOfPlayerTwo = heroOfPlayerTwo;
    }

    public ArrayList<Card> getCardsInHandForPlayerOne() {
        return CardsInHandForPlayerOne;
    }

    public void setCardsInHandForPlayerOne(ArrayList<Card> cardsInHandForPlayerOne) {
        CardsInHandForPlayerOne = cardsInHandForPlayerOne;
    }

    public ArrayList<Card> getCardsInHandForPlayerTwo() {
        return CardsInHandForPlayerTwo;
    }

    public void setCardsInHandForPlayerTwo(ArrayList<Card> cardsInHandForPlayerTwo) {
        CardsInHandForPlayerTwo = cardsInHandForPlayerTwo;
    }

    public Decks getDecks() {
        return decks;
    }

    public void setDecks(Decks decks) {
        this.decks = decks;
    }

    public int getStartingPlayer() {
        return currentTurn;
    }

    public void setStartingPlayer(int startingPlayer) {
        this.currentTurn = startingPlayer;
    }

    /**
     * Array for the cards that PlayerTwo holds in hand
     */
    private ArrayList<Card> CardsInHandForPlayerTwo;

    //deck-urile pe care le primeste fiecare jucator in jocul respectiv din input
    private Decks decks;

    public int getCurrentTurn() {
        return currentTurn;
    }

    public void setCurrentTurn(int currentTurn) {
        this.currentTurn = currentTurn;
    }

    private int currentTurn;

    private int roundCounter;

    private int round;

    private CreateTable table;

    public CreateTable getTable() {
        return table;
    }

    public void setTable(CreateTable table) {
        this.table = table;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public StartingTheGame (final Input input, final int iterator) {
        /**
         * We assign the Hero for PlayerOne
         */

        HeroOfPLayerOne = switch (input.getGames().get(iterator).getStartGame().getPlayerOneHero().getName()) {
            case "Empress Thorina" -> new EmpressThorina(input.getGames().get(iterator).getStartGame().getPlayerOneHero());
            case "General Kocioraw" -> new GeneralKocioraw(input.getGames().get(iterator).getStartGame().getPlayerOneHero());
            case "King Mudface" -> new KIngMudface(input.getGames().get(iterator).getStartGame().getPlayerOneHero());
            case "Lord Royce" -> new LordRoyce(input.getGames().get(iterator).getStartGame().getPlayerOneHero());
            default -> null;

        };

        /**
         * We assign the Hero for PlayerTwo
         */

        HeroOfPlayerTwo = switch (input.getGames().get(iterator).getStartGame().getPlayerTwoHero().getName()) {
            case "Empress Thorina" -> new EmpressThorina(input.getGames().get(iterator).getStartGame().getPlayerTwoHero());
            case "General Kocioraw" -> new GeneralKocioraw(input.getGames().get(iterator).getStartGame().getPlayerTwoHero());
            case "King Mudface" -> new KIngMudface(input.getGames().get(iterator).getStartGame().getPlayerTwoHero());
            case "Lord Royce" -> new LordRoyce(input.getGames().get(iterator).getStartGame().getPlayerTwoHero());
            default -> null;

        };

        /**
         * Creating an array of decks for each player and adding the decks to the deck that a player chooses to play with
         */

        //am creat deck
        decks = new Decks(input,iterator);

        //pentru a amesteca cartile din deck-ul ales de player1
        Random random1 = new Random(input.getGames().get(iterator).getStartGame().getShuffleSeed());
        Collections.shuffle(decks.getDeckOfPlayerOne(), random1);
        //pentru a amesteca cartile din deck-ul ales de player2

        Random random2 = new Random(input.getGames().get(iterator).getStartGame().getShuffleSeed());
        Collections.shuffle(decks.getDeckOfPlayerTwo(), random2);

        //acum avem pachetele alese de fiecare jucator amestecate^^

        CardsInHandForPlayerOne = new ArrayList<>();
        CardsInHandForPlayerOne.add(decks.getDeckOfPlayerOne().get(0));
        decks.getDeckOfPlayerOne().remove(0);
        System.out.println("starting the game: " + CardsInHandForPlayerOne.size());


        CardsInHandForPlayerTwo = new ArrayList<>();
        CardsInHandForPlayerTwo.add(decks.getDeckOfPlayerTwo().get(0));
        decks.getDeckOfPlayerTwo().remove(0);

        System.out.println("starting the game: " + CardsInHandForPlayerTwo.size());

        ManaOfPlayerOne = 1;
        ManaOfPlayerTwo = 1;

        //aici retin jucatorul care incepe
        currentTurn = input.getGames().get(iterator).getStartGame().getStartingPlayer();

        roundCounter = 0;

        round = 1;

        table = new CreateTable();

    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        this.roundCounter = roundCounter;
    }
}
