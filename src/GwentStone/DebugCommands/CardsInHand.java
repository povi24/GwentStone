package GwentStone.DebugCommands;

import GwentStone.Card;
import GwentStone.StartingTheGame;
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

    public int getPlayerIdx() {
        return playerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        playerIdx = playerIdx;
    }

    private int playerIdx;


    public CardsInHand (ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.playerIdx = action.getPlayerIdx();
        ArrayList<Card> deepCopyHand;

        if(playerIdx == 1) {
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



}
