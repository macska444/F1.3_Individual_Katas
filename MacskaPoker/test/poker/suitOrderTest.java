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
public class suitOrderTest {
    
    public suitOrderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        suitOrder.inic();
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
    public void testSpade() {
        System.out.println("getSuitValue Spade");
        String pSuit = "Spade";
        int expResult = 1;
        int result = suitOrder.getSuitValue(pSuit);
        assertEquals(expResult, result);
    
    }
    @Test
    public void testDiamond() {
        System.out.println("getSuitValue Diamond");
        String pSuit = "Diamond";
        int expResult = 3;
        int result = suitOrder.getSuitValue(pSuit);
        assertEquals(expResult, result);
    
    }
    
}
