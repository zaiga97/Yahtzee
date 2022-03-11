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
}