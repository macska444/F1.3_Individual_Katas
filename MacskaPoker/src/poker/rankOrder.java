
package poker;
import java.util.*;

/**
 *
 * @author Macska
 */
public class rankOrder {
    public static HashMap<String, Integer> cardRanks= inic();
    
    private static HashMap<String, Integer> inic () {
        System.out.println("rankOrder inic");
        HashMap<String, Integer> ranks = new HashMap<>();

        ranks.put( "Two",2);
        ranks.put( "Three",3);
        ranks.put( "Four",4);
        ranks.put( "Five",5);
        ranks.put( "Six",6);
        ranks.put( "Seven",7);
        ranks.put( "Eight",8);
        ranks.put( "Nine",9);
        ranks.put("Ten", 10);
        ranks.put("Jack",11 );
        ranks.put("Queen",12 );
        ranks.put("King",13 );
        ranks.put("Ace",14 );
        return ranks;
    }
    
    public static int getRankValueByName(String rankName) {
        return cardRanks.get(rankName);
    }
    
    public static String getRankNameByValue(int rankValue) {
        for (Map.Entry<String, Integer> entry : cardRanks.entrySet()) {
            if (entry.getValue()==rankValue) {
                return entry.getKey();
            }
        }
    return("No such card");
    }

}
