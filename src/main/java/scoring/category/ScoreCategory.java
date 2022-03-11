package scoring.category;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

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