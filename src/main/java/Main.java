public class Main {
    public static void main(String[] args) {
        GameView gw = new StandardGameView();
        GameStatus gs = new GameStatus(gw);
        GameApp ga = new GameApp(gs, gw);

        ga.start();
    }
}
