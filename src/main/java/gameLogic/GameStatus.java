package gameLogic;

import scoring.table.ScoringTable;

public interface GameStatus {
    Player getPlayer();
    Dice[] getDices();
    void rollAll();
    void reroll(int[] indexes);
    void score(int scoringIndex);
    int getScore();
    ScoringTable getScoringTable();
    boolean isComplete();
    boolean isLegalScoring(int scoringIndex);
}
