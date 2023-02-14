package gwentstone;

import gwentstone.minion.Minion;

import java.util.ArrayList;

public interface Ability {
    /**
     *
     * @param table - used to access the table of the game
     * @param affectedRow - used to specify which row is affected
     */
    void environmentAbility(ArrayList<ArrayList<Minion>> table,
                            int affectedRow);

    /**
     *
     * @param table - used to access the table of the game
     * @param attackedX - coordinate for a card that was attacked
     * @param attackedY - coordinate for a card that was attacked
     */
    void minionAbility(ArrayList<ArrayList<Minion>> table,
                        int attackedX, int attackedY);
}
