package GwentStone.Minion;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public class Sentinel extends Minion{
//    public Sentinel(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = false;
//    }
public Sentinel(Card card) {
    super(card);

}
    public Sentinel(CardInput card) {
        super(card);
        setPosition("back");

    }
    @Override
    public void SpecialAbilityOfMinion() {

    }
}
