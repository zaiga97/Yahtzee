import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4,5,5};
        System.out.println(COUPLEF.apply(ints));
    }

    static Function<int[], Integer> COUPLEF = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(listOfInts.stream()
                .filter(i -> Collections.frequency(listOfInts, i) >1)
                .distinct()
                .count() < 2
                ) {return 0;}

        else{
            return 2 * listOfInts.stream()
                    .filter(i -> Collections.frequency(listOfInts, i) > 1)
                    .distinct()
                    .mapToInt(i -> i)
                    .sum();
        }
    };

    private static int extracted(List<Integer> numbers) {
        int d = 0;
        int highestCouple = numbers
                .stream()
                .filter(i -> Collections.frequency(numbers, i) >1)
                .max(Integer::compareTo)
                .get();
        return 2 * highestCouple;
    }
}
