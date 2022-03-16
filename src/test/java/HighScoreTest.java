import gameLogic.HighScore;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HighScoreTest {
    HighScore highScore = new HighScore();

    //Some random values for testing the highScore
    //If you change this also change them in the highScoreLoadTest file in resources
    List<Integer> player1Scores = Arrays.asList(1,1,2);
    List<Integer> player2Scores = Arrays.asList(1,3);

    @Test
    public void setScoreTest(){
        player1Scores.forEach(score -> highScore.add("Player1", score));
        player2Scores.forEach(score -> highScore.add("Player2", score));

        Map<String, List<Integer>> scoreHistory = highScore.getScoreHistory();

        assertTrue(scoreHistory.get("Player1").containsAll(player1Scores));
        assertTrue(scoreHistory.get("Player2").containsAll(player2Scores));
    }

    @Test
    public void ableToLoadFormFileTest(){
        highScore.load("./src/test/resources/highScoreLoadTest");
        Map<String, List<Integer>> scoreHistory = highScore.getScoreHistory();

        assertTrue(scoreHistory.get("Player1").containsAll(player1Scores));
        assertTrue(scoreHistory.get("Player2").containsAll(player2Scores));
    }

    @Test
    public void ableToWriteToFileTest(){
        player1Scores.forEach(score -> highScore.add("Player1", score));
        player2Scores.forEach(score -> highScore.add("Player2", score));

        highScore.write("./src/test/resources/highScoreWriteTest");
        highScore = new HighScore();
        highScore.load("./src/test/resources/highScoreWriteTest");

        Map<String, List<Integer>> scoreHistory = highScore.getScoreHistory();
        assertTrue(scoreHistory.get("Player1").containsAll(player1Scores));
        assertTrue(scoreHistory.get("Player2").containsAll(player2Scores));
    }
}
