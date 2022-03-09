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
}
