package IOinterface;

import java.util.Scanner;

/**
 * This implementation of {@link GameInput} uses the terminal for gathering the input.
 * Note that for the moment this class does not handle exception so if user enters a wrong input
 * the application will crash.
 */

public class StandardGameInput implements GameInput {
    Scanner sc = new Scanner(System.in);

    /**
     * {@inheritDoc}
     */
    @Override
    public int getMenuInput() {
        int menuInput = sc.nextInt();
        sc.nextLine();
        return menuInput;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPlayerName() {
        String name = sc.next();
        sc.nextLine();
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int[] getRerollIndexes() {
        String inputString = sc.nextLine();
        // If we don't want to reroll anymore
        if (inputString.isEmpty()) return new int[]{};
        // Else se need to get all the ints
        String[] indexesAsString = inputString.trim().split(" ");
        int[] indexes = new int[indexesAsString.length];
        for (int i = 0; i < indexesAsString.length; i++) {
            indexes[i] = Integer.parseInt(indexesAsString[i]);
        }

        return indexes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScoringIndex() {
        int scoringIndex = sc.nextInt();
        sc.nextLine();
        return scoringIndex;
    }
}
