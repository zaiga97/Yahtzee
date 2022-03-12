package gameLogic;

/**
 * Basic player class. For now only contains the player name.
 * @author zaiga97
 */
public record Player(String name) {
    public String getName() {
        return name;
    }
}
