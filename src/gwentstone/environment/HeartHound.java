package gwentstone.environment;

import gwentstone.minion.Minion;
import fileio.CardInput;

import java.util.ArrayList;

public class HeartHound extends Environment {
    public HeartHound(final CardInput card) {
        super(card);
    }

    /**
     * @param table - used to access the table of the game
     * @param affectedRow - used to specify which row is affected
     */
    @Override
    public void environmentAbility(final ArrayList<ArrayList<Minion>> table,
                                   final int affectedRow) {
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

    /**
     * @param table - used to access the table of the game
     * @param attackedX - coordinate for a card that was attacked
     * @param attackedY - coordinate for a card that was attacked
     */
    @Override
    public void minionAbility(final ArrayList<ArrayList<Minion>> table, final int attackedX,
                              final int attackedY) {

    }
}
