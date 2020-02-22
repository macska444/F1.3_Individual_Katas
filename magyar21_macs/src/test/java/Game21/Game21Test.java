package Game21;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Game21Test {
    @Test
    public void evaluateHandTest () {
        Game21 game = new Game21();
        List<Integer> hand = Arrays.asList(7);
        Integer result = game.evaluate(hand);
        Integer expect = 7;
        assertEquals(result, expect);
    }
}