package GwentStone.Minion;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class TheCursedOne extends Minion{
//    public TheCursedOne(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = false;
//    }

    public TheCursedOne(Card card) {
        super(card);

    }
    public TheCursedOne(CardInput card) {
        super(card);
        setPosition("back");
    }
    @Override
    public void SpecialAbilityOfMinion() {

    }
}