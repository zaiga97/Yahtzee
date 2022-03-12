package gameLogic;
import java.util.Random;

/**
 * This is an implementation of a fair dice.
 * The randomness is done using the standard {@link java.util.Random}
 * @author zaiga97
 */

public class FairDice implements Dice {

    static final int MIN_VALUE = 1;
    private final int FACES;
    private int value = MIN_VALUE; // Initialized so we can call getValue before rolling
    Random random = new Random();

    /**
     * Construct a fair dice with x faces.
     * @param faces Number of faces for the dice.
     */
    public FairDice(int faces) {
        if (faces <= 0) throw new ExceptionInInitializerError("Number of dice faces must be positive");
        FACES = faces;
    }

    /**
     * @return The number of faces of the dice
     */
    @Override
    public int getFaces() {
        return FACES;
    }

    /**
     * Reroll the dice giving each face the same probability.
     * @return This FairDice once rerolled.
     */
    @Override
    public Dice roll() {
        this.value =  random.nextInt(MIN_VALUE, FACES + 1);
        return this;
    }

    /**
     * @return The current value of the dice.
     */
    @Override
    public int getValue() {
         return value;
    }
}
