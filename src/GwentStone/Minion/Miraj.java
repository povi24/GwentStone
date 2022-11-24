package GwentStone.Minion;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Miraj extends Minion {
    public Miraj(Card card) {
        super(card);

    }
    public Miraj(CardInput card) {
        super(card);
        setPosition("front");

    }

    @Override
    public void SpecialAbilityOfMinion() {

    }

    @Override
    public void environmentAbility(ArrayList<ArrayList<Minion>> table, int affectedRow) {

    }

    @Override
    public void minionAbility(ArrayList<ArrayList<Minion>> table, int attackedX, int attackedY) {
        int aux = table.get(attackedX).get(attackedY).getHealth();
        table.get(attackedX).get(attackedY).setHealth(getHealth());
        setHealth(aux);
    }
}
