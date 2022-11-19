package GwentStone.DebugCommands;

import GwentStone.Card;
import GwentStone.Decks;
import GwentStone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

import java.util.ArrayList;

public class PlayerDeck {
    /**
     * Command to be printed in JSON output file
     */
    private String Command;
    /**
     * Index to be printed in JSON output file
     */
    private int PlayerIdx;
    /**
     * ArrayList of cards to be printed in JSON output file
     */
    private ArrayList<Card> deepCopyofDeck;

    //creez un nod pentru actiunea din clasa asta pentru a afisa la output
    private ObjectNode node;



    public PlayerDeck(ActionsInput action, Decks decks, ObjectMapper objectMapper) {
        this.Command = action.getCommand();
        this.PlayerIdx = action.getPlayerIdx();
        if (PlayerIdx == 1) {
            //deep copy la obiectul pe care il bag in nod
            this.deepCopyofDeck = new ArrayList<>();
            deepCopyofDeck.addAll(decks.getDeckOfPlayerOne());
        } else {
            this.deepCopyofDeck = new ArrayList<>();
            deepCopyofDeck.addAll(decks.getDeckOfPlayerTwo());
        }
        node =  objectMapper.createObjectNode();
        node.put("command", "getPlayerDeck");
        node.put("playerIdx", PlayerIdx);
        node.putPOJO("output", deepCopyofDeck);
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public int getPlayerIdx() {
        return PlayerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        PlayerIdx = playerIdx;
    }

    public ArrayList<Card> getDeepCopyofDeck() {
        return deepCopyofDeck;
    }

    public void setDeepCopyofDeck(ArrayList<Card> deepCopyofDeck) {
        this.deepCopyofDeck = deepCopyofDeck;
    }

    public ObjectNode getNode() {
        return node;
    }

    public void setNode(ObjectNode node) {
        this.node = node;
    }
}
