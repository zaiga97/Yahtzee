package IOinterface;

import gameLogic.GameApp;
import scoring.table.ScoringTable;

/**
 * This is the interface for input.
 * @author zaiga97
 */
public interface GameInput {
    /**
     * @return the menu action to perform.
     */
    GameApp.MENUACTIONS getMenuInput();

    /**
     * @return the player name as {@link String}
     */
    String getPlayerName();

    /**
     * @return An array of int with the position of dices to reroll.
     * If no dices are to reroll then return and empty array
     * @param numberOfDices Number of active dices.
     */
    int[] getRerollIndexes(int numberOfDices);

    /**
     * @return The index of the category to score.
     */
    int getScoringIndex();
}
