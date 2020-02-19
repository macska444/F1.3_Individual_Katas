package fizzbuzz1;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RulesTest {
    private static Rules myRules;
    
    
    @BeforeClass
    public static void setUpClass() {
        myRules = new Rules();
    }

    @Test
    public void testAddRule3Macska() {
         myRules.addRule(3,"Macska");
         assertEquals( "Macska", myRules.getRule(3));
     }

    @Test
    public void testAdd5and7Rule() {
        myRules.addRule(5,"Lili");
        assertEquals( "Lili", myRules.getRule(5));
        myRules.addRule(7,"Lala");
        assertEquals( "Lala", myRules.getRule(7));
     }
    
}
