public class Main {
    public static void main(String[] args) {
        GameView gw = new StandardGameView();
        GameStatus gs = new GameStatus(gw);
        GameInput gi = new StandardGameInput();

        GameApp ga = new GameApp(gs, gw, gi);

        ga.start();
    }
}
