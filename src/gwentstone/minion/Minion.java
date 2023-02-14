package gwentstone.minion;

import gwentstone.Ability;
import gwentstone.Card;
import com.fasterxml.jackson.annotation.JsonIgnore;
import fileio.CardInput;

import java.util.ArrayList;

public abstract class Minion  extends Card implements Ability {
    /**
     *MANA for each card
     */
    private int mana;
    /**
     * HEALTH points for each card
     */
    private int health;
    /**
     * Points each card attacks with
     */
    private int attackDamage;
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
     *Checks if card is frozen
     */
    @JsonIgnore
    private boolean isFrozen;

    @JsonIgnore
    private boolean hasAlreadyAttacked;

    @JsonIgnore
    private boolean isTank;

    /**
     * @return isFrozen
     */
    @JsonIgnore
    public boolean isFrozen() {
        return isFrozen;
    }

    /**
     * @param frozen
     */
    @JsonIgnore
    public void setFrozen(final boolean frozen) {
        isFrozen = frozen;
    }

    /**
     * @return isTank
     */
    @JsonIgnore
    public boolean isTank() {
        return isTank;
    }

    /**
     * @param tank
     */
    @JsonIgnore
    public void setTank(final boolean tank) {
        isTank = tank;
    }

    /**
     * @return hasAlreadyAttacked
     */
    @JsonIgnore
    public boolean getIfAlreadyAttacked() {
        return hasAlreadyAttacked;
    }

    /**
     * @param alreadyAttacked
     */
    @JsonIgnore
    public void setIfAlreadyAttacked(final boolean alreadyAttacked) {
        hasAlreadyAttacked = alreadyAttacked;
    }



    public Minion(final Card card) {
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.attackDamage = card.getAttackDamage();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    public Minion(final CardInput card) {
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.attackDamage = card.getAttackDamage();
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
     * Function for ability of a minion
     */
    public abstract void specialAbilityOfMinion();

}
