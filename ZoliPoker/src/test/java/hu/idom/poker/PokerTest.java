/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.idom.poker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author szarvas
 */
public class PokerTest {
    
    private PokerService pokerService;
    
    public PokerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 2),
                                                  new Card(Card.SZIN.KARO, 3),
                                                  new Card(Card.SZIN.KOR, 10),
                                                  new Card(Card.SZIN.PIKK, 5),
                                                  new Card(Card.SZIN.TREFF, 6));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void rendezesTeszt() {
        //System.out.println(""+kiertekeloService.getCardList());
        pokerService.sort();
        //System.out.println(""+kiertekeloService.getCardList());
        int elozoErtek = 0;
        for (Card card : pokerService.getCardList()) {
            assertTrue(elozoErtek <= card.getErtek());
            elozoErtek = card.getErtek();
        }
    }

    @Test
    public void parTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.PIKK, 2),
                                                  new Card(Card.SZIN.KARO, 3),
                                                  new Card(Card.SZIN.KOR, 10),
                                                  new Card(Card.SZIN.TREFF, 13),
                                                  new Card(Card.SZIN.KARO, 10));
        assertEquals(1, pokerService.getPar());
        assertNotEquals(2, pokerService.getPar());
        assertNotEquals(0, pokerService.getPar());
        assertFalse(pokerService.getDrill());
        assertFalse(pokerService.getFlush());
        assertFalse(pokerService.getFullHouse());
        assertFalse(pokerService.getPoker());
        assertFalse(pokerService.getRoyalFlush());
        assertFalse(pokerService.getSzinSor());
    }
    
    @Test
    public void duplaparTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.PIKK, 2),
                                                  new Card(Card.SZIN.KARO, 2),
                                                  new Card(Card.SZIN.KOR, 10),
                                                  new Card(Card.SZIN.TREFF, 6),
                                                  new Card(Card.SZIN.KARO, 6));
        assertEquals(2, pokerService.getPar());
    }
    
    @Test
    public void drillTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 3),
                                                  new Card(Card.SZIN.PIKK, 3),
                                                  new Card(Card.SZIN.KOR, 3),
                                                  new Card(Card.SZIN.PIKK, 8),
                                                  new Card(Card.SZIN.TREFF, 12));
        assertTrue(pokerService.getDrill());
        assertFalse(pokerService.getFlush());
        assertFalse(pokerService.getRoyalFlush());
        assertFalse(pokerService.getPoker());
    }
    
    @Test
    public void sorTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 2),
                                                  new Card(Card.SZIN.KARO, 3),
                                                  new Card(Card.SZIN.KOR, 4),
                                                  new Card(Card.SZIN.PIKK, 5),
                                                  new Card(Card.SZIN.TREFF, 6));
        assertTrue(pokerService.getSor());
    }
    
    @Test
    public void szinSorTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 2),
                                                  new Card(Card.SZIN.KARO, 3),
                                                  new Card(Card.SZIN.KARO, 4),
                                                  new Card(Card.SZIN.KARO, 5),
                                                  new Card(Card.SZIN.KARO, 6));
        assertTrue(pokerService.getSzinSor());
    }
    
    @Test
    public void flushTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 2),
                                                  new Card(Card.SZIN.KARO, 6),
                                                  new Card(Card.SZIN.KARO, 4),
                                                  new Card(Card.SZIN.KARO, 10),
                                                  new Card(Card.SZIN.KARO, 9));
        assertTrue(pokerService.getFlush());
    }
    
    @Test
    public void pokerTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 12),
                                                new Card(Card.SZIN.KARO, 10),
                                                  new Card(Card.SZIN.KOR, 10),
                                                  new Card(Card.SZIN.PIKK, 10),
                                                  new Card(Card.SZIN.TREFF, 10)
                                                  );
        assertTrue(pokerService.getPoker());
    }
    
    @Test
    public void fullHouseTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 12),
                                                new Card(Card.SZIN.PIKK, 12),
                                                  new Card(Card.SZIN.KOR, 12),
                                                  new Card(Card.SZIN.PIKK, 10),
                                                  new Card(Card.SZIN.TREFF, 10)
                                                  );
        System.out.println("fullhouse");
        assertTrue(pokerService.getFullHouse());
    }
    
    @Test
    public void royalFlushTeszt(){
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 10),
                                                new Card(Card.SZIN.KARO, 11),
                                                  new Card(Card.SZIN.KARO, 12),
                                                  new Card(Card.SZIN.KARO, 13),
                                                  new Card(Card.SZIN.KARO, 14)
                                                  );
        assertTrue(pokerService.getRoyalFlush());
    }
    
    @Test
    public void kiertekeloTest(){
        pokerService = new PokerService(new Card(Card.SZIN.KARO, 10),
                                                new Card(Card.SZIN.KARO, 11),
                                                  new Card(Card.SZIN.KARO, 12),
                                                  new Card(Card.SZIN.KARO, 13),
                                                  new Card(Card.SZIN.KARO, 14)
                                                  );
        System.out.println("2^9: "+(Math.pow(2, 9)));
        assertEquals(512, pokerService.kiertekelo());
    }
}
