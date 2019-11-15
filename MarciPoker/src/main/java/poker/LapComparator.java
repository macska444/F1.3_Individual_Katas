package poker;

import java.util.Comparator;

public class LapComparator implements Comparator<Lap>{
 
    @Override
    public int compare(Lap o1, Lap o2) {
        return Integer.valueOf(o2.ertek).compareTo(Integer.valueOf(o1.ertek));
    }
    
}
