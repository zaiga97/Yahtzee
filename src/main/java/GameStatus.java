import java.util.Arrays;

public class GameStatus {
    private final Player player;
    private Dice[] dices = new Dice[5];
    private final ScoringTable scoringTable = new DefaultScoringTable();

    public GameStatus(String playerName){
        this.player = new Player(playerName);
        for (int i = 0; i < 5; i++) {
            dices[i] = new FairDice(6);
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Dice[] getDices() {
        return dices;
    }

    public void rollAll() {
        for (var dice:dices) {
            dice.roll();
        }
    }

    public void reroll(int[] indexes) {
        for (int i:indexes) {
            dices[i].roll();
        }
    }

    public void score(int scoringIndex) {
        scoringTable.score(scoringIndex, Arrays.stream(dices).mapToInt(dice -> dice.getValue()).toArray());
    }

    public int getScore() {
        return scoringTable.getScore();
    }

    public ScoringTable getScoringTable() {
        return scoringTable;
    }
}
