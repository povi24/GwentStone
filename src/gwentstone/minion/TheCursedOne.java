package gwentstone.minion;

import gwentstone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class TheCursedOne extends Minion {

    public TheCursedOne(final Card card) {
        super(card);

    }
    public TheCursedOne(final CardInput card) {
        super(card);
        setPosition("back");
    }
    @Override
    public void specialAbilityOfMinion() {

    }

    /**
     * @param table - used to access the table of the game
     * @param affectedRow - used to specify which row is affected
     */
    @Override
    public void environmentAbility(final ArrayList<ArrayList<Minion>> table,
                                   final int affectedRow) {

    }

    /**
     * @param table - used to access the table of the game
     * @param attackedX - coordinate for a card that was attacked
     * @param attackedY - coordinate for a card that was attacked
     */
    @Override
    public void minionAbility(final ArrayList<ArrayList<Minion>> table,
                              final int attackedX, final int attackedY) {
        int aux = table.get(attackedX).get(attackedY).getHealth();
        table.get(attackedX).get(attackedY).setHealth(table.get(attackedX)
                                        .get(attackedY).getAttackDamage());
        table.get(attackedX).get(attackedY).setAttackDamage(aux);
    }
}
