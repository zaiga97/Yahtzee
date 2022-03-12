package IOinterface;

import gameLogic.StandardGameStatus;

public interface GameView {
    public void drawMenu();
    public void wrongInput();
    public void drawNewGame();
    public void drawPlayerNameRequest();
    public void drawGameStatus(StandardGameStatus gs);
    public void drawRerollRequest();
    public void drawScoringRequest();
    public void drawEndGame();
}
