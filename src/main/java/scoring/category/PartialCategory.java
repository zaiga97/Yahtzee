package scoring.category;

public abstract class PartialCategory implements ScoreCategory{

    private final String name;
    protected int score = 0;
    private boolean scored = false;

    public PartialCategory(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void score(int[] dicesValues) {
        score = calculateScore(dicesValues);
        scored = true;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public boolean isScored() {
        return scored;
    }
}

