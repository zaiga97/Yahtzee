package scoring.table;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class DefaultScoringFunctions {
    //This is the scoring list:

    //0: # of 1
    public final static Function<int[], Integer> SUM1 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 1)
                    .sum();
    //1: # of 2
    public final static Function<int[], Integer> SUM2 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 2)
                    .sum();
    //2: # of 3
    public final static Function<int[], Integer> SUM3 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 3)
                    .sum();
    //3: # of 4
    public final static Function<int[], Integer> SUM4 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 4)
                    .sum();
    //4: # of 5
    public final static Function<int[], Integer> SUM5 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 5)
                    .sum();
    //5: # of 6
    public final static Function<int[], Integer> SUM6 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 6)
                    .sum();

    //6: Sum of above
    //7: Bonus

    //8: Couple
    public final static Function<int[], Integer> COUPLE = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(listOfInts.stream()
                .filter(i -> Collections.frequency(listOfInts, i) >1)
                .max(Integer::compareTo)
                .isEmpty()) {return 0;}

        else{
            return 2 * listOfInts.stream()
                    .filter(i -> Collections.frequency(listOfInts, i) >1)
                    .max(Integer::compareTo)
                    .get();
        }
    };

    //9: Double couple
    public final static Function<int[], Integer> DOUBLECOUPLE = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(listOfInts.stream()
                .filter(i -> Collections.frequency(listOfInts, i) >1)
                .distinct()
                .count() < 2
        ) {return 0;}

        else{
            return 2 * listOfInts.stream()
                    .filter(i -> Collections.frequency(listOfInts, i) > 1)
                    .distinct() //NB there are only 2
                    .mapToInt(i -> i)
                    .sum();
        }
    };

    //10: Tris
    public final static Function<int[], Integer> TRIS = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(listOfInts.stream()
                .filter(i -> Collections.frequency(listOfInts, i) >2)
                .max(Integer::compareTo)
                .isEmpty()) {return 0;}

        else{
            return 3 * listOfInts.stream()
                    .filter(i -> Collections.frequency(listOfInts, i) >2)
                    .max(Integer::compareTo)
                    .get();
        }
    };

    //11: Poker
    public final static Function<int[], Integer> POKER = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(listOfInts.stream()
                .filter(i -> Collections.frequency(listOfInts, i) >3)
                .max(Integer::compareTo)
                .isEmpty()) {return 0;}

        else{
            return 4 * listOfInts.stream()
                    .filter(i -> Collections.frequency(listOfInts, i) >3)
                    .max(Integer::compareTo)
                    .get();
        }
    };

    //12: Small scale
    public final static Function<int[], Integer> SMALL = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(!listOfInts.containsAll(List.of(1,2,3,4,5))) {return 0;}
        return 15;
    };

    //13: Big scale
    public final static Function<int[], Integer> BIG = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(!listOfInts.containsAll(List.of(2,3,4,5,6))) {return 0;}
        return 20;
    };

    //14: Full
    public final static Function<int[], Integer> FULL = ints -> {
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

    //15: Sum
    public final static Function<int[], Integer> SUM = ints -> Arrays.stream(ints).sum();

    //16: Yahtzee
    public final static Function<int[], Integer> YAHTZEE = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(listOfInts.stream()
                .filter(i -> Collections.frequency(listOfInts, i) >4)
                .max(Integer::compareTo)
                .isEmpty()) {return 0;}

        else{
            return 50 + 5 * listOfInts.stream()
                    .filter(i -> Collections.frequency(listOfInts, i) >4)
                    .max(Integer::compareTo)
                    .get();
        }
    };
}
