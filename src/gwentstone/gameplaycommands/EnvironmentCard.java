package gwentstone.gameplaycommands;

import gwentstone.environment.Environment;
import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

public class EnvironmentCard {

    private int handIdx;
    private int affectedRow;
    private String command;
    private String error;
    private boolean showError;
    private ObjectNode node;


    public EnvironmentCard(final ActionsInput action, final StartingTheGame newgame,
                           final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.handIdx = action.getHandIdx();
        this.affectedRow = action.getAffectedRow();

        node = objectMapper.createObjectNode();

        if (newgame.getCurrentTurn() == 1) {
            if (!(newgame.getCardsInHandForPlayerOne().get(handIdx).getName().equals("Firestorm")
                    || newgame.getCardsInHandForPlayerOne().get(handIdx)
                    .getName().equals("Heart Hound")
                    || newgame.getCardsInHandForPlayerOne().get(handIdx)
                    .getName().equals("Winterfell"))) {
                showError = true;
                this.error = "Chosen card is not of type environment.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("affectedRow", affectedRow);
                node.put("error", error);
            } else if (newgame.getManaOfPlayerOne() < newgame.getCardsInHandForPlayerOne()
                    .get(handIdx).getMana()) {
                showError = true;
                this.error = "Not enough mana to use environment card.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("affectedRow", affectedRow);
                node.put("error", error);
            } else if (!(action.getAffectedRow() == 0 || action.getAffectedRow() == 1)) {
                showError = true;
                this.error = "Chosen row does not belong to the enemy.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("affectedRow", affectedRow);
                node.put("error", error);
            } else if (newgame.getCardsInHandForPlayerOne().get(handIdx)
                    .getName().equals("Heart Hound")
            && newgame.getTable().getTable().get(3 - action.getAffectedRow()).size() == 5) {
                    showError = true;
                    this.error = "Cannot steal enemy card since the player's row is full.";
                    node.put("command", command);
                    node.put("handIdx", handIdx);
                    node.put("affectedRow", affectedRow);
                    node.put("error", error);
            } else {
                ((Environment) newgame.getCardsInHandForPlayerOne().get(handIdx))
                        .environmentAbility(newgame.getTable().getTable(), affectedRow);
                newgame.setManaOfPlayerOne(newgame.getManaOfPlayerOne() - newgame
                        .getCardsInHandForPlayerOne().get(handIdx).getMana());
                newgame.getCardsInHandForPlayerOne().remove(handIdx);
            }
        } else {
            if (!(newgame.getCardsInHandForPlayerTwo().get(handIdx)
                    .getName().equals("Firestorm")
                    || newgame.getCardsInHandForPlayerTwo().get(handIdx)
                    .getName().equals("Heart Hound")
                    || newgame.getCardsInHandForPlayerTwo().get(handIdx)
                    .getName().equals("Winterfell"))) {
                showError = true;
                this.error = "Chosen card is not of type environment.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("affectedRow", affectedRow);
                node.put("error", error);
            } else if (newgame.getManaOfPlayerTwo() < newgame.getCardsInHandForPlayerTwo()
                    .get(handIdx).getMana()) {
                showError = true;
                this.error = "Not enough mana to use environment card.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("affectedRow", affectedRow);
                node.put("error", error);
            } else if (!(action.getAffectedRow() == 2 || action.getAffectedRow() == 3)) {
                showError = true;
                this.error = "Chosen row does not belong to the enemy.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("affectedRow", affectedRow);
                node.put("error", error);
            } else if (newgame.getCardsInHandForPlayerTwo().get(handIdx)
                    .getName().equals("Heart Hound")) {
                if (newgame.getTable().getTable().get(3 - action.getAffectedRow()).size() == 5) {
                    showError = true;
                    this.error = "Cannot steal enemy card since the player's row is full.";
                    node.put("command", command);
                    node.put("handIdx", handIdx);
                    node.put("affectedRow", affectedRow);
                    node.put("error", error);
                }
            } else {
                ((Environment) newgame.getCardsInHandForPlayerTwo().get(handIdx))
                        .environmentAbility(newgame.getTable().getTable(), affectedRow);
                newgame.setManaOfPlayerTwo(newgame.getManaOfPlayerTwo() - newgame
                        .getCardsInHandForPlayerTwo().get(handIdx).getMana());
                newgame.getCardsInHandForPlayerTwo().remove(handIdx);
            }
        }
    }

    /**
     * @return handIdx
     */
    public int getHandIdx() {
        return handIdx;
    }

    /**
     * @param handIdx
     */
    public void setHandIdx(final int handIdx) {
        this.handIdx = handIdx;
    }

    /**
     * @return affectedRow
     */
    public int getAffectedRow() {
        return affectedRow;
    }

    /**
     * @param affectedRow
     */
    public void setAffectedRow(final int affectedRow) {
        this.affectedRow = affectedRow;
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
     * @return error
     */
    public String getError() {
        return error;
    }

    /**
     * @param error
     */
    public void setError(final String error) {
        this.error = error;
    }

    /**
     * @return showError
     */
    public boolean isShowError() {
        return showError;
    }

    /**
     * @param showError
     */
    public void setShowError(final boolean showError) {
        this.showError = showError;
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
