package gwentstone;

import gwentstone.environment.Firestorm;
import gwentstone.environment.HeartHound;
import gwentstone.environment.Winterfell;

import fileio.Input;
import gwentstone.minion.Berserker;
import gwentstone.minion.Disciple;
import gwentstone.minion.Goliath;
import gwentstone.minion.Miraj;
import gwentstone.minion.Sentinel;
import gwentstone.minion.TheCursedOne;
import gwentstone.minion.TheRipper;
import gwentstone.minion.Warden;

import java.util.ArrayList;

/**
 * Here we create the deck, adding each card
 */
public class Decks {
    /**
     * An array for all the decks that player one has
     */
    private ArrayList<Card> deckOfPlayerOne;
    /**
     * An array for all the decks that player two has
     */
    private ArrayList<Card> deckOfPlayerTwo;


    public Decks(final Input input, final int i) {
        int indexOfPlayerOne = input.getGames().get(i).getStartGame().getPlayerOneDeckIdx();
        int indexOfPLayerTwo = input.getGames().get(i).getStartGame().getPlayerTwoDeckIdx();

        deckOfPlayerOne = new ArrayList<>();
        for (int j = 0; j < input.getPlayerOneDecks().getDecks()
                            .get(indexOfPlayerOne).size(); j++) {
            Card auxCard = switch (input.getPlayerOneDecks().getDecks()
                                    .get(indexOfPlayerOne).get(j).getName()) {
                case "Berserker" -> new Berserker(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "Disciple" -> new Disciple(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "Goliath" -> new Goliath(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "Miraj" -> new Miraj(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "Sentinel" -> new Sentinel(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "The Cursed One" -> new TheCursedOne(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "The Ripper" -> new TheRipper(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "Warden" -> new Warden(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "Firestorm" -> new Firestorm(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "Heart Hound" -> new HeartHound(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                case "Winterfell" -> new Winterfell(input.getPlayerOneDecks()
                                    .getDecks().get(indexOfPlayerOne).get(j));
                default -> null;

            };
            deckOfPlayerOne.add(auxCard);

        }

        deckOfPlayerTwo = new ArrayList<>();
        for (int j = 0; j < input.getPlayerTwoDecks().getDecks()
                            .get(indexOfPLayerTwo).size(); j++) {
            Card auxCard = switch (input.getPlayerTwoDecks().getDecks()
                                    .get(indexOfPLayerTwo).get(j).getName()) {
                case "Berserker" -> new Berserker(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "Disciple" -> new Disciple(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "Goliath" -> new Goliath(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "Miraj" -> new Miraj(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "Sentinel" -> new Sentinel(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "The Cursed One" -> new TheCursedOne(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "The Ripper" -> new TheRipper(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "Warden" -> new Warden(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "Firestorm" -> new Firestorm(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "Heart Hound" -> new HeartHound(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));
                case "Winterfell" -> new Winterfell(input.getPlayerTwoDecks()
                                    .getDecks().get(indexOfPLayerTwo).get(j));

                default -> null;
            };
            deckOfPlayerTwo.add(auxCard);
        }
    }

    /**
     * @return DeckOfPlayerOne
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
     * @return DeckOfPlayerTwo
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
}
