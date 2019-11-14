package Poker;

import java.util.Comparator;

/**
 *
 * @author singer
 */
public class Comparatorok implements Comparator<Lap>{
 
    @Override
    public int compare(Lap o1, Lap o2) {
        return Integer.valueOf(o2.ertek).compareTo(Integer.valueOf(o1.ertek));
    }
    
}
