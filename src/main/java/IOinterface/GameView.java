package IOinterface;

import gameLogic.GameStatus;

/**
 * This is the interface for the game output.
 * @author zaiga97
 */
public interface GameView {
    void drawMenu();
    void drawWrongInput();
    void drawNewGame();
    void drawPlayerNameRequest();
    void drawGameStatus(GameStatus gs);
    void drawRerollRequest();
    void drawScoringRequest();
    void drawEndGame();
}
