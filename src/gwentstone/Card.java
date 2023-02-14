package gwentstone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;

public abstract class Card {

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
     * Position of a card(can be front or back)
     */
    private String position;

    /**
     * @return - returns the position of a card
     */
    @JsonIgnore
    public String getPosition() {
        return position;
    }

    /**
     * @param position
     */
    @JsonIgnore
    public void setPosition(final String position) {
        this.position = position;
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
     * @return attackDamage
     */
    public int getAttackDamage() {
        return attackDamage;
    }

    /**
     * @param attackDamage
     */
    public void setAttackDamage(final int attackDamage) {
        this.attackDamage = attackDamage;
    }

    /**
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health
     */
    public void setHealth(final int health) {
        this.health = health;
    }

    /**
     *The attack a card has
     */
    @JsonIgnore
    private int attackDamage;
    /**
     *Health points for a card
     */
    @JsonIgnore
    private int health;

}
