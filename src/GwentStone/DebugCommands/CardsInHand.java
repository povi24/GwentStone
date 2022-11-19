package GwentStone.DebugCommands;

import GwentStone.Card;

import java.util.ArrayList;

public class CardsInHand {
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
    private ArrayList<Card> output;

    public CardsInHand(String Command, int PLayerIdx, ArrayList<Card> output) {
        this.Command = Command;
        this.PlayerIdx = PLayerIdx;
        this.output = output;
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

    public ArrayList<Card> getOutput() {
        return output;
    }

    public void setOutput(ArrayList<Card> output) {
        this.output = output;
    }
}
