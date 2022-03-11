import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args) {
        int[] ints = new int[]{1,1,2,2,2};
        System.out.println(F.apply(ints));
    }

    static Function<int[], Integer> F = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();
        int tris, duo;

        if(listOfInts.stream()
                .filter(i -> Collections.frequency(listOfInts, i) >2)
                .toList()
                .isEmpty()
                ) {return 0;}
        else{
            tris = listOfInts.stream()
                    .filter(i -> Collections.frequency(listOfInts, i) > 2)
                    .max(Integer::compareTo)
                    .get();
        }

        if(listOfInts.stream()
                .filter(i -> i != tris)
                .filter(i -> Collections.frequency(listOfInts, i) >1)
                .toList()
                .isEmpty()
        ) {return 0;}
        else{
            duo = listOfInts.stream()
                    .filter(i -> i != tris)
                    .filter(i -> Collections.frequency(listOfInts, i) > 1)
                    .max(Integer::compareTo)
                    .get();
        }

        return (tris*3) + (duo*2);
    };
}
