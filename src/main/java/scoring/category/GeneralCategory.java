package scoring.category;

import java.util.Arrays;
import java.util.function.Function;

public class GeneralCategory implements ScoreCategory{

    private final String name;
    private final Function<int[], Integer> scoreFunction;
    private int score = 0;
    private boolean scored = false;

    public GeneralCategory(String name, Function<int[], Integer> scoreFunction) {
        this.name = name;
        this.scoreFunction = scoreFunction;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateScore(int[] dicesValues) {
        return scoreFunction.apply(dicesValues);
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
