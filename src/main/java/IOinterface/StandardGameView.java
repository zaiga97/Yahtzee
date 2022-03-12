package IOinterface;

import gameLogic.Dice;
import gameLogic.StandardGameStatus;
import scoring.category.ScoreCategory;
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
    public void drawGameStatus(StandardGameStatus gs) {
        System.out.println(
                "##############################\n" +
                "-> Player: " + gs.getPlayer().getName() + "\n" +
                "-> Score: " + gs.getScore()
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
        System.out.println("Enter the indexes of the dices you want to reroll: ");
    }

    @Override
    public void drawScoringRequest() {
        System.out.println("Please enter the category index you want to score:");
    }

    @Override
    public void drawEndGame() {
        System.out.println("#####   Game has ended      #####");
    }

    public void drawScoringTable(ScoringTable scoringTable){
        int categoryCount = scoringTable.getCategoryCount();
        System.out.println("#####   SCORING TABLE    #####");
        for (int i = 0; i < categoryCount; i++) {
            ScoreCategory scoreCategory = scoringTable.getScoringCategory(i);
            //System.out.println("------------------------------"); //30 char
            System.out.println("| i: " + i + " | " + scoreCategory.getName() + " | " + scoreCategory.getScore() + " |");
        }
        System.out.println("##############################");
    }
}
