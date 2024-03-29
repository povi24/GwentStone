package gwentstone.debugcommands;

import gwentstone.Card;
import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

import java.util.ArrayList;

public class EnvironmentCardsInHand {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    private ObjectNode node;
    private int playerIdx;
    public EnvironmentCardsInHand(final ActionsInput action, final StartingTheGame newgame,
                                  final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.playerIdx = action.getPlayerIdx();

        ArrayList<Card> deepCopyOfEnvironmentCards;

        if (playerIdx == 1) {
            deepCopyOfEnvironmentCards = new ArrayList<>();
            for (Card card : newgame.getCardsInHandForPlayerOne()) {
                if (card.getName().equals("Firestorm") || card.getName().equals("Heart Hound")
                        || card.getName().equals("Winterfell")) {
                    deepCopyOfEnvironmentCards.add(card);
                }
            }
        } else {
            deepCopyOfEnvironmentCards = new ArrayList<>();
            for (Card card : newgame.getCardsInHandForPlayerTwo()) {
                if (card.getName().equals("Firestorm") || card.getName().equals("Heart Hound")
                        || card.getName().equals("Winterfell")) {
                    deepCopyOfEnvironmentCards.add(card);
                }
            }
        }

        node = objectMapper.createObjectNode();
        node.put("command", command);
        node.put("playerIdx", playerIdx);
        node.putPOJO("output", deepCopyOfEnvironmentCards);

    }
    /**
     *
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

    /**
     * @return playerIdx
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
}
