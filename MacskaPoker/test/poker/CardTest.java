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
 * @author Macska
 */
public class CardTest {
    
    public CardTest() {
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

    @Test
    public void testConstructorAce() {
        Card myCard= new Card("Spade","Ace");
        System.out.println(myCard.rankHighValue + " " + myCard.rankLowValue + " " + myCard.rankName + " " + myCard.suit);
        
    }
    
    @Test
    public void testConstructorKing() {
//        rankOrder.inic();        
        Card myCard= new Card("Heart","King");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(myCard.rankHighValue + " " + myCard.rankLowValue + " " + myCard.rankName + " " + myCard.suit);
    }
    @Test
    public void testConstructorFour() {
//        rankOrder.inic();        
        Card myCard= new Card("Diamond","Four");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        System.out.println(myCard.rankHighValue + " " + myCard.rankLowValue + " " + myCard.rankName + " " + myCard.suit);
    }

}
