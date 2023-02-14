package gwentstone;

import gwentstone.minion.Minion;

import java.util.ArrayList;

/**
 * Here we create the table, where each row is an array of Minions
 * because only Minions can be placed on the table
 */
public class CreateTable {
    private ArrayList<ArrayList<Minion>> table;

    public CreateTable() {
        table = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            table.add(new ArrayList<>());
        }
    }
    /**
     * @return table
     */
    public ArrayList<ArrayList<Minion>> getTable() {
        return table;
    }
    /**
     * @param table
     */
    public void setTable(final ArrayList<ArrayList<Minion>> table) {
        this.table = table;
    }



}
