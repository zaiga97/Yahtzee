package gameLogic;
import IOinterface.*;

/**
 * This class is the orchestrator of the program.
 * Contains the basic logic for the game and a basic menu.
 * @author zaiga97
 */

public class GameApp {
    private GameStatus gs;
    private final GameView gw;
    private final GameInput gi;

    /**
     * Generate a new {@link GameApp}
     * @param gw The {@link GameView} used for displaying the game.
     * @param gi The {@link GameInput} used for getting the inputs.
     */
    public GameApp(GameView gw, GameInput gi){
        this.gw = gw;
        this.gi = gi;
    }

    /**
     * This function start the game.
     */
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

    /**
     * Initialize a new game. For now {@link StandardGameStatus} will be initialized
     * One can modify this function or expand the class for supporting different {@link GameStatus}
     */
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

    /**
     * Score the dices at the end of the turn.
     * Prevents player to score same already scored categories.
     */
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
