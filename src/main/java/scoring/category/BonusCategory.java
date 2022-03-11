package scoring.category;

import scoring.table.ScoringTable;

public class BonusCategory implements ScoreCategory{
    private final String name;
    private final ScoringTable scoringTable;
    private int score = 0;

    public BonusCategory(String name, ScoringTable scoringTable) {
        this.name = name;
        this.scoringTable = scoringTable;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateScore() {
        int sumOfUpper = scoringTable.getScoringCategory(6).getScore();
        return sumOfUpper > 63 ? 50 : 0;
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
