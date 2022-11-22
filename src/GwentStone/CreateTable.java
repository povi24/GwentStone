package GwentStone;

import GwentStone.Minion.Minion;

import java.util.ArrayList;

public class CreateTable {
    private ArrayList<ArrayList<Minion>> table;

    public ArrayList<ArrayList<Minion>> getTable() {
        return table;
    }

    public void setTable(ArrayList<ArrayList<Minion>> table) {
        this.table = table;
    }

    public CreateTable() {
        table = new ArrayList<>();


        //cream masa
        for(int i = 0; i < 4; i++) {
            table.add(new ArrayList<>());
        }


    }



}
