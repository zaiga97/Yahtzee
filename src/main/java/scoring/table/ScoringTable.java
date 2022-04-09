package scoring.table;

import scoring.category.ScoreCategory;

/**
 *  General interface for a scoring table.
 * @author zaiga97
 */
public interface ScoringTable {

    /**
     * @return the current total score.
     */
    int getTotalScore();

    /**
     * @param index the index of the category
     * @return the category at that integer position.
     */
    ScoreCategory getScoringCategory(int index);

    /**
     * @param index category index where to score
     * @param dicesValues values of the dices
     */
    void score(int index, int[] dicesValues);

    /**
     * Check if the table has been completed yet.
     * @return True if completed.
     */
    boolean isComplete();

    /**
     * @return Number of categories in the table.
     */
    int getCategoryCount();
}
