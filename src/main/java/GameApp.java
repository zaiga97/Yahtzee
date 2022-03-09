public class GameApp {
    private final GameStatus gs;
    private final GameView gw;

    public GameApp(GameStatus gs, GameView gw){
        this.gs = gs;
        this.gw = gw;
    }

    public void start() {
        gw.drawMenu();
    }
}
