package poker;

import org.junit.*;
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
     * Test of getRankValueByName method, of class rankOrder.
     */
    @Test
    public void testGetRankValueAce() {
        System.out.println("getRankValueAce");
        String rankName = "Ace";
        int expResult = 14;
        int result = rankOrder.getRankValueByName(rankName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetRankValueSix() {
        System.out.println("getRankValueSix");
        String rankName = "Six";
        int expResult = 6;
        int result = rankOrder.getRankValueByName(rankName);
        assertEquals(expResult, result);
    }
    @Test
    public void testGetRankNameKing() {
        System.out.println("testGetRankNameKing");
        int rankValue = 13;
        String expResult = "King";
        String result = rankOrder.getRankNameByValue(rankValue);
        assertEquals(expResult, result);
    }
   
}
