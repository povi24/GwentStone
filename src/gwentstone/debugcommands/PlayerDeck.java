package gwentstone.debugcommands;

import gwentstone.Card;
import gwentstone.Decks;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

import java.util.ArrayList;

public class PlayerDeck {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    /**
     * Index to be printed in JSON output file
     */
    private int playerIdx;
    /**
     * ArrayList of cards to be printed in JSON output file
     */
    private ArrayList<Card> deepCopyofDeck;

    private ObjectNode node;

    public PlayerDeck(final ActionsInput action, final Decks decks,
                      final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.playerIdx = action.getPlayerIdx();
        if (playerIdx == 1) {
            this.deepCopyofDeck = new ArrayList<>();
            deepCopyofDeck.addAll(decks.getDeckOfPlayerOne());
        } else {
            this.deepCopyofDeck = new ArrayList<>();
            deepCopyofDeck.addAll(decks.getDeckOfPlayerTwo());
        }
        node =  objectMapper.createObjectNode();
        node.put("command", "getPlayerDeck");
        node.put("playerIdx", playerIdx);
        node.putPOJO("output", deepCopyofDeck);
    }

    /**
     * @return command
     */
    public String getCommand() {
        return command;
    }

    /**
     * @param command
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     * @return PlayerIdx
     */
    public int getPlayerIdx() {
        return playerIdx;
    }

    /**
     * @param playerIdx
     */
    public void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    /**
     * @return deepCopyofDeck
     */
    public ArrayList<Card> getDeepCopyofDeck() {
        return deepCopyofDeck;
    }

    /**
     * @param deepCopyofDeck
     */
    public void setDeepCopyofDeck(final ArrayList<Card> deepCopyofDeck) {
        this.deepCopyofDeck = deepCopyofDeck;
    }

    /**
     * @return node
     */
    public ObjectNode getNode() {
        return node;
    }

    /**
     * @param node
     */
    public void setNode(final ObjectNode node) {
        this.node = node;
    }
}
