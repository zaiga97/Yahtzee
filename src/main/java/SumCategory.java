import java.util.Arrays;
import java.util.function.Function;

public class SumCategory implements ScoreCategory {
    private String name = "Sum";
    private int score;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateScore(int[] dicesValues) {
        return Arrays.stream(dicesValues).sum();
    }

    @Override
    public void score(int[] dicesValues) {
        score = calculateScore(dicesValues);
    }

    @Override
    public int getScore() {
        return 0;
    }
}
