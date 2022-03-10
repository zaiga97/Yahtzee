import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ScoreCategoryTest {
    @Test
    public void SumCategoryTest(){
        ScoreCategory sumCategory = new SumCategory();
        assertEquals(15, sumCategory.calculateScore(new int[] {1,2,3,4,5}));
    }

}
