package gwentstone.debugcommands;

import gwentstone.minion.Minion;
import gwentstone.minion.Sentinel;
import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

public class CardAtPosition {
    private String command;
    private boolean showError;
    private String error;
    private ObjectNode node;

    public CardAtPosition(final ActionsInput action, final StartingTheGame newgame,
                          final ObjectMapper objectMapper) {
        this.command = action.getCommand();

        node = objectMapper.createObjectNode();

        if (newgame.getTable().getTable().get(action.getX()).size() <= action.getY()) {
            showError = true;
            this.error = "No card available at that position.";
            node.put("command", command);
            node.put("x", action.getX());
            node.put("y", action.getY());
            node.put("output", error);

        } else {
            Minion deepCopyCardAtPosition = new Sentinel(newgame.getTable().getTable().get(action.
                                                        getX()).get(action.getY()));
            node.put("command", command);
            node.put("x", action.getX());
            node.put("y", action.getY());
            node.putPOJO("output", deepCopyCardAtPosition);
        }

    }

    /**
     *
     * @return
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
     * @return
     */
    public boolean isShowError() {
        return showError;
    }
    /**
     *
     * @param showError
     */
    public void setShowError(final boolean showError) {
        this.showError = showError;
    }
    /**
     *
     * @return
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
    /**
     *
     * @return
     */
    public String getError() {
        return error;
    }
    /**
     *
     * @param error
     */
    public void setError(final String error) {
        this.error = error;
    }
}
