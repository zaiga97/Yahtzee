import java.util.Scanner;

public class StandardGameInput implements GameInput {
    Scanner sc = new Scanner(System.in);

    @Override
    public int getMenuInput() {
        int menuInput = sc.nextInt();
        return menuInput;
    }
}
