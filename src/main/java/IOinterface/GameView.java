package IOinterface;

import gameLogic.GameStatus;

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
