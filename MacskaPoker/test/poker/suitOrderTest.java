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
public class suitOrderTest {
    
    public suitOrderTest() {
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
    public void testgetSuitValueSpades() {
        System.out.println("testgetSuitValueSpades");
        String suit = "Spades";
        int expResult = 1;
        int result = suitOrder.getSuitValueByName(suit);
        assertEquals(expResult, result);
    
    }
    @Test
    public void testgetSuitValueDiamonds() {
        System.out.println("testgetSuitValueDiamonds");
        String suit = "Diamonds";
        int expResult = 3;
        int result = suitOrder.getSuitValueByName(suit);
        assertEquals(expResult, result);   
    }
    
}
