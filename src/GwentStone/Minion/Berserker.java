package GwentStone.Minion;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Berserker extends Minion {


//    public Berserker(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = false;
//    }
public Berserker(Card card) {
    super(card);

}
    public Berserker(CardInput card) {
        super(card);
        setPosition("back");
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
