package gwentstone.gameplaycommands;

import gwentstone.Card;
import gwentstone.environment.Firestorm;
import gwentstone.environment.HeartHound;
import gwentstone.environment.Winterfell;
import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;
import gwentstone.minion.Berserker;
import gwentstone.minion.Disciple;
import gwentstone.minion.Goliath;
import gwentstone.minion.Minion;
import gwentstone.minion.Miraj;
import gwentstone.minion.Sentinel;
import gwentstone.minion.TheCursedOne;
import gwentstone.minion.TheRipper;
import gwentstone.minion.Warden;

public class PlaceCard {
    private int handIdx;

    private String command;

    private String error;

    private boolean showError;
    private ObjectNode node;


    public PlaceCard(final ActionsInput action, final  StartingTheGame newgame,
                     final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.handIdx = action.getHandIdx();
        node = objectMapper.createObjectNode();
        if (newgame.getCurrentTurn() == 1) {
            if (newgame.getCardsInHandForPlayerOne().get(handIdx).getClass().equals(Firestorm.class)
                    || newgame.getCardsInHandForPlayerOne().get(handIdx)
                    .getClass().equals(HeartHound.class)
                    || newgame.getCardsInHandForPlayerOne().get(handIdx)
                    .getClass().equals(Winterfell.class)) {
                showError = true;
                this.error = "Cannot place environment card on table.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else if (newgame.getManaOfPlayerOne() < newgame.getCardsInHandForPlayerOne()
                    .get(handIdx).getMana()) {
                showError = true;
                this.error = "Not enough mana to place card on table.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else if ((newgame.getCardsInHandForPlayerOne().get(handIdx).getPosition()
                    .equals("back") && newgame.getTable().getTable().get(3).size() == 5)
                    || newgame.getCardsInHandForPlayerOne().get(handIdx).getPosition()
                    .equals("front") && newgame.getTable().getTable().get(2).size() == 5) {
                showError = true;
                this.error = "Cannot place card on table since row is full.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else {
                Card argument = newgame.getCardsInHandForPlayerOne().get(handIdx);
               Minion cardToPlace = switch (newgame.getCardsInHandForPlayerOne().get(handIdx).getName()) {
                   case "Berserker" -> new Berserker(argument);
                   case "Disciple" -> new Disciple(argument);
                   case "Goliath" -> new Goliath(argument);
                   case "Miraj" -> new Miraj(argument);
                   case "Sentinel" -> new Sentinel(argument);
                   case "The Cursed One" -> new TheCursedOne(argument);
                   case "The Ripper" -> new TheRipper(argument);
                   case "Warden" -> new Warden(argument);

                   default -> null;
               };

                newgame.setManaOfPlayerOne(newgame.getManaOfPlayerOne() - newgame
                        .getCardsInHandForPlayerOne().get(handIdx).getMana());
               if (newgame.getCardsInHandForPlayerOne().get(handIdx).getPosition().equals("back")) {
                   newgame.getTable().getTable().get(3).add(cardToPlace);
                   newgame.getCardsInHandForPlayerOne().remove(handIdx);
               } else {
                   newgame.getTable().getTable().get(2).add(cardToPlace);
                   newgame.getCardsInHandForPlayerOne().remove(handIdx);
               }
            }
        } else {
            if (newgame.getCardsInHandForPlayerTwo().get(handIdx).getClass().equals(Firestorm.class)
                    || newgame.getCardsInHandForPlayerTwo().get(handIdx).getClass()
                            .equals(HeartHound.class)
                    || newgame.getCardsInHandForPlayerTwo().get(handIdx).getClass()
                    .equals(Winterfell.class)) {
                showError = true;
                this.error = "Cannot place environment card on table.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else if (newgame.getManaOfPlayerTwo() < newgame.getCardsInHandForPlayerTwo()
                    .get(handIdx).getMana()) {
                showError = true;
                this.error = "Not enough mana to place card on table.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else if ((newgame.getCardsInHandForPlayerTwo().get(handIdx).getPosition()
                    .equals("back") && newgame.getTable().getTable().get(0).size() == 5)
                    || newgame.getCardsInHandForPlayerTwo().get(handIdx).getPosition()
                    .equals("front") && newgame.getTable().getTable().get(1).size() == 5) {
                showError = true;
                this.error = "Cannot place card on table since row is full.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else {
                Card argument = newgame.getCardsInHandForPlayerTwo().get(handIdx);
                Minion cardToPlace = switch (newgame.getCardsInHandForPlayerTwo()
                        .get(handIdx).getName()) {
                    case "Berserker" -> new Berserker(argument);
                    case "Disciple" -> new Disciple(argument);
                    case "Goliath" -> new Goliath(argument);
                    case "Miraj" -> new Miraj(argument);
                    case "Sentinel" -> new Sentinel(argument);
                    case "The Cursed One" -> new TheCursedOne(argument);
                    case "The Ripper" -> new TheRipper(argument);
                    case "Warden" -> new Warden(argument);

                    default -> null;
                };

                newgame.setManaOfPlayerTwo(newgame.getManaOfPlayerTwo() - newgame
                        .getCardsInHandForPlayerTwo().get(handIdx).getMana());

                if (newgame.getCardsInHandForPlayerTwo().get(handIdx)
                                    .getPosition().equals("back")) {
                    newgame.getTable().getTable().get(0).add(cardToPlace);
                    newgame.getCardsInHandForPlayerTwo().remove(handIdx);
                } else {
                    newgame.getTable().getTable().get(1).add(cardToPlace);
                    newgame.getCardsInHandForPlayerTwo().remove(handIdx);
                }
            }

        }
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
}
