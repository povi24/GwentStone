package GwentStone.Minion;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Goliath extends Minion{
//    public Goliath(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = true;
//    }

    public Goliath(Card card) {
        super(card);

    }
    public Goliath(CardInput card) {
        super(card);
        setPosition("front");

    }

    @Override
    public void SpecialAbilityOfMinion() {

    }
}