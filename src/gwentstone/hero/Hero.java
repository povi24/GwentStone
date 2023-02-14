package gwentstone.hero;

import gwentstone.Card;
import fileio.CardInput;

import java.util.ArrayList;

public abstract class Hero extends Card {
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
    /**
     * HEALTH points for each card
     */
    private int health;

    public Hero(final CardInput card) {
        this.mana = card.getMana();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
        this.health = 30;
    }

    /**
     * @return mana
     */
    public int getMana() {
        return mana;
    }

    /**
     * @param mana
     */
    public void setMana(final int mana) {
        this.mana = mana;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return colors
     */
    public ArrayList<String> getColors() {
        return colors;
    }

    /**
     * @param colors
     */
    public void setColors(final ArrayList<String> colors) {
        this.colors = colors;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }


}
