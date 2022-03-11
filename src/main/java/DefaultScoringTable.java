public class DefaultScoringTable implements ScoringTable {
    ScoreCategory[] scoringList = new ScoreCategory[3];

    public DefaultScoringTable(){
        for (int i = 0; i < 3; i++) {
            scoringList[i] = new SumCategory();
        }
    }

    @Override
    public int getScore() {
        return 0;
    }

    @Override
    public void score(int index, int[] dicesValues) {
        scoringList[index].score(dicesValues);
    }
}
