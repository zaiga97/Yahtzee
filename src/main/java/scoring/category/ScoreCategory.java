package scoring.category;

public interface ScoreCategory {
    String getName();
    default int calculateScore(int[] dicesValues) {
        return 0;
    };
    default int calculateScore() {
        return 0;
    };
    default void score(int[] dicesValues) {};
    default void score() {};

    int getScore();
    boolean isScored();
}