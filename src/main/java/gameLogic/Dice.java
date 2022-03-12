package gameLogic;

/**
 * This is the dice interface.
 * @author zaiga97
 */

public interface Dice {
    /**
     * @return The number of faces of the dice
     */
    int getFaces();

    /**
     * @return A {@link Dice} that has been rolled.
     * This is so one can use method concatenation.
     */
    Dice roll();

    /**
     * @return The current value of the dice.
     */
    int getValue();
}
