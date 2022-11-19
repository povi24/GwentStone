package GwentStone.AnotherCommands;

import GwentStone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

public class PlayerTurn {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    private ObjectNode node;

    public PlayerTurn(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.command = action.getCommand();
        node =  objectMapper.createObjectNode();
        node.put("command", command);
        node.put("output", newgame.getCurrentTurn());
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
