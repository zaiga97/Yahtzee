import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {

    @ParameterizedTest
    @ValueSource(strings = {"Andrea", "Player1", "qwerty"})
    public void PlayerInstantiationTest(String name){
        Player player = new Player(name);
        assertEquals(name, player.getName());
    }

}
