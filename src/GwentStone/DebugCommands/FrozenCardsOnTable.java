package GwentStone.DebugCommands;

import GwentStone.Card;
import GwentStone.Minion.Minion;
import GwentStone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

import java.util.ArrayList;

public class FrozenCardsOnTable {
    /**
     * Command to be printed in JSON output file
     */
    private String command;

    private ObjectNode node;

    private int playerIdx;
    public FrozenCardsOnTable(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.command = action.getCommand();

        ArrayList<Minion> deepCopyOfFrozenCards;

            deepCopyOfFrozenCards = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                for (Minion minion : newgame.getTable().getTable().get(i)) {
                    if (minion.isFrozen()) {
                        deepCopyOfFrozenCards.add(minion);
                    }
                }
            }


        node = objectMapper.createObjectNode();
        node.put("command", command);
        node.putPOJO("output", deepCopyOfFrozenCards);

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
