package IOinterface;

import gameLogic.Dice;
import gameLogic.GameStatus;
import scoring.table.ScoringTable;

public class StandardGameView implements GameView {

    @Override
    public void drawMenu() {
        System.out.println(
                "###        MENU        ###\n\n" +
                "       0 -> Exit\n" +
                "       1 -> New game\n\n" +
                "###                    ###\n" +
                "enter an option from above:"
        );
    }

    @Override
    public void wrongInput() {
        System.out.println("Got a wrong input... try again");
    }

    @Override
    public void drawNewGame() {
        System.out.println("Welcome to a new game");
    }

    @Override
    public void drawPlayerNameRequest() {
        System.out.println("Enter your name:");
    }

    @Override
    public void drawGameStatus(GameStatus gs) {
        System.out.println(
                "##############################\n" +
                "-> gameLogic.Player: " + gs.getPlayer().getName() + "\n\n"
        );

        drawScoringTable(gs.getScoringTable());
        drawDices(gs.getDices());

        System.out.println(
                "##############################\n"
        );
    }

    private void drawDices(Dice[] dices) {
        for (var dice: dices) System.out.println(dice.getValue());
    }

    @Override
    public void drawRerollRequest() {
        System.out.println("Enter the indexes of the dices you want to reroll: ");
    }

    @Override
    public void drawScoringRequest() {
        System.out.println("Please enter the category index you want to score:");
    }

    public void drawScoringTable(ScoringTable scoringTable){
        System.out.println("gameLogic.Player score:" + scoringTable.getTotalScore());
        System.out.println("TABLEEEE");
    }
}
