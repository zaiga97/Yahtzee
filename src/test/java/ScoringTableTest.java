import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoringTableTest {
    ScoringTable scoringTable = new DefaultScoringTable();

    @Test
    public void getScoreTest(){
        assertEquals(0, scoringTable.getScore());
        scoringTable.score(0, new int[]{1,2,3,4,5});
        assertEquals(15, scoringTable.getScore());
        scoringTable.score(1, new int[]{2,2,2,2,2});
        assertEquals(15+10, scoringTable.getScore());
        scoringTable.score(2, new int[]{6,6,6,6,6});
        assertEquals(15+10+30, scoringTable.getScore());
    }
}
