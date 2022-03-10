import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface ScoreCategory {
    String getName();
    int calculateScore(int[] dicesValues);
}