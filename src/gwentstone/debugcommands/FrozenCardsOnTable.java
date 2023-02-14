package gwentstone.debugcommands;

import gwentstone.minion.Minion;
import gwentstone.StartingTheGame;
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
    public FrozenCardsOnTable(final ActionsInput action, final StartingTheGame newgame,
                              final ObjectMapper objectMapper) {
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
