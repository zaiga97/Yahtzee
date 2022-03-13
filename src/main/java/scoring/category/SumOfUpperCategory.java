package scoring.category;

import scoring.table.ScoringTable;

/**
 * This is a special category for calculating the score of the upper part of the table.
 * @author zaiga97
 */

public class SumOfUpperCategory extends PartialCategory implements ScoreCategory{
    private final ScoringTable scoringTable;

    public SumOfUpperCategory(String name, ScoringTable scoringTable) {
        super(name);
        this.scoringTable = scoringTable;
    }

    @Override
    public int calculateScore() {
        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += scoringTable.getScoringCategory(i).getScore();
        }
        return sum;
    }

    @Override
    public void score() {
        score = calculateScore();
    }

    @Override
    public int getScore() {
        score();
        return score;
    }

    @Override
    public boolean isScored() {
        return true;
    }
}
