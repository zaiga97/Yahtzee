import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoreTest {
    @Test
    public void setScoreTest(){
        HighScore highScore = new HighScore();
        highScore.add("Player1", 123);
        assertEquals(123, highScore.getScores("Player1"));
    }
}
