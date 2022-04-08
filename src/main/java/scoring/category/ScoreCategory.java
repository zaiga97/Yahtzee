package scoring.category;

/**
 * This interface is the base for any scoring category.
 * Some methods have a default implementation in case a derived class will not need them.
 * @author zaiga97
 */

public interface ScoreCategory {
    /**
     * @return The name of the category.
     */
    String getName();

    /**
     * This function will calculate the score of the category based on an array of dices values.
     * @param dicesValues The value of the dices.
     * @return The score of the dice values in this category.
     */
    default int calculateScore(int[] dicesValues) {
        return 0;
    }

    /**
     * This function will calculate the score of the category. It will be used for categories where score
     * does not depend on the value of the dices.
     * @return The score of this category.
     */
    default int calculateScore() {
        return 0;
    }

    /**
     * Score the category with the dices values provided.
     * @param dicesValues The value of the dices.
     */
    default void score(int[] dicesValues) {}

    /**
     * Score the category. This is to be used when category score does not depend on the dices values.
     */
    default void score() {}

    /**
     * @return The current score in this category.
     */
    int getScore();

    /**
     * @return True if the category has already been scored once. Otherwise, False.
     * If the category can't be manually scored then this should always return true.
     */
    boolean isScored();
}