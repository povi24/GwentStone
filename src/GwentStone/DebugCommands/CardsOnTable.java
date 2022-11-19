package GwentStone.DebugCommands;

import GwentStone.Card;

import java.util.ArrayList;

public class CardsOnTable {
    /**
     * Command to be printed in JSON output file
     */
    private String Command;
    /**
     * ArrayList consisting of cards that are placed on the table to be printed in JSON output file
     */
    private ArrayList<Card> output;

    public CardsOnTable(String Command, ArrayList<Card> output) {
        this.Command = Command;
        this.output = output;
    }

    public String getCommand() {
        return Command;
    }

    public void setCommand(String command) {
        Command = command;
    }

    public ArrayList<Card> getOutput() {
        return output;
    }

    public void setOutput(ArrayList<Card> output) {
        this.output = output;
    }
}
