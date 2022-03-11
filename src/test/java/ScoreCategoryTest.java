import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import scoring.category.GeneralCategory;
import scoring.category.ScoreCategory;
import scoring.category.SumCategory;
import scoring.category.SumOfXCategory;

import java.util.Arrays;


public class ScoreCategoryTest {

    @Test
    public void SumCategoryTest(){
        int[] diceValues = new int[] {1,2,3,4,5};
        ScoreCategory sumCategory = new SumCategory();
        assertEquals(15, sumCategory.calculateScore(diceValues));

        assertEquals(false, sumCategory.isScored());
        sumCategory.score(diceValues);
        assertEquals(15, sumCategory.getScore());
        assertEquals(true, sumCategory.isScored());
    }

    @Test
    public void SumOf1CategoryTest(){
        int[] diceValues = new int[] {1,2,3,4,5};
        ScoreCategory sumOf1Category = new SumOfXCategory(1);
        assertEquals(1, sumOf1Category.calculateScore(diceValues));
        assertEquals(false, sumOf1Category.isScored());
        sumOf1Category.score(diceValues);
        assertEquals(1, sumOf1Category.getScore());
        assertEquals(true, sumOf1Category.isScored());
    }

    @Test
    public void SumOf4CategoryTest(){
        int[] diceValues = new int[] {1,4,3,4,4};
        ScoreCategory sumOf4Category = new SumOfXCategory(4);
        assertEquals(4*3, sumOf4Category.calculateScore(diceValues));
        assertEquals(false, sumOf4Category.isScored());
        sumOf4Category.score(diceValues);
        assertEquals(4*3, sumOf4Category.getScore());
        assertEquals(true, sumOf4Category.isScored());
    }

    @Test
    public void generalCategoryTest(){
        int[] diceValues = new int[] {1,2,3,4,5};
        ScoreCategory generalCategory = new GeneralCategory(
                "GeneralTest",
                ints -> Arrays.stream(ints).sum()
        );
        assertEquals(15, generalCategory.calculateScore(diceValues));
        assertEquals(false, generalCategory.isScored());
        generalCategory.score(diceValues);
        assertEquals(15, generalCategory.getScore());
        assertEquals(true, generalCategory.isScored());
    }


}
