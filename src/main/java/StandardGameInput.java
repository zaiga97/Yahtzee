import java.util.Scanner;

public class StandardGameInput implements GameInput {
    Scanner sc = new Scanner(System.in);

    @Override
    public int getMenuInput() {
        int menuInput = sc.nextInt();
        return menuInput;
    }

    @Override
    public String getPlayerName() {
        return sc.next();
    }

    @Override
    public int[] getRerollIndexes() {
        String inputString = sc.next();
        inputString = sc.next();
        String[] indexesAsString = inputString.trim().split(" ");

        int[] indexes = new int[indexesAsString.length];
        for (int i = 0; i < indexesAsString.length; i++) {
            indexes[i] = Integer.parseInt(indexesAsString[i]);
        }

        return indexes;
    }

    @Override
    public int getScoringIndex() {
        int scoringIndex = sc.nextInt();
        return scoringIndex;
    }
}
