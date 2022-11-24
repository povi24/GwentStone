package GwentStone.DebugCommands;

import GwentStone.Minion.Minion;
import GwentStone.Minion.Sentinel;
import GwentStone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

public class CardAtPosition {
    private String command;

    private boolean showError;

    private String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    private ObjectNode node;

    public CardAtPosition(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.command = action.getCommand();

        node = objectMapper.createObjectNode();

        if(newgame.getTable().getTable().get(action.getX()).size() <= action.getY()) {

            showError = true;
            this.error = "No card available at that position.";
            node.put("command", command);
            node.put("x", action.getX());
            node.put("y", action.getY());
            node.put("output", error);


        } else {
            Minion deepCopyCardAtPosition = new Sentinel(newgame.getTable().getTable().get(action.getX()).get(action.getY()));
            node.put("command", command);
            node.put("x", action.getX());
            node.put("y", action.getY());
            node.putPOJO("output", deepCopyCardAtPosition);
        }

    }


    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public boolean isShowError() {
        return showError;
    }

    public void setShowError(boolean showError) {
        this.showError = showError;
    }

    public ObjectNode getNode() {
        return node;
    }

    public void setNode(ObjectNode node) {
        this.node = node;
    }
}
