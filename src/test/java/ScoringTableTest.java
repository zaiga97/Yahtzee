import org.junit.jupiter.api.Test;
import scoring.table.DefaultScoringTable;
import scoring.table.ScoringTable;

import static org.junit.jupiter.api.Assertions.*;

public class ScoringTableTest {
    ScoringTable scoringTable = new DefaultScoringTable();

    @Test
    public void upperScoreTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(0, new int[]{1,2,3,4,5});
        assertEquals(1, scoringTable.getTotalScore());

        scoringTable.score(0, new int[]{2,2,2,2,2});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(5, new int[]{6,6,6,6,5});
        assertEquals(24, scoringTable.getTotalScore());

        scoringTable.score(1, new int[]{2,2,2,4,5});
        assertEquals(30, scoringTable.getTotalScore());

        scoringTable.score(4, new int[]{5,5,5,5,5});
        assertEquals(55, scoringTable.getTotalScore());

        scoringTable.score(3, new int[]{4,4,4,5,5});
        assertEquals(67 + 50, scoringTable.getTotalScore()); //We activated the bonus
    }

    @Test
    public void coupleTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(8, new int[]{1,2,3,4,5});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(8, new int[]{1,1,3,4,5});
        assertEquals(2, scoringTable.getTotalScore());

        scoringTable.score(8, new int[]{1,1,3,5,5});
        assertEquals(10, scoringTable.getTotalScore());

        scoringTable.score(8, new int[]{1,1,6,6,6});
        assertEquals(12, scoringTable.getTotalScore());
    }

    @Test
    public void doubleCoupleTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(9, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(9, new int[]{1,1,3,3,5});
        assertEquals(8, scoringTable.getTotalScore());

        scoringTable.score(9, new int[]{1,1,3,5,5});
        assertEquals(12, scoringTable.getTotalScore());

        scoringTable.score(9, new int[]{1,1,6,6,6});
        assertEquals(14, scoringTable.getTotalScore());
    }

    @Test
    public void trisTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(10, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(10, new int[]{1,1,3,3,3});
        assertEquals(9, scoringTable.getTotalScore());

        scoringTable.score(10, new int[]{1,5,5,5,5});
        assertEquals(15, scoringTable.getTotalScore());

        scoringTable.score(10, new int[]{1,1,6,6,6});
        assertEquals(18, scoringTable.getTotalScore());
    }

    @Test
    public void pokerTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(11, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(11, new int[]{1,3,3,3,3});
        assertEquals(12, scoringTable.getTotalScore());

        scoringTable.score(11, new int[]{1,5,5,5,5});
        assertEquals(20, scoringTable.getTotalScore());

        scoringTable.score(11, new int[]{1,1,6,6,6});
        assertEquals(0, scoringTable.getTotalScore());
    }

    @Test
    public void smallScaleTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(12, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(12, new int[]{1,2,3,4,5});
        assertEquals(15, scoringTable.getTotalScore());

        scoringTable.score(12, new int[]{2,3,4,5,6});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(12, new int[]{5,3,2,1,4});
        assertEquals(15, scoringTable.getTotalScore());
    }

    @Test
    public void bigScaleTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(13, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(13, new int[]{2,3,4,5,6});
        assertEquals(20, scoringTable.getTotalScore());

        scoringTable.score(13, new int[]{2,3,4,5,1});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(13, new int[]{5,3,2,6,4});
        assertEquals(20, scoringTable.getTotalScore());
    }

    @Test
    public void fullTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(14, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(14, new int[]{1,2,1,2,2});
        assertEquals(8, scoringTable.getTotalScore());

        scoringTable.score(14, new int[]{6,6,6,6,6});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(14, new int[]{4,4,6,6,4});
        assertEquals(24, scoringTable.getTotalScore());
    }

    @Test
    public void sumTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(15, new int[]{1,1,3,4,5});
        assertEquals(14, scoringTable.getTotalScore());

        scoringTable.score(15, new int[]{2,3,4,5,6});
        assertEquals(20, scoringTable.getTotalScore());
    }

    @Test
    public void yahtzeeTest(){
        assertEquals(0, scoringTable.getTotalScore());
        scoringTable.score(16, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(16, new int[]{2,3,4,5,6});
        assertEquals(0, scoringTable.getTotalScore());

        scoringTable.score(16, new int[]{6,6,6,6,6});
        assertEquals(80, scoringTable.getTotalScore());

        scoringTable.score(16, new int[]{1,1,1,1,1});
        assertEquals(55, scoringTable.getTotalScore());
    }


}