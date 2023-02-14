package gwentstone.minion;

import gwentstone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Berserker extends Minion {

public Berserker(final Card card) {
    super(card);

}
    public Berserker(final CardInput card) {
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

    @Override
    public void minionAbility(final ArrayList<ArrayList<Minion>> table, final int attackedX,
                              final int attackedY) {

    }
}
