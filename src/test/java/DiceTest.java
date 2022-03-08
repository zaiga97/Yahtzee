import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceTest {
    @Test
    public void InstantiationSixFacesTest(){
        Dice dice = new Dice(6);

        assertEquals(6, dice.getNumberFaces());
    }

    @Test
    public void InstantiationFiveFacesTest(){
        Dice dice = new Dice(5);

        assertEquals(5, dice.getNumberFaces());
    }
}
