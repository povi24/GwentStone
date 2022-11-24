package GwentStone.DebugCommands;

import GwentStone.Card;
import GwentStone.StartingTheGame;
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
    public EnvironmentCardsInHand(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.playerIdx = action.getPlayerIdx();

        ArrayList<Card> deepCopyOfEnvironmentCards;

        if (playerIdx == 1) {
            deepCopyOfEnvironmentCards = new ArrayList<>();
            for (Card card : newgame.getCardsInHandForPlayerOne()) {
                if (card.getName().equals("Firestorm")|| card.getName().equals("Heart Hound") || card.getName().equals("Winterfell")) {
                    deepCopyOfEnvironmentCards.add(card);
                }
            }
        } else {
            deepCopyOfEnvironmentCards = new ArrayList<>();
            for (Card card : newgame.getCardsInHandForPlayerTwo()) {
                if (card.getName().equals("Firestorm")|| card.getName().equals("Heart Hound") || card.getName().equals("Winterfell")) {
                    deepCopyOfEnvironmentCards.add(card);
                }
            }
        }

        node = objectMapper.createObjectNode();
        node.put("command", command);
        node.put("playerIdx", playerIdx);
        node.putPOJO("output", deepCopyOfEnvironmentCards);

    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ObjectNode getNode() {
        return node;
    }

    public void setNode(ObjectNode node) {
        this.node = node;
    }

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        this.playerIdx = playerIdx;
    }
}
