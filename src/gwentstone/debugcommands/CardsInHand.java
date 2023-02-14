package gwentstone.debugcommands;

import gwentstone.Card;
import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

import java.util.ArrayList;

public class CardsInHand {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    private ObjectNode node;

    /**
     *
     * @return playerIdx
     */
    public int getPlayerIdx() {
        return playerIdx;
    }

    /**
     *
     * @param playerIdx
     */
    public void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    private int playerIdx;


    public CardsInHand(final ActionsInput action, final StartingTheGame newgame,
                       final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.playerIdx = action.getPlayerIdx();
        ArrayList<Card> deepCopyHand;

        if (playerIdx == 1) {
            deepCopyHand = new ArrayList<>();
            deepCopyHand.addAll(newgame.getCardsInHandForPlayerOne());
        } else {
            deepCopyHand = new ArrayList<>();
            deepCopyHand.addAll(newgame.getCardsInHandForPlayerTwo());
        }

        node =  objectMapper.createObjectNode();
        node.put("command", command);
        node.put("playerIdx", playerIdx);
        node.putPOJO("output", deepCopyHand);

    }

    /**
     *
     * @return command
     */
    public String getCommand() {
        return command;
    }

    /**
     *
     * @param command
     */
    public void setCommand(final String command) {
        this.command = command;
    }

    /**
     *
     * @return node
     */
    public ObjectNode getNode() {
        return node;
    }

    /**
     *
     * @param node
     */
    public void setNode(final ObjectNode node) {
        this.node = node;
    }



}
