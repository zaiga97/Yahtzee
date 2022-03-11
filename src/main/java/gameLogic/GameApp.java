package gameLogic;

import IOinterface.GameInput;
import IOinterface.GameView;

public class GameApp {
    private GameStatus gs;
    private final GameView gw;
    private final GameInput gi;

    public GameApp(GameView gw, GameInput gi){
        this.gw = gw;
        this.gi = gi;
    }

    public void start() {
        gw.drawMenu();
        int menuInput = gi.getMenuInput();

        switch (menuInput){
            case 0:
                break;
            case 1: newGameStart();
                break;

            default:
                gw.wrongInput();
                start();
        }
    }

    private void newGameStart() {
        gw.drawNewGame();

        gw.drawPlayerNameRequest();
        String playerName = gi.getPlayerName();
        gs = new GameStatus(playerName);

        for (int i = 0; i < 3; i++) {
            gs.rollAll();
            gw.drawGameStatus(gs);

            gw.drawRerollRequest();
            gs.reroll(gi.getRerollIndexes());
            gw.drawGameStatus(gs);

            gw.drawRerollRequest();
            gs.reroll(gi.getRerollIndexes());
            gw.drawGameStatus(gs);

            gw.drawScoringRequest();
            int scoringIndex = gi.getScoringIndex();
            gs.score(scoringIndex);
            gw.drawGameStatus(gs);
        }
    }
}
