import org.junit.jupiter.api.Test;
import scoring.table.DefaultScoringTable;
import scoring.table.ScoringTable;

import static org.junit.jupiter.api.Assertions.*;

public class ScoringTableTest {
    ScoringTable scoringTable = new DefaultScoringTable();

    @Test
    public void upperScoreTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(0, new int[]{1,2,3,4,5});
        assertEquals(1, scoringTable.getScore());

        scoringTable.score(0, new int[]{2,2,2,2,2});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(5, new int[]{6,6,6,6,5});
        assertEquals(24, scoringTable.getScore());

        scoringTable.score(1, new int[]{2,2,3,4,5});
        assertEquals(28, scoringTable.getScore());

    }

    @Test
    public void coupleTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(8, new int[]{1,2,3,4,5});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(8, new int[]{1,1,3,4,5});
        assertEquals(2, scoringTable.getScore());

        scoringTable.score(8, new int[]{1,1,3,5,5});
        assertEquals(10, scoringTable.getScore());

        scoringTable.score(8, new int[]{1,1,6,6,6});
        assertEquals(12, scoringTable.getScore());
    }

    @Test
    public void doubleCoupleTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(9, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(9, new int[]{1,1,3,3,5});
        assertEquals(8, scoringTable.getScore());

        scoringTable.score(9, new int[]{1,1,3,5,5});
        assertEquals(12, scoringTable.getScore());

        scoringTable.score(9, new int[]{1,1,6,6,6});
        assertEquals(14, scoringTable.getScore());
    }

    @Test
    public void trisTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(10, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(10, new int[]{1,1,3,3,3});
        assertEquals(9, scoringTable.getScore());

        scoringTable.score(10, new int[]{1,5,5,5,5});
        assertEquals(15, scoringTable.getScore());

        scoringTable.score(10, new int[]{1,1,6,6,6});
        assertEquals(18, scoringTable.getScore());
    }

    @Test
    public void pokerTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(11, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(11, new int[]{1,3,3,3,3});
        assertEquals(12, scoringTable.getScore());

        scoringTable.score(11, new int[]{1,5,5,5,5});
        assertEquals(20, scoringTable.getScore());

        scoringTable.score(11, new int[]{1,1,6,6,6});
        assertEquals(0, scoringTable.getScore());
    }

    @Test
    public void smallScaleTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(12, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(12, new int[]{1,2,3,4,5});
        assertEquals(15, scoringTable.getScore());

        scoringTable.score(12, new int[]{2,3,4,5,6});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(12, new int[]{5,3,2,1,4});
        assertEquals(15, scoringTable.getScore());
    }

    @Test
    public void bigScaleTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(13, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(13, new int[]{2,3,4,5,6});
        assertEquals(20, scoringTable.getScore());

        scoringTable.score(13, new int[]{2,3,4,5,1});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(13, new int[]{5,3,2,6,4});
        assertEquals(20, scoringTable.getScore());
    }

    @Test
    public void fullTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(14, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(14, new int[]{1,2,1,2,2});
        assertEquals(8, scoringTable.getScore());

        scoringTable.score(14, new int[]{6,6,6,6,6});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(14, new int[]{4,4,6,6,4});
        assertEquals(24, scoringTable.getScore());
    }

    @Test
    public void sumTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(15, new int[]{1,1,3,4,5});
        assertEquals(14, scoringTable.getScore());

        scoringTable.score(15, new int[]{2,3,4,5,6});
        assertEquals(20, scoringTable.getScore());
    }

    @Test
    public void yahtzeeTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(16, new int[]{1,1,3,4,5});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(16, new int[]{2,3,4,5,6});
        assertEquals(0, scoringTable.getScore());

        scoringTable.score(16, new int[]{6,6,6,6,6});
        assertEquals(80, scoringTable.getScore());

        scoringTable.score(16, new int[]{1,1,1,1,1});
        assertEquals(55, scoringTable.getScore());
    }


}