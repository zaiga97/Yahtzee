package scoring.category;

/**
 * This class is a Partial implementation of the {@link ScoreCategory}.
 * It's used to avoid repeating common tasks.
 * @author zaiga97
 */

public abstract class PartialCategory implements ScoreCategory{

    private final String name;
    protected int score = 0;
    private boolean scored = false;

    public PartialCategory(String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void score(int[] dicesValues) {
        score = calculateScore(dicesValues);
        scored = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getScore() {
        return score;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isScored() {
        return scored;
    }
}

