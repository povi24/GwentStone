package GwentStone.DebugCommands;

import GwentStone.Card;
import GwentStone.Minion.Minion;
import GwentStone.StartingTheGame;
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
    ArrayList<ArrayList<Minion>> deepCopyTable;

    ObjectNode node;

    public CardsOnTable(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.command = action.getCommand();
        deepCopyTable = new ArrayList<>();
        deepCopyTable.addAll(newgame.getTable().getTable());
        node = objectMapper.createObjectNode();
        node.put("command", command);
        node.putPOJO("output",deepCopyTable);

    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public ArrayList<ArrayList<Minion>> getDeepCopyTable() {
        return deepCopyTable;
    }

    public void setDeepCopyTable(ArrayList<ArrayList<Minion>> deepCopyTable) {
        this.deepCopyTable = deepCopyTable;
    }

    public ObjectNode getNode() {
        return node;
    }

    public void setNode(ObjectNode node) {
        this.node = node;
    }
}
