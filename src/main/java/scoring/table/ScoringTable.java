package scoring.table;

public interface ScoringTable {
    int getScore();
    void score(int index, int[] dicesValues);
}
