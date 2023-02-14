package gwentstone.minion;

import gwentstone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Miraj extends Minion {
    public Miraj(final Card card) {
        super(card);

    }
    public Miraj(final CardInput card) {
        super(card);
        setPosition("front");

    }

    @Override
    public void specialAbilityOfMinion() {

    }

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
        table.get(attackedX).get(attackedY).setHealth(getHealth());
        setHealth(aux);
    }
}
