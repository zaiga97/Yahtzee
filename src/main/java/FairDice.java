import java.util.Random;

public class FairDice implements Dice {

    private int value;
    private final int FACES;
    Random random = new Random();

    public FairDice(int faces) {
        if (faces <= 0) throw new ExceptionInInitializerError("Number of dice faces must be positive");
        FACES = faces;
    }

    public int getFaces() {
        return FACES;
    }

    public Dice roll() {
        this.value =  random.nextInt(1, FACES + 1);
        return this;
    }

    @Override
    public int getValue() {
        return value;
    }
}
