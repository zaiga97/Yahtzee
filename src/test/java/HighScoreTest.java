import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighScoreTest {
    HighScore highScore = new HighScore();
    //This are some random values for testing the highScore
    //If you change this also change them in the highScoreLoadTest file in resources
    List<Integer> player1Scores = Arrays.asList(1,1,2);
    List<Integer> player2Scores = Arrays.asList(1,3);

    @Test
    public void setScoreTest(){
       player1Scores.forEach(score -> highScore.add("Player1", score));
       player2Scores.forEach(score -> highScore.add("Player2", score));

        assertTrue(highScore.getPlayerScores("Player1").containsAll(player1Scores));
        assertTrue(highScore.getPlayerScores("Player2").containsAll(player2Scores));
    }

    @Test
    public void ableToLoadFormFileTest(){
        highScore.load("./src/test/resources/highScoreLoadTest");

        assertTrue(highScore.getPlayerScores("Player1").containsAll(player1Scores));
        assertTrue(highScore.getPlayerScores("Player2").containsAll(player2Scores));
    }

    @Test
    public void ableToWriteToFileTest(){
        player1Scores.forEach(score -> highScore.add("Player1", score));
        player2Scores.forEach(score -> highScore.add("Player2", score));

        highScore.write("./src/test/resources/highScoreWriteTest");
        highScore = new HighScore();
        highScore.load("./src/test/resources/highScoreWriteTest");

        assertTrue(highScore.getPlayerScores("Player1").containsAll(player1Scores));
        assertTrue(highScore.getPlayerScores("Player2").containsAll(player2Scores));
    }

    @Test
    public void getRecordTest(){
        highScore.load("./src/test/resources/highScoreLoadTest");
        assertEquals(player1Scores.stream().max(Integer::compareTo).get(), highScore.getRecord("Player1"));
        assertEquals(player2Scores.stream().max(Integer::compareTo).get(), highScore.getRecord("Player2"));
    }
}
