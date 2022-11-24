package GwentStone.Environment;

import GwentStone.Minion.Minion;
import fileio.CardInput;

import java.util.ArrayList;

public class HeartHound extends Environment {
//    public HeartHound(int MANA, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, Description, Colors, Name);
//    }

    public HeartHound(CardInput card) {
        super(card);
    }

    @Override
    public void environmentAbility(ArrayList<ArrayList<Minion>> table, int affectedRow) {
        int maxHealthCardIdx = 0;
        for (int i = 0; i < table.get(affectedRow).size(); i++) {
            int maxHealth = 0;
            if (table.get(affectedRow).get(i).getHealth() > maxHealth) {
                maxHealth = table.get(affectedRow).get(i).getHealth();
                maxHealthCardIdx = i;
            }
        }
        table.get(3 - affectedRow).add(table.get(affectedRow).get(maxHealthCardIdx));
        table.get(affectedRow).remove(maxHealthCardIdx);
    }

    @Override
    public void minionAbility(ArrayList<ArrayList<Minion>> table, int attackedX, int attackedY) {

    }
}
