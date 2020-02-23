package game21;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Game21Test {
    public Game21 game;

    @Before
    public void setUp() throws Exception {
        game = new Game21();
    }

    @Test
    public void evalHandTest() {
        List<Integer> hand = Arrays.asList(7);
        Integer score = game.eval(hand);
        Integer expected = 7;
        assertEquals(expected,score);
    }
}