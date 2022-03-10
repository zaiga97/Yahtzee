public class StandardGameView implements GameView {
    @Override
    public void draw(GameStatus gs) {
    }

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
        System.out.println("Player: " + gs.getPlayer().getName());

        for (var dice: gs.getDices()) {
            System.out.println(dice.getValue());
        }
    }

    @Override
    public void drawRerollRequest() {
        System.out.println("Enter the indexes of the dices you want to reroll: ");
    }
}
