import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import scoring.category.GeneralCategory;
import scoring.category.ScoreCategory;

import java.util.Arrays;
import java.util.function.Function;


public class ScoreCategoryTest {
    public Function<int[], Integer> SUMF = ints -> Arrays.stream(ints).sum();

    @Test
    public void SumCategoryTest(){
        int[] diceValues = new int[] {1,2,3,4,5};
        ScoreCategory generalCategory = new GeneralCategory(
                "GeneralTest",
                SUMF
        );
        assertEquals(15, generalCategory.calculateScore(diceValues));
        assertEquals(false, generalCategory.isScored());
        generalCategory.score(diceValues);
        assertEquals(15, generalCategory.getScore());
        assertEquals(true, generalCategory.isScored());
    }

}
