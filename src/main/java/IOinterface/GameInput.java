package IOinterface;

import gameLogic.GameApp;

/**
 * This is the interface for input.
 * @author zaiga97
 */
public interface GameInput {
    /**
     * @return 1 for new game, 0 for exiting the menu
     */
    GameApp.MENUACTIONS getMenuInput();

    /**
     * @return the player name as {@link String}
     */
    String getPlayerName();

    /**
     * @return An array of int with the position of dices to reroll.
     * If no dices are to reroll then return and empty array
     */
    int[] getRerollIndexes();

    /**
     * @return The index of the category to score.
     */
    int getScoringIndex();
}
