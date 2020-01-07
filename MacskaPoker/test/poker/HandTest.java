/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import static java.lang.System.out;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Acer
 */
public class HandTest {
    
    public HandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of AddCard method, of class Hand.
     */
    @Test
    public void testAddCard1() {
        System.out.println("testAddCard1");
        String suit = "Spades";
        String rank = "Four";
        Hand myHand = new Hand();
        myHand.AddCard(suit, rank);
        myHand.print();
        int expResult = 1;
        int result = myHand.getNumberOfCards();
        assertEquals(expResult,result);
    }
    
    @Test
    public void testAddCard6() {
        System.out.println("testAddCard6");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "King");
        myHand.AddCard("Spades", "Ace");
        myHand.AddCard("Spades", "Jack");
        myHand.AddCard("Spades", "Queen");
        myHand.AddCard("Spades", "Ten");
        myHand.AddCard("Spades", "Four");
        myHand.print();
        assertEquals(5,myHand.getNumberOfCards());
    }
        @Test
    public void testAddSameCard() {
        System.out.println("testAddSameCard");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "King");
        myHand.AddCard("Diamonds", "Ace");
        myHand.AddCard("Spades", "King");
        myHand.print();
        int expResult = 2;
        int result = myHand.getNumberOfCards();
        assertEquals(expResult,result);
    }


    /**
     * Test of eval method, of class Hand. 
     */
    
    @Test
    public void testEvalRoyalFlushinSpades() {
        System.out.println("testEvalRoyalFlushinSpades");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "King");
        myHand.AddCard("Spades", "Ace");
        myHand.AddCard("Spades", "Jack");
        myHand.AddCard("Spades", "Queen");
        myHand.AddCard("Spades", "Ten");
        String expResult = "Royal flush in Spades";
        String result = myHand.eval();
        myHand.print();
        assertEquals(13, myHand.highestRankLowValue);
        assertEquals(10, myHand.lowestRankHighValue);
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalQueenHighStraightFlushinDiamonds() {
        System.out.println("testEvalQueenHighStraightFlushinDiamonds");
        Hand myHand = new Hand();
        myHand.AddCard("Diamonds", "Eight");
        myHand.AddCard("Diamonds", "Nine");
        myHand.AddCard("Diamonds", "Jack");
        myHand.AddCard("Diamonds", "Queen");
        myHand.AddCard("Diamonds", "Ten");
        String expResult = "Queen-high straight flush in Diamonds";
        String result = myHand.eval();
        myHand.print();
        assertEquals(12, myHand.highestRankLowValue);
        assertEquals(8, myHand.lowestRankHighValue);
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalFiveHighStraightFlushinClubs() {
        System.out.println("testEvalFiveHighStraightFlushinClubs");
        Hand myHand = new Hand();
        myHand.AddCard("Clubs", "Two");
        myHand.AddCard("Clubs", "Ace");
        myHand.AddCard("Clubs", "Three");
        myHand.AddCard("Clubs", "Four");
        myHand.AddCard("Clubs", "Five");
        String expResult = "Five-high straight flush in Clubs";
        String result = myHand.eval();
        myHand.print();
        assertEquals(5, myHand.highestRankLowValue);
        assertEquals(2, myHand.lowestRankHighValue);
        assertEquals(expResult,result);
     }

    @Test
    public void testEvalAceHighStraight() {
        System.out.println("testEvalAceHighStraight");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "King");
        myHand.AddCard("Diamonds", "Ace");
        myHand.AddCard("Clubs", "Jack");
        myHand.AddCard("Spades", "Queen");
        myHand.AddCard("Spades", "Ten");
        String expResult = "Ace-high straight";
        String result = myHand.eval();
        myHand.print();
        assertEquals(13, myHand.highestRankLowValue);
        assertEquals(10, myHand.lowestRankHighValue);
        assertEquals(expResult,result);
     }

    @Test
    public void testEvalFiveHighStraight() {
        System.out.println("testEvalFiveHighStraight");
        Hand myHand = new Hand();
        myHand.AddCard("Hearts", "Two");
        myHand.AddCard("Clubs", "Ace");
        myHand.AddCard("Clubs", "Three");
        myHand.AddCard("Clubs", "Four");
        myHand.AddCard("Clubs", "Five");
        String expResult = "Five-high straight";
        String result = myHand.eval();
        myHand.print();
        assertEquals(5, myHand.highestRankLowValue);
        assertEquals(2, myHand.lowestRankHighValue);
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalQueenHighStraight() {
        System.out.println("testEvalQueenHighStraight");
        Hand myHand = new Hand();
        myHand.AddCard("Hearts", "Eight");
        myHand.AddCard("Diamonds", "Nine");
        myHand.AddCard("Diamonds", "Jack");
        myHand.AddCard("Diamonds", "Queen");
        myHand.AddCard("Diamonds", "Ten");
        String expResult = "Queen-high straight";
        String result = myHand.eval();
        myHand.print();
        assertEquals(12, myHand.highestRankLowValue);
        assertEquals(8, myHand.lowestRankHighValue);
        assertEquals(expResult,result);
     }

    @Test
    public void testEvalFalseQueenHighStraight() {
        System.out.println("testEvalFalseQueenHighStraight");
// Szándékos komment!!!!
// Hát, basszus, ez a teszteset nem jutott eszembe.
// Úgy derült csak ki ez a rossz eset, hogy játszottam a kész programmal, és random generáltattam egy csomót
// Ezek ellen mi véd?
        Hand myHand = new Hand();
        myHand.AddCard("Hearts", "Eight");
        myHand.AddCard("Diamonds", "Eight");
        myHand.AddCard("Diamonds", "Jack");
        myHand.AddCard("Diamonds", "Queen");
        myHand.AddCard("Diamonds", "Ten");
        String expResult = "Pair of Eights";
        String result = myHand.eval();
        myHand.print();
        assertEquals(12, myHand.highestRankLowValue);
        assertEquals(8, myHand.lowestRankHighValue);
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalPoker4() {
        System.out.println("testEvalPoker4");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Hearts", "Four");
        myHand.AddCard("Diamonds", "Four");
        myHand.AddCard("Clubs", "Four");
        myHand.AddCard("Spades", "Ten");
        String expResult = "Poker, Fours";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalFull() {
        System.out.println("testEvalFull");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Hearts", "Four");
        myHand.AddCard("Diamonds", "Ten");
        myHand.AddCard("Clubs", "Ten");
        myHand.AddCard("Spades", "Ten");
        String expResult = "Full house, Tens over Fours";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalKingHighFlush() {
        System.out.println("testEvalKingHighFlush");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Spades", "King");
        myHand.AddCard("Spades", "Ten");
        myHand.AddCard("Spades", "Three");
        myHand.AddCard("Spades", "Queen");
        String expResult = "King-high flush in Spades";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }

    @Test
    public void testEvalAceHighFlush() {
        System.out.println("testEvalAceHighFlush");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Spades", "Ace");
        myHand.AddCard("Spades", "Ten");
        myHand.AddCard("Spades", "Three");
        myHand.AddCard("Spades", "Queen");
        String expResult = "Ace-high flush in Spades";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalDrill() {
        System.out.println("testEvalDrill");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Hearts", "King");
        myHand.AddCard("Diamonds", "Ten");
        myHand.AddCard("Clubs", "Ten");
        myHand.AddCard("Spades", "Ten");
        String expResult = "Drill of Tens";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalTwoPair() {
        System.out.println("testEvalTwoPair");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Clubs", "Ten");
        myHand.AddCard("Spades", "Ten");
        myHand.AddCard("Hearts", "King");
        myHand.AddCard("Diamonds", "King");
        String expResult = "Two pair, Kings over Tens";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalOnePair() {
        System.out.println("testEvalOnePair");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Hearts", "King");
        myHand.AddCard("Diamonds", "Ace");
        myHand.AddCard("Clubs", "Ten");
        myHand.AddCard("Spades", "Ten");
        String expResult = "Pair of Tens";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }

    @Test
    public void testEvalHighCardAce() {
        System.out.println("testEvalOnePair");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Hearts", "King");
        myHand.AddCard("Diamonds", "Ace");
        myHand.AddCard("Clubs", "Five");
        myHand.AddCard("Spades", "Ten");
        String expResult = "High card, Ace";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }

    @Test
    public void testEvalHighCardKing() {
        System.out.println("testEvalOnePair");
        Hand myHand = new Hand();
        myHand.AddCard("Spades", "Four");
        myHand.AddCard("Hearts", "King");
        myHand.AddCard("Diamonds", "Nine");
        myHand.AddCard("Clubs", "Five");
        myHand.AddCard("Spades", "Ten");
        String expResult = "High card, King";
        String result = myHand.eval();
        myHand.print();
        assertEquals(expResult,result);
     }

    
    /**
     * Test of print method, of class Hand.
     */
    @Test
    public void testPrintEmptyHand() {
        System.out.println("testPrintEmptyHand");
        Hand myHand = new Hand();
        myHand.print();
    }

        
}
