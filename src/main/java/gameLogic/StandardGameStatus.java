package gameLogic;

import scoring.table.DefaultScoringTable;
import scoring.table.ScoringTable;

import java.util.Arrays;

/**
 * This class implement a standard game of Yahtzee!
 * The game will be played using 5 dices with 6 faces each.
 * It also contains the {@link ScoringTable} with the current scores.
 */

public class StandardGameStatus implements GameStatus {
    
    private static final int NDICES = 5;
    private static final int NFACES = 6;
    
    private final Player player;
    private final Dice[] dices = new Dice[NDICES];
    private final ScoringTable scoringTable = new DefaultScoringTable();

    /**
     * @param playerName Name of the player playing the game.
     */
    public StandardGameStatus(String playerName){
        this.player = new Player(playerName);
        for (int i = 0; i < NDICES; i++) {
            dices[i] = new FairDice(NFACES);
        }
    }

    /**
     * @return The player playing the game.
     */
    @Override
    public Player getPlayer() {
        return player;
    }

    /**
     * @return the current dices
     */
    @Override
    public Dice[] getDices() {
        return dices;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void rollAll() {
        for (var dice:dices) {
            dice.roll();
        }
    }

    /**
     * {@inheritDoc}
     * @param indexes
     */
    @Override
    public void reroll(int[] indexes) {
        for (int i:indexes) {
            dices[i].roll();
        }
    }

    /**
     * {@inheritDoc}
     * @param scoringIndex
     */
    @Override
    public void score(int scoringIndex) {
        scoringTable.score(scoringIndex, Arrays.stream(dices).mapToInt(Dice::getValue).toArray());
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public int getScore() {
        return scoringTable.getTotalScore();
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public ScoringTable getScoringTable() {
        return scoringTable;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public boolean isComplete() {
        return scoringTable.isComplete();
    }

    /**
     * {@inheritDoc}
     * Is legal to score only if it is not already scored.
     */
    @Override
    public boolean isLegalScoring(int scoringIndex) {
        // check if category is in the bound
        if (scoringIndex<0 || scoringIndex >= scoringTable.getCategoryCount()) return false;
        // check the scoringCategory is not  scored already
        return !scoringTable.getScoringCategory(scoringIndex).isScored();
    }
}
