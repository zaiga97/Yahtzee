package scoring.table;

import java.util.Arrays;
import scoring.category.ScoreCategory;

public class DefaultScoringTable implements ScoringTable {
    ScoreCategory[] scoringList = new ScoreCategory[3];

    public DefaultScoringTable(){
        for (int i = 0; i < 3; i++) {
            scoringList[i] = new SumCategory();
        }
    }

    @Override
    public int getScore() {
        return Arrays.stream(scoringList).mapToInt(scoreCategory -> scoreCategory.getScore()).sum();
    }

    @Override
    public void score(int index, int[] dicesValues) {
        scoringList[index].score(dicesValues);
    }
}
