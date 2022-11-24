package GwentStone.DebugCommands;

import GwentStone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

public class PlayerMana {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    private ObjectNode node;

    public PlayerMana(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.command = action.getCommand();
        node = objectMapper.createObjectNode();
        node.put("command", command);
        node.put("playerIdx", action.getPlayerIdx());
        if(action.getPlayerIdx() == 1) {
            node.put("output", newgame.getManaOfPlayerOne());
        } else {
            node.put("output", newgame.getManaOfPlayerTwo());
        }

        //aici trebuie sa vad cum adaug mana la fiecare nou joc in functie de runda
        //node.put("output", player.getMana);



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
