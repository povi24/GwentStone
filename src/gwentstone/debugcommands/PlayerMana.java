package gwentstone.debugcommands;

import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

public class PlayerMana {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    private ObjectNode node;

    public PlayerMana(final ActionsInput action, final StartingTheGame newgame,
                      final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        node = objectMapper.createObjectNode();
        node.put("command", command);
        node.put("playerIdx", action.getPlayerIdx());
        if (action.getPlayerIdx() == 1) {
            node.put("output", newgame.getManaOfPlayerOne());
        } else {
            node.put("output", newgame.getManaOfPlayerTwo());
        }
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
