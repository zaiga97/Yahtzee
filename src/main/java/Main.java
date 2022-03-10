public class Main {
    public static void main(String[] args) {
        GameView gw = new StandardGameView();
        GameInput gi = new StandardGameInput();

        GameApp ga = new GameApp(gw, gi);

        ga.start();
    }
}
