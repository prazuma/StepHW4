import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by hashimotomika on 6/22/15.
 */
public class RollDiceTest {
    
    @Test
    public void testProbabilityDice() throws Exception {
        assertTrue(RollDice.probabilityDice(1));
        assertTrue(RollDice.probabilityDice(2));
        assertTrue(RollDice.probabilityDice(3));
        assertTrue(RollDice.probabilityDice(4));
        assertTrue(RollDice.probabilityDice(5));
        assertTrue(RollDice.probabilityDice(6));
    }
}