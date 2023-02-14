package gwentstone.minion;

import gwentstone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class TheRipper extends Minion {


    public TheRipper(final Card card) {
        super(card);

    }
    public TheRipper(final CardInput card) {
        super(card);
        setPosition("front");

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
        table.get(attackedX).get(attackedY).setAttackDamage(table.get(attackedX)
                                        .get(attackedY).getAttackDamage() - 2);
        if (table.get(attackedX).get(attackedY).getAttackDamage() < 0) {
            table.get(attackedX).get(attackedY).setAttackDamage(0);
        }
    }
}
