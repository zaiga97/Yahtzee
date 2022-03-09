public class GameApp {
    private final GameStatus gs;
    private final GameView gw;
    private final GameInput gi;

    public GameApp(GameStatus gs, GameView gw, GameInput gi){
        this.gs = gs;
        this.gw = gw;
        this.gi = gi;
    }

    public void start() {
        gw.drawMenu();
        int menuInput = gi.getMenuInput();

        switch (menuInput){
            case 0:
                break;
            case 1: newGameStart();
                break;

            default:
                gw.wrongInput();
                start();
        }
    }

    private void newGameStart() {
        gw.drawNewGame();
    }
}
