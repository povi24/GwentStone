package GwentStone.Environment;

import GwentStone.Minion.Minion;
import fileio.CardInput;

import java.util.ArrayList;

public class Winterfell extends Environment{
//    public Winterfell(int MANA, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, Description, Colors, Name);
//    }

    public Winterfell(CardInput card) {
        super(card);
    }

    @Override
    public void environmentAbility(ArrayList<ArrayList<Minion>> table,int affectedRow) {
        for (int i = 0; i < table.get(affectedRow).size(); i++) {
            table.get(affectedRow).get(i).setFrozen(true);
        }
    }

    @Override
    public void minionAbility(ArrayList<ArrayList<Minion>> table, int attackedX, int attackedY) {

    }
}
