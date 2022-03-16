package IOinterface;

import gameLogic.GameApp;

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
     * @return
     */
    @Override
    public GameApp.MENUACTIONS getMenuInput() {
        int menuInput = sc.nextInt();
        sc.nextLine();
        return switch (menuInput) {
            case 0 -> GameApp.MENUACTIONS.END;
            case 1 -> GameApp.MENUACTIONS.NEWGAME;
            case 2 -> GameApp.MENUACTIONS.HIGHSCORES;
            default -> GameApp.MENUACTIONS.NOTDEFINED;
        };
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
