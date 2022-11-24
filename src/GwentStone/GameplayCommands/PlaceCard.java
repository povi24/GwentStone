package GwentStone.GameplayCommands;

import GwentStone.Card;
import GwentStone.Environment.Firestorm;
import GwentStone.Environment.HeartHound;
import GwentStone.Environment.Winterfell;
import GwentStone.Minion.*;
import GwentStone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

public class PlaceCard {
    private int handIdx;

    private String command;

    private String error;

    private boolean showError;
    private ObjectNode node;

    public boolean isShowError() {
        return showError;
    }

    public void setShowError(boolean showError) {
        this.showError = showError;
    }

    public PlaceCard(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        //2 cazuri pt player1 si pt player2
        this.command = action.getCommand();
        this.handIdx = action.getHandIdx();

        node = objectMapper.createObjectNode();

        if(newgame.getCurrentTurn() == 1) {

            if(newgame.getCardsInHandForPlayerOne().get(handIdx).getClass().equals(Firestorm.class) ||
                    newgame.getCardsInHandForPlayerOne().get(handIdx).getClass().equals(HeartHound.class) ||
                    newgame.getCardsInHandForPlayerOne().get(handIdx).getClass().equals(Winterfell.class)) {
                showError = true;
                this.error = "Cannot place environment card on table.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else if(newgame.getManaOfPlayerOne() < newgame.getCardsInHandForPlayerOne().get(handIdx).getMana()){
                showError = true;
                this.error = "Not enough mana to place card on table.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else if ((newgame.getCardsInHandForPlayerOne().get(handIdx).getPosition().equals("back") && newgame.getTable().getTable().get(3).size() == 5)
                            || newgame.getCardsInHandForPlayerOne().get(handIdx).getPosition().equals("front") && newgame.getTable().getTable().get(2).size() == 5 ) {
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
                   case "Goliath" ->new Goliath(argument);
                   case "Miraj" -> new Miraj(argument);
                   case "Sentinel" -> new Sentinel(argument);
                   case "The Cursed One" -> new TheCursedOne(argument);
                   case "The Ripper" -> new TheRipper(argument);
                   case "Warden" -> new Warden(argument);

                   default -> null;
               };

                newgame.setManaOfPlayerOne(newgame.getManaOfPlayerOne() - newgame.getCardsInHandForPlayerOne().get(handIdx).getMana());

               if(newgame.getCardsInHandForPlayerOne().get(handIdx).getPosition().equals("back")) {
                   newgame.getTable().getTable().get(3).add(cardToPlace);
                   newgame.getCardsInHandForPlayerOne().remove(handIdx);
               } else {
                   newgame.getTable().getTable().get(2).add(cardToPlace);
                   newgame.getCardsInHandForPlayerOne().remove(handIdx);
               }
            }
        } else {
            if(newgame.getCardsInHandForPlayerTwo().get(handIdx).getClass().equals(Firestorm.class) ||
                    newgame.getCardsInHandForPlayerTwo().get(handIdx).getClass().equals(HeartHound.class) ||
                    newgame.getCardsInHandForPlayerTwo().get(handIdx).getClass().equals(Winterfell.class)) {
                showError = true;
                this.error = "Cannot place environment card on table.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else if(newgame.getManaOfPlayerTwo() < newgame.getCardsInHandForPlayerTwo().get(handIdx).getMana()){
                showError = true;
                this.error = "Not enough mana to place card on table.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else if ((newgame.getCardsInHandForPlayerTwo().get(handIdx).getPosition().equals("back") && newgame.getTable().getTable().get(0).size() == 5)
                    || newgame.getCardsInHandForPlayerTwo().get(handIdx).getPosition().equals("front") && newgame.getTable().getTable().get(1).size() == 5 ) {
                showError = true;
                this.error = "Cannot place card on table since row is full.";
                node.put("command", command);
                node.put("handIdx", handIdx);
                node.put("error", error);
            } else {
                Card argument = newgame.getCardsInHandForPlayerTwo().get(handIdx);
                Minion cardToPlace = switch (newgame.getCardsInHandForPlayerTwo().get(handIdx).getName()) {
                    case "Berserker" -> new Berserker(argument);
                    case "Disciple" -> new Disciple(argument);
                    case "Goliath" ->new Goliath(argument);
                    case "Miraj" -> new Miraj(argument);
                    case "Sentinel" -> new Sentinel(argument);
                    case "The Cursed One" -> new TheCursedOne(argument);
                    case "The Ripper" -> new TheRipper(argument);
                    case "Warden" -> new Warden(argument);

                    default -> null;
                };

                newgame.setManaOfPlayerTwo(newgame.getManaOfPlayerTwo() - newgame.getCardsInHandForPlayerTwo().get(handIdx).getMana());

                if(newgame.getCardsInHandForPlayerTwo().get(handIdx).getPosition().equals("back")) {
                    newgame.getTable().getTable().get(0).add(cardToPlace);
                    newgame.getCardsInHandForPlayerTwo().remove(handIdx);
                } else {
                    newgame.getTable().getTable().get(1).add(cardToPlace);
                    newgame.getCardsInHandForPlayerTwo().remove(handIdx);
                }
            }

        }


    }

    public ObjectNode getNode() {
        return node;
    }

    public void setNode(ObjectNode node) {
        this.node = node;
    }

    public int getHandIdx() {
        return handIdx;
    }

    public void setHandIdx(int handIdx) {
        this.handIdx = handIdx;
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
}
