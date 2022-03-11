package IOinterface;

import java.util.List;

public interface GameInput {
    public int getMenuInput();
    public String getPlayerName();
    public int[] getRerollIndexes();
    public int getScoringIndex();
}
