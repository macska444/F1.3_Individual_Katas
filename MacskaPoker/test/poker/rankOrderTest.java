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
public class rankOrderTest {
    
    public rankOrderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
     * Test of getRankValue method, of class rankOrder.
     */
    @Test
    public void testGetRankValueAce() {
        System.out.println("getRankValue");
//        rankOrder.inic();
        String pRankSymbol = "A";
        int expResult = 14;
        int result = rankOrder.getRankValue(pRankSymbol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testGetRankValueSix() {
        System.out.println("getRankValue");
//        rankOrder.inic();
        String pRankSymbol = "6";
        int expResult = 6;
        int result = rankOrder.getRankValue(pRankSymbol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testGetRankNameKing() {
        System.out.println("testGetRankNameKing");
//        rankOrder.inic();
        int pRankValue = 13;
        String expResult = "K";
        String result = rankOrder.getRankName(pRankValue);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
   
}
