package GwentStone.Minion;

import fileio.CardInput;

import java.util.ArrayList;

public class Warden extends Minion{
//    public Warden(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = true;
//    }

    public Warden(CardInput card) {
        super(card);
    }
    @Override
    public void SpecialAbilityOfMinion() {

    }
}
