package magyar21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {
    protected Hand hand;

    @Before
    public void setUp() throws Exception {
        hand = new Hand();
    }

    @Test
    public void evaluateHand1CardTest() {
        hand = new Hand();
        hand.addCard(7);
        Integer expected = 7;
        hand.evaluateHand();
        assertEquals(expected, hand.getSumOfCards());
    }

    @Test(expected = EmptyHandException.class)
    public void evalHandEmptyTest() {
        hand = new Hand();
        hand.evaluateHand();
    }

    @Test(expected = InvalidCardRank.class)
    public void evalHandHasInvalidCardRanksTest() {
        hand = new Hand();
        hand.addCard(7);
        hand.addCard(4);
        hand.addCard(1);
        hand.evaluateHand();
    }

    @Test
    public void evalHandHas3ValidCardRanksTest() {
        hand = new Hand();
        hand.addCard(7);
        hand.addCard(4);
        hand.addCard(2);
        hand.evaluateHand();
        Integer expectedSumOfCards = 13;
        Integer expectedNumberOfCards = 3;
        String expectedScore = HandScores.MAY_HIT_OR_STAND.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());

    }

    @Test
    public void evalHandHas21Test() {
        hand = new Hand();
        hand.addCard(11);
        hand.addCard(10);
        hand.evaluateHand();
        Integer expectedSumOfCards = 21;
        Integer expectedNumberOfCards = 2;
        String expectedScore = HandScores.BLACKJACK.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
    }

    @Test
    public void evalHandHasBustTest() {
        hand = new Hand();
        hand.addCard(11);
        hand.addCard(7);
        hand.addCard(8);
        hand.evaluateHand();
        Integer expectedSumOfCards = 26;
        Integer expectedNumberOfCards = 3;
        String expectedScore = HandScores.BUST.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
    }

    @Test
    public void evalHandHas21From2AceTest() {
        hand = new Hand();
        hand.addCard(11);
        hand.addCard(11);
        hand.evaluateHand();
        Integer expectedSumOfCards = 22;
        Integer expectedNumberOfCards = 2;
        String expectedScore = HandScores.BLACKJACK.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
    }
}