package gwentstone;


import fileio.Input;
import gwentstone.hero.EmpressThorina;
import gwentstone.hero.GeneralKocioraw;
import gwentstone.hero.Hero;
import gwentstone.hero.KIngMudface;
import gwentstone.hero.LordRoyce;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


/**
 * Here we assign each player the deck he starts the game with, and
 * we also assign the Hero for each player
 * We prepare the start of the game, as mentioned in the homework,
 * initiating each player's mana, and their turn
 */
public class StartingTheGame {
    /**
     * The Deck that PlayerOne chooses to play with
     */
    private ArrayList<Card> deckOfPlayerOne;
    /**
     * The Deck that PlayerTwo chooses to play with
     */
    private ArrayList<Card> deckOfPlayerTwo;
    /**
     * Mana for PlayerOne at the start of each game
     */
    private int manaOfPlayerOne;
    /**
     * Mana for PlayerTwo at the start of each game
     */
    private int manaOfPlayerTwo;
    /**
     * Hero for PlayerOne
     */
    private Hero heroOfPLayerOne;
    /**
     * Hero for PlayerTwo
     */
    private Hero heroOfPlayerTwo;
    /**
     * Array for the cards that PlayerOne holds in hand
     */
    private ArrayList<Card> cardsInHandForPlayerOne;

    /**
     * Array for the cards that PlayerTwo holds in hand
     */
    private ArrayList<Card> cardsInHandForPlayerTwo;

    private Decks decks;

    /**
     * @return currentTurn
     */
    public int getCurrentTurn() {
        return currentTurn;
    }

    /**
     * @param currentTurn
     */
    public void setCurrentTurn(final int currentTurn) {
        this.currentTurn = currentTurn;
    }

    private int currentTurn;

    private int roundCounter;

    private int round;

    private CreateTable table;

    /**
     * @return table
     */

    public CreateTable getTable() {
        return table;
    }

    /**
     * @param table
     */
    public void setTable(final CreateTable table) {
        this.table = table;
    }

    /**
     * @return round
     */
    public int getRound() {
        return round;
    }

    /**
     * @param round
     */
    public void setRound(final int round) {
        this.round = round;
    }

    public StartingTheGame(final Input input, final int iterator) {
        /**
         * We assign the Hero for PlayerOne
         */

        heroOfPLayerOne = switch (input.getGames().get(iterator).getStartGame()
                                    .getPlayerOneHero().getName()) {
            case "Empress Thorina" -> new EmpressThorina(input.getGames()
                                    .get(iterator).getStartGame().getPlayerOneHero());
            case "General Kocioraw" -> new GeneralKocioraw(input.getGames()
                                    .get(iterator).getStartGame().getPlayerOneHero());
            case "King Mudface" -> new KIngMudface(input.getGames()
                                    .get(iterator).getStartGame().getPlayerOneHero());
            case "Lord Royce" -> new LordRoyce(input.getGames().get(iterator)
                                    .getStartGame().getPlayerOneHero());
            default -> null;

        };

        /**
         * We assign the Hero for PlayerTwo
         */

        heroOfPlayerTwo = switch (input.getGames().get(iterator).getStartGame()
                                .getPlayerTwoHero().getName()) {
            case "Empress Thorina" -> new EmpressThorina(input.getGames()
                                    .get(iterator).getStartGame().getPlayerTwoHero());
            case "General Kocioraw" -> new GeneralKocioraw(input.getGames()
                                    .get(iterator).getStartGame().getPlayerTwoHero());
            case "King Mudface" -> new KIngMudface(input.getGames()
                                    .get(iterator).getStartGame().getPlayerTwoHero());
            case "Lord Royce" -> new LordRoyce(input.getGames()
                                    .get(iterator).getStartGame().getPlayerTwoHero());
            default -> null;

        };
        decks = new Decks(input, iterator);

        Random random1 = new Random(input.getGames().get(iterator)
                            .getStartGame().getShuffleSeed());
        Collections.shuffle(decks.getDeckOfPlayerOne(), random1);

        Random random2 = new Random(input.getGames().get(iterator)
                            .getStartGame().getShuffleSeed());
        Collections.shuffle(decks.getDeckOfPlayerTwo(), random2);

        cardsInHandForPlayerOne = new ArrayList<>();
        cardsInHandForPlayerOne.add(decks.getDeckOfPlayerOne().get(0));
        decks.getDeckOfPlayerOne().remove(0);
        System.out.println("starting the game: " + cardsInHandForPlayerOne.size());


        cardsInHandForPlayerTwo = new ArrayList<>();
        cardsInHandForPlayerTwo.add(decks.getDeckOfPlayerTwo().get(0));
        decks.getDeckOfPlayerTwo().remove(0);

        System.out.println("starting the game: " + cardsInHandForPlayerTwo.size());

        manaOfPlayerOne = 1;
        manaOfPlayerTwo = 1;

        currentTurn = input.getGames().get(iterator).getStartGame().getStartingPlayer();

        roundCounter = 0;

        round = 1;

        table = new CreateTable();

    }

    /**
     * @return roundCounter
     */
    public int getRoundCounter() {
        return roundCounter;
    }

    /**
     * @param roundCounter
     */
    public void setRoundCounter(final int roundCounter) {
        this.roundCounter = roundCounter;
    }

    /**
     * @return deckOfPlayerOne
     */
    public ArrayList<Card> getDeckOfPlayerOne() {
        return deckOfPlayerOne;
    }

    /**
     * @param deckOfPlayerOne
     */
    public void setDeckOfPlayerOne(final ArrayList<Card> deckOfPlayerOne) {
        this.deckOfPlayerOne = deckOfPlayerOne;
    }

    /**
     * @return deckOfPlayerTwo
     */
    public ArrayList<Card> getDeckOfPlayerTwo() {
        return deckOfPlayerTwo;
    }

    /**
     * @param deckOfPlayerTwo
     */
    public void setDeckOfPlayerTwo(final ArrayList<Card> deckOfPlayerTwo) {
        this.deckOfPlayerTwo = deckOfPlayerTwo;
    }

    /**
     * @return manaOfPlayerOne
     */
    public int getManaOfPlayerOne() {
        return manaOfPlayerOne;
    }

    /**
     * @param manaOfPlayerOne
     */
    public void setManaOfPlayerOne(final int manaOfPlayerOne) {
        this.manaOfPlayerOne = manaOfPlayerOne;
    }

    /**
     * @return manaOfPlayerTwo
     */
    public int getManaOfPlayerTwo() {
        return manaOfPlayerTwo;
    }

    /**
     * @param manaOfPlayerTwo
     */

    public void setManaOfPlayerTwo(final int manaOfPlayerTwo) {
        this.manaOfPlayerTwo = manaOfPlayerTwo;
    }

    /**
     * @return heroOfPLayerOne
     */

    public Hero getHeroOfPLayerOne() {
        return heroOfPLayerOne;
    }

    /**
     * @param heroOfPLayerOne
     */
    public void setHeroOfPLayerOne(final Hero heroOfPLayerOne) {
        this.heroOfPLayerOne = heroOfPLayerOne;
    }

    /**
     * @return heroOfPlayerTwo
     */
    public Hero getHeroOfPlayerTwo() {
        return heroOfPlayerTwo;
    }

    /**
     * @param heroOfPlayerTwo
     */
    public void setHeroOfPlayerTwo(final Hero heroOfPlayerTwo) {
        this.heroOfPlayerTwo = heroOfPlayerTwo;
    }

    /**
     * @return cardsInHandForPlayerOne
     */
    public ArrayList<Card> getCardsInHandForPlayerOne() {
        return cardsInHandForPlayerOne;
    }

    /**
     * @param cardsInHandForPlayerOne
     */
    public void setCardsInHandForPlayerOne(final ArrayList<Card> cardsInHandForPlayerOne) {
        this.cardsInHandForPlayerOne = cardsInHandForPlayerOne;
    }

    /**
     * @return cardsInHandForPlayerTwo
     */
    public ArrayList<Card> getCardsInHandForPlayerTwo() {
        return cardsInHandForPlayerTwo;
    }

    /**
     * @param cardsInHandForPlayerTwo
     */
    public void setCardsInHandForPlayerTwo(final ArrayList<Card> cardsInHandForPlayerTwo) {
        this.cardsInHandForPlayerTwo = cardsInHandForPlayerTwo;
    }

    /**
     * @return decks
     */
    public Decks getDecks() {
        return decks;
    }

    /**
     * @param decks
     */
    public void setDecks(final Decks decks) {
        this.decks = decks;
    }

    /**
     * @return currentTurn
     */
    public int getStartingPlayer() {
        return currentTurn;
    }

    /**
     * @param startingPlayer
     */
    public void setStartingPlayer(final int startingPlayer) {
        this.currentTurn = startingPlayer;
    }
}
