import java.util.Arrays;
import java.util.function.Function;

public class TestMain {
    public static void main(String[] args) {
        Function<int[], Integer> scoreF = i -> Arrays.stream(i).sum();
        int[] a = new int[] {1,2,3};

        System.out.println(scoreF.apply(a));
    }
}
