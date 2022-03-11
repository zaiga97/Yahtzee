package scoring.table;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import scoring.category.GeneralCategory;
import scoring.category.ScoreCategory;
import scoring.category.SumOfUpperCategory;

public class DefaultScoringTable implements ScoringTable {
    //This is the scoring list:

    //0: # of 1
    private final static Function<int[], Integer> SUM1 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 1)
                    .sum();
    //1: # of 2
    private final static Function<int[], Integer> SUM2 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 2)
                    .sum();
    //2: # of 3
    private final static Function<int[], Integer> SUM3 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 3)
                    .sum();
    //3: # of 4
    private final static Function<int[], Integer> SUM4 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 4)
                    .sum();
    //4: # of 5
    private final static Function<int[], Integer> SUM5 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 5)
                    .sum();
    //5: # of 6
    private final static Function<int[], Integer> SUM6 =
            ints -> Arrays.stream(ints)
                    .filter(i -> i == 6)
                    .sum();

    //6: Sum of above
    //7: Bonus

    //8: Couple
    private final static Function<int[], Integer> COUPLE = ints -> {
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
    private final static Function<int[], Integer> DOUBLECOUPLE = ints -> {
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
    private final static Function<int[], Integer> TRIS = ints -> {
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
    private final static Function<int[], Integer> POKER = ints -> {
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
    private final static Function<int[], Integer> SMALL = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(!listOfInts.containsAll(List.of(1,2,3,4,5))) {return 0;}
        return 15;
    };

    //13: Big scale
    private final static Function<int[], Integer> BIG = ints -> {
        List<Integer> listOfInts = Arrays.stream(ints).boxed().toList();

        if(!listOfInts.containsAll(List.of(2,3,4,5,6))) {return 0;}
        return 20;
    };

    //14: Full
    private final static Function<int[], Integer> FULL = ints -> {
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
    private final static Function<int[], Integer> SUM = ints -> Arrays.stream(ints).sum();

    //16: Yahtzee
    private final static Function<int[], Integer> YAHTZEE = ints -> {
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

    ScoreCategory[] scoringList = new ScoreCategory[17];

    public DefaultScoringTable(){
        //0: # of 1
        scoringList[0] = new GeneralCategory("# of 1", SUM1);
        //1: # of 2
        scoringList[1] = new GeneralCategory("# of 2", SUM2);
        //2: # of 3
        scoringList[2] = new GeneralCategory("# of 3", SUM3);
        //3: # of 4
        scoringList[3] = new GeneralCategory("# of 4", SUM4);
        //4: # of 5
        scoringList[4] = new GeneralCategory("# of 5", SUM5);
        //5: # of 6
        scoringList[5] = new GeneralCategory("# of 6", SUM6);

        //6: Sum of above
        scoringList[6] = new SumOfUpperCategory("Sum of upper", this);
        //7: Bonus
        scoringList[7] = new GeneralCategory("Bonus", ints -> 0);

        //8: Couple
        scoringList[8] = new GeneralCategory("Couple", COUPLE);
        //9: Double couple
        scoringList[9] = new GeneralCategory("Double couple", DOUBLECOUPLE);
        //10: Tris
        scoringList[10] = new GeneralCategory("Tris", TRIS);
        //11: Poker
        scoringList[11] = new GeneralCategory("Poker", POKER);
        //12: Small scale
        scoringList[12] = new GeneralCategory("Small scale", SMALL);
        //13: Big scale
        scoringList[13] = new GeneralCategory("Big scale", BIG);
        //14: Full
        scoringList[14] = new GeneralCategory("Full", FULL);
        //15: Sum
        scoringList[15] = new GeneralCategory("Sum", SUM);
        //16: Yahtzee
        scoringList[16] = new GeneralCategory("Yahtzee", YAHTZEE);
    }

    @Override
    public int getScore() {
        return Arrays.stream(scoringList).mapToInt(ScoreCategory::getScore).sum();
    }

    @Override
    public ScoreCategory getScoringCategory(int index) {
        return scoringList[index];
    }

    @Override
    public void score(int index, int[] dicesValues) {
        scoringList[index].score(dicesValues);
    }
}
