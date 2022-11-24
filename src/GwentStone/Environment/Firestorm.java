package GwentStone.Environment;

import GwentStone.Minion.Minion;
import fileio.CardInput;

import java.util.ArrayList;

public class Firestorm extends Environment{
//    public Firestorm(int MANA, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, Description, Colors, Name);
//    }

    public Firestorm(CardInput card) {
        super(card);
    }

    @Override
    public void environmentAbility(ArrayList<ArrayList<Minion>> table,int affectedRow) {
        for (int i = 0; i < table.get(affectedRow).size(); i++) {
            table.get(affectedRow).get(i).setHealth(table.get(affectedRow).get(i).getHealth() - 1);
            if (table.get(affectedRow).get(i).getHealth() == 0) {
                table.get(affectedRow).remove(i);
                i--;
            }
        }

    }

    @Override
    public void minionAbility(ArrayList<ArrayList<Minion>> table, int attackedX, int attackedY) {

    }
}
