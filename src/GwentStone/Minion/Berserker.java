package GwentStone.Minion;

import fileio.CardInput;

import java.util.ArrayList;

public class Berserker extends Minion {


//    public Berserker(int MANA, int HEALTH, int AttackDamage, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, HEALTH, AttackDamage, Description, Colors, Name);
//        isFrozen = false;
//        isTank = false;
//    }

    public Berserker(CardInput card) {
        super(card);
    }

    @Override
    public void SpecialAbilityOfMinion() {

    }
}
