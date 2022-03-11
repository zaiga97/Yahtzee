package scoring.table;

import scoring.category.ScoreCategory;

import java.util.Arrays;

public class SumCategory implements ScoreCategory {
    private String name = "Sum";
    private int score = 0;
    private boolean scored = false;

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
