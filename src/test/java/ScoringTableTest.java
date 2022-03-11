import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ScoringTableTest {
    ScoringTable scoringTable = new DefaultScoringTable();

    @Test
    public void getScoreTest(){
        assertEquals(0, scoringTable.getScore());
    }
}
