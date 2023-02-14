package gwentstone.minion;

import gwentstone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Disciple extends Minion {

public Disciple(final Card card) {
    super(card);

}
    public Disciple(final CardInput card) {
        super(card);
        setPosition("back");

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
    table.get(attackedX).get(attackedY).setHealth(table.get(attackedX)
                                    .get(attackedY).getHealth() + 2);
    }
}
