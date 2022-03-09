import java.util.Random;

public class Dice {
    private final int FACES;
    Random random = new Random();

    public Dice(int faces) {
        if (faces <= 0) throw new ExceptionInInitializerError("Number of dice faces must be positive");
        FACES = faces;
    }

    public int getFaces() {
        return FACES;
    }

    public int roll() {
        return random.nextInt(1, FACES + 1);
    }
}
