package gwentstone.minion;

import gwentstone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Warden extends Minion {

    public Warden(final Card card) {
        super(card);
        setTank(true);
    }
    public Warden(final CardInput card) {
        super(card);
        setTank(true);
        setPosition("front");

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
