package GwentStone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import fileio.CardInput;

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
    private String position;

    @JsonIgnore
    public String getPosition() {
        return position;
    }
    @JsonIgnore
    public void setPosition(String position) {
        this.position = position;
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

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @JsonIgnore
    public int attackDamage;

    @JsonIgnore
    public int health;

}
