package IOinterface;

import gameLogic.GameStatus;

import java.util.List;
import java.util.Map;

/**
 * This is the interface for the game output.
 * @author zaiga97
 */
public interface GameView {
    /**
     * Draw the menu
     */
    void drawMenu();

    /**
     * Display an error on the screen if a wrong input is detected
     */
    void drawWrongInput();

    /**
     * Draw the start of a new game
     */
    void drawNewGame();

    /**
     * Draw a request for the player to enter his name.
     */
    void drawPlayerNameRequest();

    /**
     * Draw the game status. This should give the player all the information he needs to play the game.
     * In particular both the boards and the dices needs to be displayed.
     * @param gs The current game status.
     */
    void drawGameStatus(GameStatus gs);

    /**
     * Draw a request for the player for entering the dices he wants to reroll.
     */
    void drawRerollRequest();

    /**
     * Draw a request for the player to enter the category he wants to score.
     */
    void drawScoringRequest();

    /**
     * Draw the end of the game screen.
     */
    void drawEndGame();

    /**
     * Draw the High scores for the players.
     * @param scoreHistory This is a map of players names as keys and a list of scores as values
     */
    void drawHighScores(Map<String, List<Integer>> scoreHistory);
}
