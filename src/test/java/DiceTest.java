import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiceTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25, 6, 100})
    public void InstantiationPositiveFacesTest(int faces){
        Dice dice = new Dice(faces);

        assertEquals(faces, dice.getFaces());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -34, -2})
    public void InstantiationNegativeFacesTest(){
        assertThrows(ExceptionInInitializerError.class, () -> {
            Dice dice = new Dice(-1);
        });
    }
}
