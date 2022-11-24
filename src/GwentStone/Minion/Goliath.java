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
        setTank(true);

    }
    public Goliath(CardInput card) {
        super(card);
        setTank(true);
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

    }
}
