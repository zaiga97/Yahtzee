import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DiceTest {
    @Test
    public void InstantiationSixFacesTest(){
        Dice dice = new Dice(6);

        assertEquals(6, dice.getFaces());
    }

    @Test
    public void InstantiationFiveFacesTest(){
        Dice dice = new Dice(5);

        assertEquals(5, dice.getFaces());
    }

    @Test()
    public void InstantiationNegativeFacesTest(){
        assertThrows(ExceptionInInitializerError.class, () -> {
            Dice dice = new Dice(-1);
        });
    }
}
