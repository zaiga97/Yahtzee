import IOinterface.*;
import gameLogic.*;

public class Main {
    public static void main(String[] args) {
        GameApp ga = new GameApp(new StandardGameView(), new StandardGameInput());
        ga.start();
    }
}
