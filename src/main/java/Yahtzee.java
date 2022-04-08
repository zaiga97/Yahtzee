import IOinterface.*;
import gameLogic.*;

/**
 * Yahtzee!
 * This program aim to implement the game of yahtzee!
 * The aim of the game is to get the highest score.
 * The player will roll a total of 5 dices after which he can select 2 times which dices he wants to reroll.
 * At the end of the turn the player has to score in one of the possible categories (each with their scoring rule)
 * The game ends when all the categories are full.
 * For more information about the game visit: https://it.wikipedia.org/wiki/Yahtzee.
 *
 * @author zaiga97
 */

public class Yahtzee {
    public static void main(String[] args) {
        GameView gw = new StandardGameView();
        GameInput gi = new StandardGameInput(gw::drawWrongInput);
        GameApp ga = new GameApp(gw, gi);

        ga.start();
    }
}
