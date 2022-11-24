package GwentStone;

import GwentStone.GameplayCommands.CardUsesAbility;
import GwentStone.Minion.Minion;

import java.util.ArrayList;

public interface Ability {
    void environmentAbility(ArrayList<ArrayList<Minion>> table, int affectedRow);
    void minionAbility(ArrayList<ArrayList<Minion>> table, int attackedX, int attackedY);
;
}
