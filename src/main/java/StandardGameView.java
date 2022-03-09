public class StandardGameView implements GameView {
    @Override
    public void draw(GameStatus gs) {
        System.out.println("This is the game status");
    }

    @Override
    public void drawMenu() {
        System.out.println("This is the menu");
    }
}
