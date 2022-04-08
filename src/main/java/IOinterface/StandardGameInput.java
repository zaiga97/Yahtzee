package IOinterface;

import gameLogic.GameApp;

import java.util.Scanner;

/**
 * This implementation of {@link GameInput} uses the terminal for gathering the input.
 * Note that for the moment this class does not handle exception so if user enters a wrong input
 * the application will crash.
 */

public class StandardGameInput implements GameInput {
    private final Runnable errorPrinter;
    Scanner sc = new Scanner(System.in);

    public StandardGameInput(Runnable errorPrinter){
        this.errorPrinter = errorPrinter;
    }

    /**
     * {@inheritDoc}
     * @return
     */
    @Override
    public GameApp.MENUACTIONS getMenuInput() {
        int menuInput;
        try {
            menuInput = sc.nextInt();
        }
        catch (Exception e){
            errorPrinter.run();
            sc.nextLine();
            return getMenuInput();
        }
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
        String name;
        try{
            name = sc.next();
        }
        catch (Exception e){
            errorPrinter.run();
            sc.nextLine();
            return getPlayerName();
        }

        sc.nextLine();
        return name;
    }

    /**
     * {@inheritDoc}
     * @param numberOfDices
     */
    @Override
    public int[] getRerollIndexes(int numberOfDices) {
        String inputString = sc.nextLine();
        // If we don't want to reroll anymore
        if (inputString.isEmpty()) return new int[]{};
        // Else se need to get all the ints
        String[] indexesAsString = inputString.trim().split(" ");
        int[] indexes = new int[indexesAsString.length];
        // Check if all the sub string are numbers
        try {
            for (int i = 0; i < indexesAsString.length; i++) {
                int rerollIndex = Integer.parseInt(indexesAsString[i]);
                if (rerollIndex < 0 || rerollIndex >= numberOfDices){
                    throw new Exception();
                }
                indexes[i] = Integer.parseInt(indexesAsString[i]);

            }
        }
        catch (Exception e){
            errorPrinter.run();
            return getRerollIndexes(numberOfDices);
        }

        return indexes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScoringIndex() {
        int scoringIndex;
        try{
            scoringIndex = sc.nextInt();
        }
        catch (Exception e){
            errorPrinter.run();
            sc.nextLine();
            return getScoringIndex();
        }
        sc.nextLine();
        return scoringIndex;
    }
}
