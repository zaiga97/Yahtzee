import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCategoryTest {

    @Test
    public void SumCategoryFunctionTest(){
        int[] diceValues = new int[] {1,2,3,4,5};
        ScoreCategory sumCategory = new SumCategory();
        assertEquals(15, sumCategory.calculateScore(diceValues));

        assertEquals(false, sumCategory.isScored());
        sumCategory.score(diceValues);
        assertEquals(15, sumCategory.getScore());
        assertEquals(true, sumCategory.isScored());
    }



}
