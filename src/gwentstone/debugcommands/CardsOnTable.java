package gwentstone.debugcommands;

import gwentstone.minion.Minion;
import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

import java.util.ArrayList;

public class CardsOnTable {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    /**
     * ArrayList consisting of cards that are placed on the table to be printed in JSON output file
     */
    private ArrayList<ArrayList<Minion>> deepCopyTable;

    private ObjectNode node;

    public CardsOnTable(final ActionsInput action, final StartingTheGame newgame,
                        final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        deepCopyTable = new ArrayList<>();
        deepCopyTable.addAll(newgame.getTable().getTable());
        node = objectMapper.createObjectNode();
        node.put("command", command);
        node.putPOJO("output", deepCopyTable);

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
     * @return getDeepCopyTable
     */
    public ArrayList<ArrayList<Minion>> getDeepCopyTable() {
        return deepCopyTable;
    }
    /**
     *
     * @param deepCopyTable
     */
    public void setDeepCopyTable(final ArrayList<ArrayList<Minion>> deepCopyTable) {
        this.deepCopyTable = deepCopyTable;
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
