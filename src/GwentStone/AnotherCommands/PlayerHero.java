package GwentStone.AnotherCommands;

import GwentStone.Card;
import GwentStone.Hero.Hero;
import GwentStone.StartingTheGame;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fileio.ActionsInput;

import java.util.ArrayList;

public class PlayerHero {
    /**
     * Command to be printed in JSON output file
     */
    private String Command;
    /**
     * Index to be printed in JSON output file
     */
    private int PlayerIdx;
    /**
     * ArrayList of cards to be printed in JSON output file
     */
    private Hero deepCopyofHero;

    //creez un nod pentru actiunea din clasa asta pentru a afisa la output
    private ObjectNode node;

    public PlayerHero(ActionsInput action, StartingTheGame newgame, ObjectMapper objectMapper) {
        this.Command = action.getCommand();
        this.PlayerIdx = action.getPlayerIdx();
        if (PlayerIdx == 1) {
            //deep copy la obiectul pe care il bag in nod
            this.deepCopyofHero = newgame.getHeroOfPLayerOne();
        } else {
            this.deepCopyofHero = newgame.getHeroOfPlayerTwo();
        }
        node =  objectMapper.createObjectNode();
        node.put("command", Command);
        node.put("playerIdx", PlayerIdx);
        node.putPOJO("output", deepCopyofHero);
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public int getPlayerIdx() {
        return PlayerIdx;
    }

    public void setPlayerIdx(int playerIdx) {
        PlayerIdx = playerIdx;
    }

    public Hero getDeepCopyofHero() {
        return deepCopyofHero;
    }

    public void setDeepCopyofHero(Hero deepCopyofHero) {
        this.deepCopyofHero = deepCopyofHero;
    }

    public ObjectNode getNode() {
        return node;
    }

    public void setNode(ObjectNode node) {
        this.node = node;
    }
}
