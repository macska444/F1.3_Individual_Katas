package com.company;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PokerHandTest {

    @Test
    public void evaluatePairTest(){
        PokerHand ph = new PokerHand(
            Arrays.asList(
                    new Card(CardSign.EIGHT,Color.CLUB),
                    new Card(CardSign.EIGHT,Color.DIAMOND),
                    new Card(CardSign.FIVE,Color.CLUB),
                    new Card(CardSign.SIX,Color.CLUB),
                    new Card(CardSign.SEVEN,Color.CLUB)
            ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.ONE_PAIR,result.getCardCombination());
    }

    @Test
    public void evaluateTwoPairTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.EIGHT,Color.CLUB),
                        new Card(CardSign.EIGHT,Color.DIAMOND),
                        new Card(CardSign.FIVE,Color.CLUB),
                        new Card(CardSign.FIVE,Color.CLUB),
                        new Card(CardSign.SIX,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.TWO_PAIR,result.getCardCombination());
    }

    @Test
    public void evaluateDrillTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.EIGHT,Color.CLUB),
                        new Card(CardSign.EIGHT,Color.DIAMOND),
                        new Card(CardSign.EIGHT,Color.CLUB),
                        new Card(CardSign.FIVE,Color.CLUB),
                        new Card(CardSign.SIX,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.THREE_OF_KIND,result.getCardCombination());
    }

    @Test
    public void evaluateFullHouseTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.EIGHT,Color.CLUB),
                        new Card(CardSign.EIGHT,Color.DIAMOND),
                        new Card(CardSign.EIGHT,Color.CLUB),
                        new Card(CardSign.FIVE,Color.CLUB),
                        new Card(CardSign.FIVE,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.FULL_HOUSE,result.getCardCombination());
    }


    @Test
    public void evaluateFourOfKindTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.EIGHT,Color.CLUB),
                        new Card(CardSign.EIGHT,Color.DIAMOND),
                        new Card(CardSign.EIGHT,Color.CLUB),
                        new Card(CardSign.EIGHT,Color.CLUB),
                        new Card(CardSign.FIVE,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.FOUR_OF_KIND,result.getCardCombination());
    }

    @Test
    public void evaluateStraightTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.SIX,Color.CLUB),
                        new Card(CardSign.FOUR,Color.DIAMOND),
                        new Card(CardSign.FIVE,Color.CLUB),
                        new Card(CardSign.TWO,Color.CLUB),
                        new Card(CardSign.THREE,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.STRAIGHT,result.getCardCombination());
    }

    @Test
    public void evaluateStraightWithAceFirstTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.ACE,Color.CLUB),
                        new Card(CardSign.FOUR,Color.DIAMOND),
                        new Card(CardSign.FIVE,Color.CLUB),
                        new Card(CardSign.TWO,Color.CLUB),
                        new Card(CardSign.THREE,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.STRAIGHT,result.getCardCombination());
    }

    @Test
    public void evaluateStraighFlushtTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.SIX,Color.CLUB),
                        new Card(CardSign.FOUR,Color.CLUB),
                        new Card(CardSign.FIVE,Color.CLUB),
                        new Card(CardSign.TWO,Color.CLUB),
                        new Card(CardSign.THREE,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.STRAIGHT_FLUSH,result.getCardCombination());
    }

    @Test
    public void evaluateFlushtTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.ACE,Color.CLUB),
                        new Card(CardSign.TEN,Color.CLUB),
                        new Card(CardSign.FIVE,Color.CLUB),
                        new Card(CardSign.TWO,Color.CLUB),
                        new Card(CardSign.THREE,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.FLUSH,result.getCardCombination());
    }


    @Test
    public void evaluateRoyalFlushtTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.ACE,Color.CLUB),
                        new Card(CardSign.JACK,Color.CLUB),
                        new Card(CardSign.KING,Color.CLUB),
                        new Card(CardSign.QEEN,Color.CLUB),
                        new Card(CardSign.TEN,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.ROYAL_FLUSH,result.getCardCombination());
    }


    @Test
    public void evaluateNoneTest(){
        PokerHand ph = new PokerHand(
                Arrays.asList(
                        new Card(CardSign.FIVE,Color.DIAMOND),
                        new Card(CardSign.JACK,Color.CLUB),
                        new Card(CardSign.KING,Color.CLUB),
                        new Card(CardSign.QEEN,Color.CLUB),
                        new Card(CardSign.TEN,Color.CLUB)
                ));
        Result result = ph.evaluate();
        assertEquals(CardCombination.NONE,result.getCardCombination());
    }
}