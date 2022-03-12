package scoring.table;

import scoring.category.ScoreCategory;

public interface ScoringTable {
    int getTotalScore();
    ScoreCategory getScoringCategory(int index);
    void score(int index, int[] dicesValues);
    boolean isComplete();
    int getCategoryCount();
}
