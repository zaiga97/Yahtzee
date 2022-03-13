package scoring.category;

import java.util.function.Function;

/**
 * This is a general implementation of a {@link ScoreCategory}.
 * It can be used for all the category that score based on dice values.
 * @author zaiga97
 */

public class GeneralCategory extends PartialCategory implements ScoreCategory{

    private final Function<int[], Integer> scoreFunction;

    /**
     * @param name Name of the category
     * @param scoreFunction The function that provides the scoring of the category.
     */
    public GeneralCategory(String name, Function<int[], Integer> scoreFunction) {
        super(name);
        this.scoreFunction = scoreFunction;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int calculateScore(int[] dicesValues) {
        return scoreFunction.apply(dicesValues);
    }
}
