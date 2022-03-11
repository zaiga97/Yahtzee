package scoring.category;

import scoring.table.ScoringTable;

public class SumOfUpperCategory implements ScoreCategory{
    private final String name;
    private final ScoringTable scoringTable;
    private int score = 0;

    public SumOfUpperCategory(String name, ScoringTable scoringTable) {
        this.name = name;
        this.scoringTable = scoringTable;
    }

    @Override
    public String getName() {
        return name;
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
