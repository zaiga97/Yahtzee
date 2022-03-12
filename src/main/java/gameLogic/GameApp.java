package gameLogic;
import IOinterface.*;

public class GameApp {
    private StandardGameStatus gs;
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
            case 1: playNewGame();
                break;

            default:
                gw.drawWrongInput();
                start();
        }
    }

    private void playNewGame() {

        // Initialize the new game
        gw.drawNewGame();
        gw.drawPlayerNameRequest();
        String playerName = gi.getPlayerName();
        gs = new StandardGameStatus(playerName);

        // Play the game
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

        // Game ending
        gw.drawEndGame();
        gw.drawGameStatus(gs);

        // Loop back to the menu
        start();
    }

    private void score() {
        int scoringIndex;

        while (true){
            gw.drawScoringRequest();
            scoringIndex = gi.getScoringIndex();

            if (gs.isLegalScoring(scoringIndex)) break;
            gw.drawWrongInput();
        }

        gs.score(scoringIndex);
    }
}
