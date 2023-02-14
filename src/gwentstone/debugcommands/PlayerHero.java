package gwentstone.debugcommands;

import gwentstone.hero.Hero;
import gwentstone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

public class PlayerHero {
    /**
     * Command to be printed in JSON output file
     */
    private String command;
    /**
     * Index to be printed in JSON output file
     */
    private int playerIdx;
    /**
     * ArrayList of cards to be printed in JSON output file
     */
    private Hero deepCopyofHero;

    private ObjectNode node;

    public PlayerHero(final ActionsInput action, final StartingTheGame newgame,
                      final ObjectMapper objectMapper) {
        this.command = action.getCommand();
        this.playerIdx = action.getPlayerIdx();
        if (playerIdx == 1) {
            this.deepCopyofHero = newgame.getHeroOfPLayerOne();
        } else {
            this.deepCopyofHero = newgame.getHeroOfPlayerTwo();
        }
        node =  objectMapper.createObjectNode();
        node.put("command", command);
        node.put("playerIdx", playerIdx);
        node.putPOJO("output", deepCopyofHero);
    }

    /**
     *
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
     * @return playerIdx
     */
    public int getPlayerIdx() {
        return playerIdx;
    }

    /**
     * @param playerIdx
     */
    public void setPlayerIdx(final int playerIdx) {
        this.playerIdx = playerIdx;
    }

    /**
     * @return deepCopyofHero
     */
    public Hero getDeepCopyofHero() {
        return deepCopyofHero;
    }

    /**
     * @param deepCopyofHero
     */
    public void setDeepCopyofHero(final Hero deepCopyofHero) {
        this.deepCopyofHero = deepCopyofHero;
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
