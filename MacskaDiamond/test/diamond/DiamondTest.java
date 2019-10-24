/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diamond;

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
public class DiamondTest {
    
    public DiamondTest() {
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
     * Test of main method, of class Diamond.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Diamond.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of drawNthRowofNdiamond method, of class Diamond.
     */
    @Test
    public void testDraw1stRowof1diamond() {
        System.out.println("testDraw1stRowof1diamond");
        int pN = 1;
        String expect = "1";
        String result = Diamond.drawNthRowofNdiamond(pN,1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(expect,result);
    }
    
    @Test
    public void testDraw1stRowof3diamond() {
        System.out.println("testDraw1stRowof3diamond");
        int pN = 3;
        String expect = "  1";
        String result = Diamond.drawNthRowofNdiamond(pN,1);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(expect,result);
    }

    @Test
    public void testDraw2ndRowof3diamond() {
        System.out.println("testDraw2ndRowof3diamond");
        int pN = 3;
        String expect = " 121";
        String result = Diamond.drawNthRowofNdiamond(pN,2);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(expect,result);
    }
    
    @Test
    public void testDraw5ndRowof5diamond() {
        System.out.println("testDraw5ndRowof5diamond");
        int pN = 5;
        String expect = "123454321";
        String result = Diamond.drawNthRowofNdiamond(pN,5);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        assertEquals(expect,result);
    }

    /**
     * Test of drawNthRowofNdiamond method, of class Diamond.
     */
    @Test
    public void drawDiamond5rows() {
        System.out.println("drawDiamond5rows");
        int pR = 5;
        String expResult = "    1" + "\n" +
                           "   121"  + "\n" +
                           "  12321"  + "\n" +
                           " 1234321"  + "\n" +
                           "123454321"  + "\n" +
                           " 1234321"  + "\n" +
                           "  12321"  + "\n" +
                           "   121"  + "\n" +
                           "    1" + "\n";
        String result = Diamond.drawDiamond(pR);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
}
