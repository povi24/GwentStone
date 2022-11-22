package GwentStone.Minion;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class TheRipper extends Minion{

//    public TheRipper(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = false;
//    }

    public TheRipper(Card card) {
        super(card);

    }
    public TheRipper(CardInput card) {
        super(card);
        setPosition("front");

    }
    @Override
    public void SpecialAbilityOfMinion() {

    }
}
