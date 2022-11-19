package GwentStone.Environment;

import fileio.CardInput;

import java.util.ArrayList;

public class Firestorm extends Environment{
//    public Firestorm(int MANA, String Description, ArrayList<String> Colors, String Name) {
//        super(MANA, Description, Colors, Name);
//    }

    public Firestorm(CardInput card) {
        super(card);
    }
}
