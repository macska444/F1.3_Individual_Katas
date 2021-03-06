package magyar21;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HandTest {
    protected Hand hand;

    @Before
    public void setUp() throws Exception {
        hand = new Hand();
    }

    @Test
    public void evaluateHand1CardTest() {
        hand = new Hand();
        hand.addCard(HunCardRanks.VII.getValue());
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
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.KIRALY.getValue());
        hand.addCard(1);
        hand.evaluateHand();
    }

    @Test
    public void evalHandHas3ValidCardRanksTest() {
        hand = new Hand();
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.KIRALY.getValue());
        hand.addCard(HunCardRanks.VIII.getValue());
        hand.evaluateHand();
        Integer expectedSumOfCards = 19;
        Integer expectedNumberOfCards = 3;
        String expectedScore = HandScores.MAY_HIT_OR_STAND.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
    }

    @Test
    public void evalHandHasNotEnoughTest() {
        hand = new Hand();
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.KIRALY.getValue());
        hand.addCard(HunCardRanks.ALSO.getValue());
        hand.evaluateHand();
        Integer expectedSumOfCards = 13;
        Integer expectedNumberOfCards = 3;
        String expectedScore = HandScores.MUST_HIT.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
    }

    @Test
    public void evalHandHas21Test() {
        hand = new Hand();
        hand.addCard(HunCardRanks.ASZ.getValue());
        hand.addCard(HunCardRanks.X.getValue());
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
        hand.addCard(HunCardRanks.ASZ.getValue());
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.VIII.getValue());
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
        hand.addCard(HunCardRanks.ASZ.getValue());
        hand.addCard(HunCardRanks.ASZ.getValue());
        hand.evaluateHand();
        Integer expectedSumOfCards = 22;
        Integer expectedNumberOfCards = 2;
        String expectedScore = HandScores.BLACKJACK.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
    }

    @Test
    public void evalHandHas22NotFrom2AceTest() {
        hand = new Hand();
        hand.addCard(HunCardRanks.ASZ.getValue());
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.KIRALY.getValue());
        hand.evaluateHand();
        Integer expectedSumOfCards = 22;
        Integer expectedNumberOfCards = 3;
        String expectedScore = HandScores.BUST.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
    }

    @Test
    public void rightWithoutAceTest() {
        hand = new Hand();
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.KIRALY.getValue());
        hand.evaluateHand();
        hand.playerSaysWithoutAce();
        Integer expectedSumOfCards = 11;
        Integer expectedNumberOfCards = 2;
        String expectedScore = HandScores.MUST_HIT.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
        assertTrue(hand.isWithoutAce());
    }

    @Test(expected = WrongWithoutAce.class)
    public void wrongWithout2AceTest() {
        hand = new Hand();
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.VIII.getValue());
        hand.evaluateHand();
        hand.playerSaysWithoutAce();
    }

    @Test
    public void gotAceAfterWithoutAceTest() {
        hand = new Hand();
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.KIRALY.getValue());
        hand.evaluateHand();
        hand.playerSaysWithoutAce();
        hand.addCard(HunCardRanks.ASZ.getValue());
        hand.evaluateHand();

        Integer expectedSumOfCards = 22;
        Integer expectedNumberOfCards = 3;
        String expectedScore = HandScores.MAY_GET_NEW_HAND.toString();
        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertTrue(hand.isWithoutAce());
        assertEquals(expectedScore, hand.getActualScore());
    }

    @Test
    public void handHasMoreThen5ButNotBustTest() {
        hand = new Hand();
        hand.addCard(HunCardRanks.VII.getValue());
        hand.addCard(HunCardRanks.KIRALY.getValue());
        hand.addCard(HunCardRanks.ALSO.getValue());
        hand.addCard(HunCardRanks.FELSO.getValue());
        hand.addCard(HunCardRanks.ALSO.getValue());
        hand.evaluateHand();
        Integer expectedSumOfCards = 18;
        Integer expectedNumberOfCards = 5;
        String expectedScore = HandScores.MAY_GET_NEW_HAND.toString();

        assertEquals(expectedSumOfCards, hand.getSumOfCards());
        assertEquals(expectedNumberOfCards, hand.getNumberOfCards());
        assertEquals(expectedScore, hand.getActualScore());
    }


}