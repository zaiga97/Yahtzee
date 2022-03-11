package scoring.table;

import scoring.category.ScoreCategory;

public interface ScoringTable {
    int getScore();
    ScoreCategory getScoringCategory(int index);
    void score(int index, int[] dicesValues);
}
