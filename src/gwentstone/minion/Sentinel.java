package gwentstone.minion;

import gwentstone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Sentinel extends Minion {

public Sentinel(final Card card) {
    super(card);

}
    public Sentinel(final CardInput card) {
        super(card);
        setPosition("back");

    }

    public Sentinel(final Minion card) {
        super(card);
    }
    @Override
    public void specialAbilityOfMinion() {

    }

    @Override
    public void environmentAbility(final ArrayList<ArrayList<Minion>> table,
                                   final int affectedRow) {

    }

    @Override
    public void minionAbility(final ArrayList<ArrayList<Minion>> table,
                              final int attackedX, final int attackedY) {

    }
}
