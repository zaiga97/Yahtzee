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

        while(!gs.isComplete()) {
            gs.rollAll();
            gw.drawGameStatus(gs);

            gw.drawRerollRequest();
            gs.reroll(gi.getRerollIndexes());
            gw.drawGameStatus(gs);

            gw.drawRerollRequest();
            gs.reroll(gi.getRerollIndexes());
            gw.drawGameStatus(gs);

            score();
        }

        gw.drawEndGame();
        start();
    }

    private void score() {
        int scoringIndex = 0;

        while (true){
            gw.drawScoringRequest();
            scoringIndex = gi.getScoringIndex();

            if (gs.isLegalScoring(scoringIndex)) break;
            gw.wrongInput();
        }

        gs.score(scoringIndex);
    }
}
