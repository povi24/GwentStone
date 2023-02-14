package gwentstone.gameplaycommands;

import gwentstone.minion.Minion;
import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import fileio.Coordinates;

import java.util.ArrayList;

public class CardUsesAttack {

    private String command;
    private Coordinates cardAttacker;
    private Coordinates cardAttacked;
    private String error;
    private boolean showError;
    private ObjectNode node;
    public CardUsesAttack(final ActionsInput action, final StartingTheGame newgame,
                          final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        cardAttacker = new Coordinates();
        cardAttacked = new Coordinates();
        cardAttacker.setX(action.getCardAttacker().getX());
        cardAttacker.setY(action.getCardAttacker().getY());
        cardAttacked.setX(action.getCardAttacked().getX());
        cardAttacked.setY(action.getCardAttacked().getY());

        node = objectMapper.createObjectNode();

        if (newgame.getCurrentTurn() == 1) {
            if (cardAttacked.getX() == 2 || cardAttacked.getX() == 3) {
                showError = true;
                this.error = "Attacked card does not belong to the enemy.";
                node.put("command", command);
                node.putPOJO("cardAttacker", cardAttacker);
                node.putPOJO("cardAttacked", cardAttacked);
                node.put("error", error);
            } else if (newgame.getTable().getTable().get(cardAttacker.getX())
                    .get(cardAttacker.getY()).getIfAlreadyAttacked()) {
                showError = true;
                this.error = "Attacker card has already attacked this turn.";
                node.put("command", command);
                node.putPOJO("cardAttacker", cardAttacker);
                node.putPOJO("cardAttacked", cardAttacked);
                node.put("error", error);
            } else if (newgame.getTable().getTable().get(cardAttacker.getX())
                    .get(cardAttacker.getY()).isFrozen()) {
                showError = true;
                this.error = "Attacker card is frozen.";
                node.put("command", command);
                node.putPOJO("cardAttacker", cardAttacker);
                node.putPOJO("cardAttacked", cardAttacked);
                node.put("error", error);
            } else if (checkIfTankExists(newgame.getTable().getTable(), 1)
                    && !newgame.getTable().getTable().get(cardAttacked
                    .getX()).get(cardAttacked.getY()).isTank()) {
                showError = true;
                this.error = "Attacked card is not of type 'Tank'.";
                node.put("command", command);
                node.putPOJO("cardAttacker", cardAttacker);
                node.putPOJO("cardAttacked", cardAttacked);
                node.put("error", error);
            } else {
                newgame.getTable().getTable().get(cardAttacked.getX()).get(cardAttacked.getY())
                        .setHealth(newgame.getTable().getTable().get(cardAttacked.getX())
                                .get(cardAttacked.getY()).getHealth()
                                - newgame.getTable().getTable().get(cardAttacker.getX())
                                .get(cardAttacker.getY()).getAttackDamage());
                newgame.getTable().getTable().get(cardAttacker.getX()).get(cardAttacker.getY())
                        .setIfAlreadyAttacked(true);
                if (newgame.getTable().getTable().get(cardAttacked.getX()).get(cardAttacked.getY())
                        .getHealth() <= 0) {
                    newgame.getTable().getTable().get(cardAttacked.getX())
                            .remove(cardAttacked.getY()).getHealth();
                }
            }
        } else {

            if (cardAttacked.getX() == 0 || cardAttacked.getX() == 1) {
                showError = true;
                this.error = "Attacked card does not belong to the enemy.";
                node.put("command", command);
                node.putPOJO("cardAttacker", cardAttacker);
                node.putPOJO("cardAttacked", cardAttacked);
                node.put("error", error);
            } else if (newgame.getTable().getTable().get(cardAttacker.getX())
                    .get(cardAttacker.getY()).getIfAlreadyAttacked()) {
                showError = true;
                this.error = "Attacker card has already attacked this turn.";
                node.put("command", command);
                node.putPOJO("cardAttacker", cardAttacker);
                node.putPOJO("cardAttacked", cardAttacked);
                node.put("error", error);
            } else if (newgame.getTable().getTable().get(cardAttacker.getX())
                    .get(cardAttacker.getY()).isFrozen()) {
                showError = true;
                this.error = "Attacker card is frozen.";
                node.put("command", command);
                node.putPOJO("cardAttacker", cardAttacker);
                node.putPOJO("cardAttacked", cardAttacked);
                node.put("error", error);
            } else if (checkIfTankExists(newgame.getTable().getTable(), 2)
                    && !newgame.getTable().getTable().get(cardAttacked.getX())
                    .get(cardAttacked.getY()).isTank()) {
                showError = true;
                this.error = "Attacked card is not of type 'Tank'.";
                node.put("command", command);
                node.putPOJO("cardAttacker", cardAttacker);
                node.putPOJO("cardAttacked", cardAttacked);
                node.put("error", error);
            } else {
                newgame.getTable().getTable().get(cardAttacked.getX()).get(cardAttacked.getY())
                        .setHealth(newgame.getTable().getTable().get(cardAttacked.getX())
                                .get(cardAttacked.getY()).getHealth()
                                - newgame.getTable().getTable().get(cardAttacker.getX())
                                .get(cardAttacker.getY()).getAttackDamage());
                newgame.getTable().getTable().get(cardAttacker.getX()).get(cardAttacker.getY())
                        .setIfAlreadyAttacked(true);
                if (newgame.getTable().getTable().get(cardAttacked.getX()).get(cardAttacked.getY())
                        .getHealth() <= 0) {
                    newgame.getTable().getTable().get(cardAttacked.getX()).remove(cardAttacked
                            .getY()).getHealth();
                }
            }
        }
    }

    private boolean checkIfTankExists(final ArrayList<ArrayList<Minion>> table,
                                      final int row) {
        int tankExists = 0;
        for (int i = 0; i < table.get(row).size(); i++) {
            if (table.get(row).get(i).isTank()) {
                tankExists = 1;
                break;
            }
        }
        if (tankExists == 1) {
            return true;
        } else {
            return false;
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
     * @return shoError
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
