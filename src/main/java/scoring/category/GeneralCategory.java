package scoring.category;

import java.util.function.Function;

public class GeneralCategory extends PartialCategory implements ScoreCategory{

    private final Function<int[], Integer> scoreFunction;

    public GeneralCategory(String name, Function<int[], Integer> scoreFunction) {
        super(name);
        this.scoreFunction = scoreFunction;
    }

    @Override
    public int calculateScore(int[] dicesValues) {
        return scoreFunction.apply(dicesValues);
    }
}
