package IOinterface;

import gameLogic.GameStatus;

public interface GameView {
    public void drawMenu();
    public void wrongInput();
    public void drawNewGame();
    public void drawPlayerNameRequest();
    public void drawGameStatus(GameStatus gs);
    public void drawRerollRequest();
    public void drawScoringRequest();
    public void drawEndGame();
}
