import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HighScoreTest {

    @Test
    public void setScoreTest(){
        HighScore highScore = new HighScore();

        highScore.add("Player1", 1);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        assertEquals(expected, highScore.getScores("Player1"));

        highScore.add("Player1", 2);
        expected.add(2);
        assertEquals(expected, highScore.getScores("Player1"));

        highScore.add("Player2", 1);
        List<Integer> expected2 = new ArrayList<>();
        expected2.add(1);
        assertEquals(expected2, highScore.getScores("Player2"));
    }

    @Test
    public void ableToLoadFormFileTest(){
        HighScore highScore = new HighScore();
        highScore.load("./src/test/resources/highScoreLoadTest");

        List<Integer> expected1 = new ArrayList<>();
        expected1.add(1);
        expected1.add(2);
        expected1.add(2);

        List<Integer> expected2 = new ArrayList<>();
        expected2.add(3);
        expected2.add(1);

        assertEquals(expected1, highScore.getScores("Player1"));
        assertEquals(expected2, highScore.getScores("Player2"));
    }
}
