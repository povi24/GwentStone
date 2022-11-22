package GwentStone.Hero;

import fileio.CardInput;

import java.util.ArrayList;

public class KIngMudface extends Hero {
//    public KIngMudface(String Name, int MANA, String Description, ArrayList<String> Colors) {
//        super(Name, MANA, Description, Colors);
//    }
    public KIngMudface (CardInput card) {
        super(card);
        setHealth(30);
    }

}
