package gameLogic;

import scoring.table.DefaultScoringTable;
import scoring.table.ScoringTable;

import java.util.Arrays;

public class StandardGameStatus implements GameStatus {
    
    private static final int NDICES = 5;
    private static final int NFACES = 6;
    
    private final Player player;
    private final Dice[] dices = new Dice[NDICES];
    private final ScoringTable scoringTable = new DefaultScoringTable();

    public StandardGameStatus(String playerName){
        this.player = new Player(playerName);
        for (int i = 0; i < NDICES; i++) {
            dices[i] = new FairDice(NFACES);
        }
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public Dice[] getDices() {
        return dices;
    }

    @Override
    public void rollAll() {
        for (var dice:dices) {
            dice.roll();
        }
    }

    @Override
    public void reroll(int[] indexes) {
        for (int i:indexes) {
            dices[i].roll();
        }
    }

    @Override
    public void score(int scoringIndex) {
        scoringTable.score(scoringIndex, Arrays.stream(dices).mapToInt(Dice::getValue).toArray());
    }

    @Override
    public int getScore() {
        return scoringTable.getTotalScore();
    }

    @Override
    public ScoringTable getScoringTable() {
        return scoringTable;
    }

    @Override
    public boolean isComplete() {
        return scoringTable.isComplete();
    }

    @Override
    public boolean isLegalScoring(int scoringIndex) {
        // check if category is in the bound
        if (scoringIndex<0 || scoringIndex >= scoringTable.getCategoryCount()) return false;
        // check the scoringCategory is not  scored already
        return !scoringTable.getScoringCategory(scoringIndex).isScored();
    }
}
