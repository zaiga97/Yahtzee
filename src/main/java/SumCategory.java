import java.util.function.Function;

public class SumCategory implements ScoreCategory {
    private String name = "Sum";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int calculateScore(int[] dicesValues) {
        return 0;
    }
}