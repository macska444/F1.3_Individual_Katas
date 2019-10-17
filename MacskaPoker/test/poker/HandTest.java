/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

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
        suitOrder.inic();
        rankOrder.inic();
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
        System.out.println("Add 1 Card");
        String pSuit = "Spade";
        String pRank = "4";
        Hand myHand = new Hand();
        myHand.AddCard(pSuit, pRank);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(myHand.cards.get(0).suit + " " + myHand.cards.get(0).rankSymbol);
    }
    @Test
    public void testAddCard6() {
        System.out.println("Add 6 Card");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "K");
        myHand.AddCard("Spade", "A");
        myHand.AddCard("Spade", "J");
        myHand.AddCard("Spade", "Q");
        myHand.AddCard("Spade", "10");
        myHand.AddCard("Spade", "4");
        System.out.println(myHand.cards.size());
        assertEquals(5,myHand.cards.size());
    }

    /**
     * Test of eval method, of class Hand. 
     */
    @Test
    public void testEvalHighStraightFlushinSpade() {
        System.out.println("eval");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "K");
        myHand.AddCard("Spade", "A");
        myHand.AddCard("Spade", "J");
        myHand.AddCard("Spade", "Q");
        myHand.AddCard("Spade", "10");
        String expResult = "Straight flush starting with 10 in Spade";
        String result = myHand.eval();
        System.out.println(result);
        System.out.println(myHand.highestRank + " " + myHand.lowestRank);
        System.out.println("Number of Kings: " + myHand.countRank.get(13));
        assertEquals(13, myHand.highestRank);
        assertEquals(10, myHand.lowestRank);
        assertEquals(expResult,result);
     }

    @Test
    public void testEvalHighStraight() {
        System.out.println("eval");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "K");
        myHand.AddCard("Diamond", "A");
        myHand.AddCard("Club", "J");
        myHand.AddCard("Spade", "Q");
        myHand.AddCard("Spade", "10");
        String expResult = "Straight starting with 10";
        String result = myHand.eval();
        System.out.println(result);
        System.out.println(myHand.highestRank + " " + myHand.lowestRank);
        System.out.println("Number of Kings: " + myHand.countRank.get(13));
        assertEquals(13, myHand.highestRank);
        assertEquals(10, myHand.lowestRank);
        assertEquals(expResult,result);
     }
    
    @Test
    public void testEvalPoker4() {
        System.out.println("eval");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "4");
        myHand.AddCard("Heart", "4");
        myHand.AddCard("Diamond", "4");
        myHand.AddCard("Club", "4");
        myHand.AddCard("Spade", "10");
        String expResult = "Poker in 4";
        String result = myHand.eval();
        System.out.println(result);
        System.out.println(myHand.highestRank + " " + myHand.lowestRank);
        System.out.println("Number of Kings: " + myHand.countRank.get(13));
        assertEquals(expResult,result);
     }
    @Test
    public void testEvalFull() {
        System.out.println("eval");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "4");
        myHand.AddCard("Heart", "4");
        myHand.AddCard("Diamond", "10");
        myHand.AddCard("Club", "10");
        myHand.AddCard("Spade", "10");
        String expResult = "Full";
        String result = myHand.eval();
        System.out.println(result);
        System.out.println(myHand.highestRank + " " + myHand.lowestRank);
        System.out.println("Number of Kings: " + myHand.countRank.get(13));
        assertEquals(expResult,result);
     }
    @Test
    public void testEvalFlush() {
        System.out.println("eval");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "4");
        myHand.AddCard("Spade", "K");
        myHand.AddCard("Spade", "10");
        myHand.AddCard("Spade", "3");
        myHand.AddCard("Spade", "Q");
        String expResult = "Flush in Spade";
        String result = myHand.eval();
        System.out.println(result);
        System.out.println(myHand.highestRank + " " + myHand.lowestRank);
        System.out.println("Number of Kings: " + myHand.countRank.get(13));
        assertEquals(expResult,result);
     }
    @Test
    public void testEvalDrill() {
        System.out.println("eval");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "4");
        myHand.AddCard("Heart", "K");
        myHand.AddCard("Diamond", "10");
        myHand.AddCard("Club", "10");
        myHand.AddCard("Spade", "10");
        String expResult = "Drill";
        String result = myHand.eval();
        System.out.println(result);
        System.out.println(myHand.highestRank + " " + myHand.lowestRank);
        System.out.println("Number of Kings: " + myHand.countRank.get(13));
        assertEquals(expResult,result);
     }
    @Test
    public void testEvalTwoPairs() {
        System.out.println("eval");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "4");
        myHand.AddCard("Heart", "K");
        myHand.AddCard("Diamond", "K");
        myHand.AddCard("Club", "10");
        myHand.AddCard("Spade", "10");
        String expResult = "Two pairs";
        String result = myHand.eval();
        System.out.println(result);
        System.out.println(myHand.highestRank + " " + myHand.lowestRank);
        System.out.println("Number of Kings: " + myHand.countRank.get(13));
        assertEquals(expResult,result);
     }
    @Test
    public void testEvalPair() {
        System.out.println("eval");
        Hand myHand = new Hand();
        myHand.AddCard("Spade", "4");
        myHand.AddCard("Heart", "K");
        myHand.AddCard("Diamond", "A");
        myHand.AddCard("Club", "10");
        myHand.AddCard("Spade", "10");
        String expResult = "Pair";
        String result = myHand.eval();
        System.out.println(result);
        System.out.println(myHand.highestRank + " " + myHand.lowestRank);
        System.out.println("Number of Kings: " + myHand.countRank.get(13));
        assertEquals(expResult,result);
     }

        
}
