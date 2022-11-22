package GwentStone.Environment;

import GwentStone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public abstract class Environment extends Card {
    /**
     *MANA for each card
     */
    private int mana;
    /**
     * Description for each card
     */
    private String description;
    /**
     * Colors that make up the design of a card
     */
    private ArrayList<String> colors;
    /**
     * Name of each card
     */
    private String name;

//    public Environment(int MANA, String Description, ArrayList<String> Colors, String Name) {
//        this.mana = MANA;
//        this.description = Description;
//        this.colors = Colors;
//        this.name = Name;
//    }
    public Environment(CardInput card) {
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
