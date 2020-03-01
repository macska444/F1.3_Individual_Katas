package magyar21;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HandTest {
    protected Hand hand;

    @Before
    public void setUp() throws Exception {
        hand = new Hand();
    }

    @Test
    public void evaluateHand1CardTest() {
        List<Integer> myHand = Arrays.asList(7);
        Integer expected = 7;
        assertEquals(expected, hand.evaluateHand(myHand));
    }

    @Test(expected = EmptyHandException.class)
    public void evalHandEmptyTest() {
        List<Integer> myHand = null;
        hand.evaluateHand(myHand);
    }

    @Test(expected = InvalidCardRank.class)
    public void evalHandHasInvalidCardRanksTest() {
        List<Integer> myHand = Arrays.asList(7, 4, 1);
        hand.evaluateHand(myHand);
    }
}