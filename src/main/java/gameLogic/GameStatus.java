package gameLogic;

import scoring.table.ScoringTable;

/**
 * This is the status of the game and keeps track of the current situation.
 * @author zaiga97
 */

public interface GameStatus {
    /**
     * @return The number of dices used in the game.
     */
    int getNumberOfDices();

    /**
     * @return Who is playing the game.
     */
    Player getPlayer();

    /**
     * @return The dices in the game.
     */
    Dice[] getDices();

    /**
     * Roll all dices.
     */
    void rollAll();

    /**
     * Reroll only the dices at the position of the indexes passed.
     * @param indexes
     */
    void reroll(int[] indexes);

    /**
     * Score at the category index passed.
     * @param scoringIndex
     */
    void score(int scoringIndex);

    /**
     * @return The current score.
     */
    int getScore();

    /**
     * @return The Array of {@link scoring.category.ScoreCategory} containing the scores.
     */
    ScoringTable getScoringTable();

    /**
     * @return True if the game is complete (All category are scored).
     */
    boolean isComplete();

    /**
     * Check if is legal scoring on the category at index.
     * @param scoringIndex The index of the category we want to score.
     * @return True if is legal to score at scoringIndex.
     */
    boolean isLegalScoring(int scoringIndex);
}
