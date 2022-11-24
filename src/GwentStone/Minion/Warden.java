package GwentStone.Minion;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Warden extends Minion{
//    public Warden(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = true;
//    }

    public Warden(Card card) {
        super(card);
        setTank(true);
    }
    public Warden(CardInput card) {
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
