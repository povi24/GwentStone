package GwentStone.Minion;

import GwentStone.Ability;
import GwentStone.Card;
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

    @JsonIgnore
    public boolean isFrozen() {
        return isFrozen;
    }

    @JsonIgnore
    public void setFrozen(boolean frozen) {
        isFrozen = frozen;
    }

    @JsonIgnore
    public boolean isTank() {
        return isTank;
    }

    @JsonIgnore
    public void setTank(boolean tank) {
        isTank = tank;
    }

    @JsonIgnore
    public boolean getIfAlreadyAttacked() {
        return hasAlreadyAttacked;
    }

    @JsonIgnore
    public void setIfAlreadyAttacked(boolean alreadyAttacked) {
        hasAlreadyAttacked = alreadyAttacked;
    }



    public Minion(Card card) {
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.attackDamage = card.getAttackDamage();
        this.description = card.getDescription();
        this.colors = card.getColors();
        this.name = card.getName();
    }

    public Minion(CardInput card) {
        this.mana = card.getMana();
        this.health = card.getHealth();
        this.attackDamage = card.getAttackDamage();
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

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
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

    public abstract void SpecialAbilityOfMinion();

}
