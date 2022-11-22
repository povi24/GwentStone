package GwentStone;

import GwentStone.Environment.Firestorm;
import GwentStone.Environment.HeartHound;
import GwentStone.Environment.Winterfell;
import GwentStone.Minion.*;
import fileio.CardInput;
import fileio.DecksInput;
import fileio.Input;

import java.util.ArrayList;

//aleg deck-ul de inceput pentru fiecar jucator
public class Decks {

    private ArrayList<Card> DeckOfPlayerOne ;
    private ArrayList<Card> DeckOfPlayerTwo ;

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

    public Decks(Input input, int i) {
        int IndexOfPLayerOne = input.getGames().get(i).getStartGame().getPlayerOneDeckIdx();
        int IndexOfPLayerTwo = input.getGames().get(i).getStartGame().getPlayerTwoDeckIdx();

        //toate cartile din deck-ul pe care l-a ales playerul in jocul respectiv
//        DeckOfPlayerOne.addAll(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne));
//        DeckOfPlayerTwo.addAll(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo));

        DeckOfPlayerOne = new ArrayList<>();
        //folosim auxCard pentru a converti din CardInput in tipul fiecarei carti pe care o adaugam in pachet
        for(int j = 0; j < input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).size(); j++) {
            Card auxCard = switch (input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j).getName()) {
                case "Berserker" -> new Berserker(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "Disciple" -> new Disciple(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "Goliath" ->new Goliath(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "Miraj" -> new Miraj(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "Sentinel" -> new Sentinel(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "The Cursed One" -> new TheCursedOne(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "The Ripper" -> new TheRipper(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "Warden" -> new Warden(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "Firestorm" -> new Firestorm(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "Heart Hound" -> new HeartHound(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));
                case "Winterfell" -> new Winterfell(input.getPlayerOneDecks().getDecks().get(IndexOfPLayerOne).get(j));

                default -> null;

            };
            //am adaugat fiecare tip de carte in pachetul jucatorului1
            DeckOfPlayerOne.add(auxCard);

        }

        DeckOfPlayerTwo = new ArrayList<>();
        for(int j = 0; j < input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).size(); j++) {
            Card auxCard = switch (input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j).getName()) {
                case "Berserker" -> new Berserker(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "Disciple" -> new Disciple(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "Goliath" ->new Goliath(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "Miraj" -> new Miraj(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "Sentinel" -> new Sentinel(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "The Cursed One" -> new TheCursedOne(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "The Ripper" -> new TheRipper(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "Warden" -> new Warden(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "Firestorm" -> new Firestorm(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "Heart Hound" -> new HeartHound(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));
                case "Winterfell" -> new Winterfell(input.getPlayerTwoDecks().getDecks().get(IndexOfPLayerTwo).get(j));

                default -> null;

            };
            //am adaugat fiecare tip de carte in pachetul jucatorului2
            DeckOfPlayerTwo.add(auxCard);
        }
    }
}
