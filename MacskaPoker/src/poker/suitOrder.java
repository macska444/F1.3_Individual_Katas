package poker;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Macska
 */
public class suitOrder {
    public static HashMap<String, Integer> cardSuits= inic();
    
    /**
     *
     */
    private static HashMap<String, Integer> inic () {
        System.out.println("suitOrder inic");
        HashMap<String, Integer> suits = new HashMap();
                
        suits.put( "Spades",1);
        suits.put( "Hearts",2);
        suits.put( "Diamonds",3);
        suits.put( "Clubs",4);
        return(suits);
     }
    
    public static int getSuitValueByName(String suitName) {
        return cardSuits.get(suitName);
    }

    public static String getSuitNameByValue(int suitCode) {
       for (Map.Entry<String, Integer> entry : cardSuits.entrySet()) {
            if (entry.getValue()==suitCode) {
                return entry.getKey();
            }
        }
    return("No such card");
    }
    
    
}
