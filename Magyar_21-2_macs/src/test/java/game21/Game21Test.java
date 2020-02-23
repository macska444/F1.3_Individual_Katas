package game21;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class Game21Test {
    public Game21 game;

    @Before
    public void setUp() throws Exception {
        game = new Game21();
    }

    @Test
    public void evalHandTest() {
        List<Integer> hand = Arrays.asList(MagyarkartyaRank.VII.value);
        Integer score = game.evalHand(hand);
        Integer expected = 7;
        assertEquals(expected, score);
    }

    @Test
    public void evalHandWith2CardsTest() {
        List<Integer> hand = Arrays.asList(MagyarkartyaRank.VII.value, MagyarkartyaRank.KIRALY.value);
        Integer score = game.evalHand(hand);
        Integer expected = 11;
        assertEquals(expected, score);
    }

    @Test
    public void evalHandNotEnoughTest() {
        List<Integer> hand = Arrays.asList(MagyarkartyaRank.VII.value, MagyarkartyaRank.KIRALY.value);
        HandType type = game.evalHandType(hand);
        HandType expected = HandType.NOT_ENOUGH;
        assertEquals(expected, type);
    }
}