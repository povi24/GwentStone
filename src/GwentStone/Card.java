package GwentStone;

import fileio.CardInput;

import java.util.ArrayList;

public abstract class Card {

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

}
