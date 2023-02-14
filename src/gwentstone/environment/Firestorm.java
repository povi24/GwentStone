package gwentstone.environment;

import gwentstone.minion.Minion;
import fileio.CardInput;

import java.util.ArrayList;

public class Firestorm extends Environment {

    /**
     * @param card
     */
    public Firestorm(final CardInput card) {
        super(card);
    }

    /**
     * @param table - used to access the table of the game
     * @param affectedRow - used to specify which row is affected
     */
    @Override
    public void environmentAbility(final ArrayList<ArrayList<Minion>> table,
                                   final int affectedRow) {
        for (int i = 0; i < table.get(affectedRow).size(); i++) {
            table.get(affectedRow).get(i).setHealth(table.get(affectedRow).get(i).getHealth() - 1);
            if (table.get(affectedRow).get(i).getHealth() == 0) {
                table.get(affectedRow).remove(i);
                i--;
            }
        }

    }

    /**
     *
     * @param table - used to access the table of the game
     * @param attackedX - coordinate for a card that was attacked
     * @param attackedY - coordinate for a card that was attacked
     */
    @Override
    public void minionAbility(final ArrayList<ArrayList<Minion>> table, final int attackedX,
                              final int attackedY) {

    }
}
