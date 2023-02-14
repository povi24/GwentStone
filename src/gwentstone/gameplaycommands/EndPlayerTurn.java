package gwentstone.gameplaycommands;

import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class EndPlayerTurn {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    private ObjectNode node;

    public EndPlayerTurn(final StartingTheGame newgame) {
        if (newgame.getCurrentTurn() == 1) {
            for (int i = 2; i < 4; i++) {
                for (int j = 0; j < newgame.getTable().getTable().get(i).size(); j++) {
                    newgame.getTable().getTable().get(i).get(j).setFrozen(false);
                    newgame.getTable().getTable().get(i).get(j).setIfAlreadyAttacked(false);
                }
            }
            newgame.setCurrentTurn(2);
        } else {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < newgame.getTable().getTable().get(i).size(); j++) {
                    newgame.getTable().getTable().get(i).get(j).setFrozen(false);
                    newgame.getTable().getTable().get(i).get(j).setIfAlreadyAttacked(false);
                }
            }
            newgame.setCurrentTurn(1);
        }

        if (newgame.getRoundCounter() == 1) {
            if (newgame.getDecks().getDeckOfPlayerOne().size() > 0) {
                newgame.getCardsInHandForPlayerOne().add(newgame.getDecks()
                        .getDeckOfPlayerOne().get(0));
                newgame.getDecks().getDeckOfPlayerOne().remove(0);
            }


            if (newgame.getDecks().getDeckOfPlayerTwo().size() > 0) {
                newgame.getCardsInHandForPlayerTwo().add(newgame.getDecks()
                        .getDeckOfPlayerTwo().get(0));
                newgame.getDecks().getDeckOfPlayerTwo().remove(0);
            }

            newgame.setRoundCounter(0);
            newgame.setRound(newgame.getRound() + 1);

            if (newgame.getRound() < 10) {
                newgame.setManaOfPlayerOne(newgame.getManaOfPlayerOne() + newgame.getRound());
                newgame.setManaOfPlayerTwo(newgame.getManaOfPlayerTwo() + newgame.getRound());
            } else {
                newgame.setManaOfPlayerOne(newgame.getManaOfPlayerOne() + 10);
                newgame.setManaOfPlayerTwo(newgame.getManaOfPlayerTwo() + 10);
            }
        } else {
            newgame.setRoundCounter(1);
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
