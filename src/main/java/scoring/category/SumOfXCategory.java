package scoring.category;

import java.util.Arrays;

public class SumOfXCategory implements ScoreCategory {
    private String name;
    private final int X;
    private int score = 0;
    private boolean scored = false;

    public SumOfXCategory(int x) {
        X = x;
        name = "# " + X;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateScore(int[] dicesValues) {
        return Arrays.stream(dicesValues).filter(i -> i == X).sum();
    }

    @Override
    public void score(int[] dicesValues) {
        score = calculateScore(dicesValues);
        scored = true;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean isScored() {
        return scored;
    }
}