package poker;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import poker.Lap;
import poker.LapComparator;
import poker.Poker;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author singer
 */
public class PokerTest {

    Poker poker = new Poker();
    public ArrayList<Lap> kez2 = new ArrayList<Lap>(5);
    public ArrayList<Lap> kez3 = new ArrayList<Lap>(5);
    public ArrayList<Lap> kez4 = new ArrayList<Lap>(5);
    public ArrayList<Lap> kez5 = new ArrayList<Lap>(5);
    public ArrayList<Lap> kez6 = new ArrayList<Lap>(5);
    public ArrayList<Lap> kez7 = new ArrayList<Lap>(5);

    @Before
    public void setUp() {
//        kez2[0].ertek = 1;
//        kez2[0].szin = 0;
        kez2.add(0, new Lap(0, 1));
        kez2.add(1, new Lap(1, 5));
        kez2.add(2, new Lap(2, 1));
        kez2.add(3, new Lap(3, 10));
        kez2.add(4, new Lap(2, 9));
        
        kez3.add(0, new Lap(0, 1));
        kez3.add(1, new Lap(1, 2));
        kez3.add(2, new Lap(2, 3));
        kez3.add(3, new Lap(3, 4));
        kez3.add(4, new Lap(2, 5));
        
        kez4.add(0, new Lap(0, 1));
        kez4.add(1, new Lap(1, 2));
        kez4.add(2, new Lap(1, 1));
        kez4.add(3, new Lap(3, 1));
        kez4.add(4, new Lap(2, 1));
        
        kez5.add(0, new Lap(0, 2));
        kez5.add(1, new Lap(1, 2));
        kez5.add(2, new Lap(1, 1));
        kez5.add(3, new Lap(3, 1));
        kez5.add(4, new Lap(2, 1));
        
        kez6.add(0, new Lap(0, 0));
        kez6.add(1, new Lap(1, 12));
        kez6.add(2, new Lap(1, 11));
        kez6.add(3, new Lap(3, 10));
        kez6.add(4, new Lap(2, 13));
        
        kez7.add(0, new Lap(0, 8));
        kez7.add(1, new Lap(0, 7));
        kez7.add(2, new Lap(2, 1));
        kez7.add(3, new Lap(0, 1));
        kez7.add(4, new Lap(3, 1));
    }

    @Test
    public void testRendez() {
        kez2.sort(new LapComparator());
        assertTrue(kez2.get(4).ertek==1);
        assertTrue(kez2.get(3).ertek==1);
        assertTrue(kez2.get(2).ertek==5);
        assertTrue(kez2.get(1).ertek==9);
        assertTrue(kez2.get(0).ertek==10);
    }
    
    @Test
    public void testSzinEgyezes() {
        
        assertFalse(poker.egySzinVizsgalat(kez2));
        for (Lap lap : kez2) {
            lap.szin=0;
        }
        assertTrue(poker.egySzinVizsgalat(kez2));
    }
    
    @Test
    public void testSzamsor() {    
        assertFalse(poker.sorVizsgalat(kez2));
        
        kez3.sort(new LapComparator());;
        assertTrue(poker.sorVizsgalat(kez3));
    }
    
    @Test
    public void testPoker() {    
        assertFalse(poker.pokerVizsgalat(kez2));
        
        kez4.sort(new LapComparator());
        assertTrue(poker.pokerVizsgalat(kez4));
    }
    
    @Test
    public void testPar() {    
        kez3.sort(new LapComparator());
        assertTrue(poker.parVizsgalat(kez3)[0] == -1);
        assertTrue(poker.parVizsgalat(kez3)[1] == -1);
        
        kez2.sort(new LapComparator());
        assertTrue(poker.parVizsgalat(kez2)[0] != -1);
        assertTrue(poker.parVizsgalat(kez2)[0] == 1);
        assertTrue(poker.parVizsgalat(kez2)[1] == -1);
    }
    
    @Test
    public void testFull(){
        kez7.sort(new LapComparator());
        assertFalse(poker.fullVizsgalat(kez7));
        
        kez5.sort(new LapComparator());
        assertTrue(poker.fullVizsgalat(kez5));
    }
    
    @Test
    public void testSorVizsgalat(){
        kez6.sort(new LapComparator());
        assertTrue(poker.sorVizsgalat(kez6));
    }

    @Test
    public void testLegertekesebb() {    
        kez3.sort(new LapComparator());
        assertEquals("Sor", poker.kiertekel(kez3));
        
        kez2.sort(new LapComparator());
        assertEquals("Egy pár 1", poker.kiertekel(kez2));
        
        kez4.sort(new LapComparator());
        assertEquals("Poker", poker.kiertekel(kez4));
        
        kez5.sort(new LapComparator());
        assertEquals("Full", poker.kiertekel(kez5));
    }

    @Test
    public void test(){
        List<Lap> kez = poker.kezGeneralas();
        poker.printKez(kez);
    }
}
