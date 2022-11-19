package GwentStone.Hero;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public abstract class Hero extends Card {
    /**
     *MANA for each card
     */
    public int mana;
    /**
     * Description for each card
     */
    public String description;
    /**
     * Colors that make up the design of a card
     */
    public ArrayList<String> colors;
    /**
     * Name of each card
     */
    public String name;
    /**
     * HEALTH points for each card
     */
    public final int health = 30;


//    public Hero(String Name,int  MANA, String Description, ArrayList<String> Colors) {
//        this.name = Name;
//        this.mana = MANA;
//        this.description = Description;
//        this.colors = Colors;
//
//    }

    public Hero (CardInput card) {
        this.mana = card.getMana();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getColors() {
        return colors;
    }

    public void setColors(ArrayList<String> colors) {
        this.colors = colors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
