package IOinterface;

import gameLogic.Dice;
import gameLogic.GameStatus;
import scoring.category.ScoreCategory;
import scoring.table.ScoringTable;

/**
 * This is the standard implementation of {@link GameView}.
 * This uses the terminal for printing the game.
 * Note that this may have some problem on non Unix platforms since it uses escape chars for colors.
 * @author zaiga97
 */

public class StandardGameView implements GameView {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    @Override
    public void drawMenu() {
        System.out.println(
                """
                ###        MENU        ###

                       0 -> Exit
                       1 -> New game

                ###                    ###
                enter an option from above:"""
        );
    }

    @Override
    public void drawWrongInput() {
        System.out.println(ANSI_RED + "Got a wrong input... try again" + ANSI_RESET);
    }

    @Override
    public void drawNewGame() {
        System.out.println(ANSI_CYAN + "Welcome to a new game" + ANSI_RESET);
    }

    @Override
    public void drawPlayerNameRequest() {
        System.out.println("Enter your name:");
    }

    @Override
    public void drawGameStatus(GameStatus gs) {
        System.out.println(
                "##############################\n" +
                "-> Player: " + ANSI_GREEN + gs.getPlayer().getName() + ANSI_RESET + "\n" +
                "-> Score: " + ANSI_GREEN + gs.getScore() + ANSI_RESET
        );

        drawScoringTable(gs.getScoringTable());
        drawDices(gs.getDices());

    }

    private void drawDices(Dice[] dices) {
        System.out.println("#####        DICES       #####");
        for (int i = 0; i < dices.length; i++) {
            System.out.println("| dice: " + i + " | " + dices[i].getValue() + " |");
        }
        System.out.println("##############################");
    }

    @Override
    public void drawRerollRequest() {
        System.out.println("Please enter the indexes of the dices you want to reroll: ");
    }

    @Override
    public void drawScoringRequest() {
        System.out.println("Please enter the category index you want to score:");
    }

    @Override
    public void drawEndGame() {
        System.out.println(ANSI_CYAN + "#####   Game has ended      #####" + ANSI_RESET);
    }

    public void drawScoringTable(ScoringTable scoringTable){
        int categoryCount = scoringTable.getCategoryCount();
        System.out.println("#####   SCORING TABLE    #####");
        for (int i = 0; i < categoryCount; i++) {
            ScoreCategory scoreCategory = scoringTable.getScoringCategory(i);
            String color = scoreCategory.isScored() ? ANSI_GREEN : "";
            System.out.print(color + "| i: ");
            System.out.printf("%3d", i);
            System.out.print(" | ");
            System.out.printf("%13s", scoreCategory.getName());
            System.out.print(" | ");
            System.out.printf("%3d", scoreCategory.getScore());
            System.out.println( " |" + ANSI_RESET);
        }
        System.out.println("##############################");
    }
}
