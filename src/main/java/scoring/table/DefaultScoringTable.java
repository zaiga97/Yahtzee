package scoring.table;

import java.util.Arrays;
import java.util.function.Function;

import scoring.category.GeneralCategory;
import scoring.category.ScoreCategory;
import scoring.category.SumCategory;

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
    //9: Double couple
    //10: Tris
    //11: Quad
    //12: Smale scale
    //13: Big scale
    //14: Full
    //15: Sum
    //16: Yahtzee

    ScoreCategory[] scoringList = new ScoreCategory[6];

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
        //7: Bonus

        //8: Couple
        //9: Double couple
        //10: Tris
        //11: Quad
        //12: Smale scale
        //13: Big scale
        //14: Full
        //15: Sum
        //16: Yahtzee
    }

    @Override
    public int getScore() {
        return Arrays.stream(scoringList).mapToInt(scoreCategory -> scoreCategory.getScore()).sum();
    }

    @Override
    public void score(int index, int[] dicesValues) {
        scoringList[index].score(dicesValues);
    }
}
