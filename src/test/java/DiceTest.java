import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiceTest {
    @Test
    public void InstantiationTest(){
        Dice dice = new Dice(6);

        assertEquals(6, dice.getNumberFaces());
    }
}
