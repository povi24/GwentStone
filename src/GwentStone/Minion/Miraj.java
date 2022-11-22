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
}
