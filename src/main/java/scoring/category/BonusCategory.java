package scoring.category;

import scoring.table.ScoringTable;

public class BonusCategory extends PartialCategory implements ScoreCategory{
    private final ScoringTable scoringTable;

    public BonusCategory(String name, ScoringTable scoringTable) {
        super(name);
        this.scoringTable = scoringTable;
    }

    @Override
    public int calculateScore() {
        int sumOfUpper = scoringTable.getScoringCategory(6).getScore();
        return sumOfUpper > 63 ? 50 : 0;
    }

    @Override
    public void score() {
        super.score = calculateScore();
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
