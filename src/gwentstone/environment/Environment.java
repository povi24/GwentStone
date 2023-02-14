package gwentstone.environment;

import gwentstone.Ability;
import gwentstone.Card;
import gwentstone.minion.Minion;
import fileio.CardInput;

import java.util.ArrayList;

public abstract class Environment extends Card implements Ability {
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

    public Environment(final CardInput card) {
        this.mana = card.getMana();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
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

    /**
     * @param table - used to access the table of the game
     * @param affectedRow - used to specify which row is affected
     */
    public abstract void environmentAbility(ArrayList<ArrayList<Minion>> table,
                                            int affectedRow);
}
