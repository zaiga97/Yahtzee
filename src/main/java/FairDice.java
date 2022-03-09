import java.util.Random;

public class FairDice implements Dice {

    static final int MIN_VALUE = 1;
    private int value = MIN_VALUE;

    private final int FACES;
    Random random = new Random();

    public FairDice(int faces) {
        if (faces <= 0) throw new ExceptionInInitializerError("Number of dice faces must be positive");
        FACES = faces;
    }

    @Override
    public int getFaces() {
        return FACES;
    }

    @Override
    public Dice roll() {
        this.value =  random.nextInt(MIN_VALUE, FACES + 1);
        return this;
    }

    @Override
    public int getValue() {
         return value;
    }
}
