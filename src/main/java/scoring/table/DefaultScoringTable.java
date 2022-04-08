package scoring.table;

import java.util.Arrays;
import scoring.category.*;

/**
 * This is the implementation of the classic scoring table of the game of yahtzee!
 * @author zaiga97
 */

// For now the class uses an array and some magic numbers for positions...
// Maybe a Map and an enum would be better.

public class DefaultScoringTable implements ScoringTable {

    private static final int CATEGORYCOUNT = 17;
    private ScoreCategory[] scoringArray = new ScoreCategory[CATEGORYCOUNT];

    public DefaultScoringTable(){
        //0: # of 1
        scoringArray[0] = new GeneralCategory("# of 1", DefaultScoringFunctions.SUM1);
        //1: # of 2
        scoringArray[1] = new GeneralCategory("# of 2", DefaultScoringFunctions.SUM2);
        //2: # of 3
        scoringArray[2] = new GeneralCategory("# of 3", DefaultScoringFunctions.SUM3);
        //3: # of 4
        scoringArray[3] = new GeneralCategory("# of 4", DefaultScoringFunctions.SUM4);
        //4: # of 5
        scoringArray[4] = new GeneralCategory("# of 5", DefaultScoringFunctions.SUM5);
        //5: # of 6
        scoringArray[5] = new GeneralCategory("# of 6", DefaultScoringFunctions.SUM6);

        //6: Sum of above
        scoringArray[6] = new SumOfUpperCategory("Sum of upper", this);
        //7: Bonus
        scoringArray[7] = new BonusCategory("Bonus", this);

        //8: Couple
        scoringArray[8] = new GeneralCategory("Couple", DefaultScoringFunctions.COUPLE);
        //9: Double couple
        scoringArray[9] = new GeneralCategory("Double couple", DefaultScoringFunctions.DOUBLECOUPLE);
        //10: Tris
        scoringArray[10] = new GeneralCategory("Tris", DefaultScoringFunctions.TRIS);
        //11: Poker
        scoringArray[11] = new GeneralCategory("Poker", DefaultScoringFunctions.POKER);
        //12: Small scale
        scoringArray[12] = new GeneralCategory("Small scale", DefaultScoringFunctions.SMALL);
        //13: Big scale
        scoringArray[13] = new GeneralCategory("Big scale", DefaultScoringFunctions.BIG);
        //14: Full
        scoringArray[14] = new GeneralCategory("Full", DefaultScoringFunctions.FULL);
        //15: Sum
        scoringArray[15] = new GeneralCategory("Sum", DefaultScoringFunctions.SUM);
        //16: Yahtzee
        scoringArray[16] = new GeneralCategory("Yahtzee", DefaultScoringFunctions.YAHTZEE);
    }

    @Override
    public int getTotalScore() {
        return Arrays.stream(scoringArray).mapToInt(ScoreCategory::getScore).sum() - scoringArray[6].getScore();
    }

    @Override
    public ScoreCategory getScoringCategory(int index) {
        return scoringArray[index];
    }

    @Override
    public void score(int index, int[] dicesValues) {
        scoringArray[index].score(dicesValues);
    }

    @Override
    public boolean isComplete() {
        for (var category: scoringArray) {
            if (!category.isScored()) return false;
        }
        return true;
    }

    @Override
    public int getCategoryCount() {
        return CATEGORYCOUNT;
    }
}
