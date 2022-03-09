import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class DiceTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 25, 6, 100})
    public void InstantiationPositiveFacesTest(int faces){
        Dice dice = new Dice(faces);
        assertEquals(faces, dice.getFaces());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -34, -2})
    public void InstantiationNegativeFacesTest(int faces){
        assertThrows(ExceptionInInitializerError.class, () -> {
            Dice dice = new Dice(faces);
        });
    }

    @RepeatedTest(100)
    public void RollTest(){
        Dice dice = new Dice(6);
        int result = dice.roll();
        assertTrue(1 <= result && result <= 6);
    }

}
