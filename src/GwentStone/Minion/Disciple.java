package GwentStone.Minion;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Disciple extends Minion{

//    public Disciple(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = false;
//    }
public Disciple(Card card) {
    super(card);

}
    public Disciple(CardInput card) {
        super(card);
        setPosition("back");

    }
    @Override
    public void SpecialAbilityOfMinion() {

    }

}
