package GwentStone.GameplayCommands;

import GwentStone.Environment.Environment;
import GwentStone.StartingTheGame;
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

    //private StartingTheGame newgame;


    //errors if we use environment card
    public EnvironmentCard(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.handIdx = action.getHandIdx();
        this.affectedRow = action.getAffectedRow();

        node = objectMapper.createObjectNode();

        if (newgame.getCurrentTurn() == 1) {
            //pentru player-ul 1
            if (!(newgame.getCardsInHandForPlayerOne().get(handIdx).getName().equals("Firestorm")
                    || newgame.getCardsInHandForPlayerOne().get(handIdx).getName().equals("Heart Hound")
                    || newgame.getCardsInHandForPlayerOne().get(handIdx).getName().equals("Winterfell"))) {
                showError = true;
                this.error = "Chosen card is not of type environment.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("affectedRow", affectedRow);
                node.put("error", error);
                //newgame.getDeckOfPlayerOne().remove(handIdx);
            } else if (newgame.getManaOfPlayerOne() < newgame.getCardsInHandForPlayerOne().get(handIdx).getMana()) {
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
            } else if (newgame.getCardsInHandForPlayerOne().get(handIdx).getName().equals("Heart Hound")
            && newgame.getTable().getTable().get(3 - action.getAffectedRow()).size() == 5) {
                //formula pentru a treia eroare
                    showError = true;
                    this.error = "Cannot steal enemy card since the player's row is full.";
                    node.put("command", command);
                    node.put("handIdx", handIdx);
                    node.put("affectedRow", affectedRow);
                    node.put("error", error);
            } else {
                ((Environment)newgame.getCardsInHandForPlayerOne().get(handIdx)).environmentAbility(newgame.getTable().getTable(), affectedRow);
                newgame.setManaOfPlayerOne(newgame.getManaOfPlayerOne() - newgame.getCardsInHandForPlayerOne().get(handIdx).getMana());
                newgame.getCardsInHandForPlayerOne().remove(handIdx);
            }
        } else {
            //pentru player-ul 2

            if (!(newgame.getCardsInHandForPlayerTwo().get(handIdx).getName().equals("Firestorm")
                    || newgame.getCardsInHandForPlayerTwo().get(handIdx).getName().equals("Heart Hound")
                    || newgame.getCardsInHandForPlayerTwo().get(handIdx).getName().equals("Winterfell"))) {
                showError = true;
                this.error = "Chosen card is not of type environment.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("affectedRow", affectedRow);
                node.put("error", error);
                //newgame.getDeckOfPlayerTwo().remove(handIdx);
            } else if (newgame.getManaOfPlayerTwo() < newgame.getCardsInHandForPlayerTwo().get(handIdx).getMana()) {
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
            } else if (newgame.getCardsInHandForPlayerTwo().get(handIdx).getName().equals("Heart Hound")) {
                //formula pentru a treia eroare
                if (newgame.getTable().getTable().get(3 - action.getAffectedRow()).size() == 5) {
                    showError = true;
                    this.error = "Cannot steal enemy card since the player's row is full.";
                    node.put("command", command);
                    node.put("handIdx", handIdx);
                    node.put("affectedRow", affectedRow);
                    node.put("error", error);
                }
            } else {
                ((Environment)newgame.getCardsInHandForPlayerTwo().get(handIdx)).environmentAbility(newgame.getTable().getTable(), affectedRow);
                newgame.setManaOfPlayerTwo(newgame.getManaOfPlayerTwo() - newgame.getCardsInHandForPlayerTwo().get(handIdx).getMana());
                newgame.getCardsInHandForPlayerTwo().remove(handIdx);
            }
        }
    }

    public int getHandIdx() {
        return handIdx;
    }

    public void setHandIdx(int handIdx) {
        this.handIdx = handIdx;
    }

    public int getAffectedRow() {
        return affectedRow;
    }

    public void setAffectedRow(int affectedRow) {
        this.affectedRow = affectedRow;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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
