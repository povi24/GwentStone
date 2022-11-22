package GwentStone.Hero;

import fileio.CardInput;

import java.util.ArrayList;

public class EmpressThorina extends Hero{
//    public EmpressThorina(String Name, int MANA, String Description, ArrayList<String> Colors) {
//        super(Name, MANA, Description, Colors);
//    }

    public EmpressThorina (CardInput card) {
        super(card);
        setHealth(30);
    }
}
