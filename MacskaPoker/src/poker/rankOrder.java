
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package poker;
import java.util.*;




/**
 *
 * @author Macska
 */
public class rankOrder {
    public static HashMap<String, Integer> cardRanks= new HashMap<String, Integer>();
    
    /**
     *
     */
    public static void inic () {
        System.out.println("rankOrder inic");
                
        cardRanks.put( "2",2);
        cardRanks.put( "3",3);
        cardRanks.put( "4",4);
        cardRanks.put( "5",5);
        cardRanks.put( "6",6);
        cardRanks.put( "7",7);
        cardRanks.put( "8",8);
        cardRanks.put( "9",9);
        cardRanks.put("10", 10);
        cardRanks.put("J",11 );
        cardRanks.put("Q",12 );
        cardRanks.put("K",13 );
        cardRanks.put("A",14 );
    }
    
    public static int getRankValue(String pRankSymbol) {
        return cardRanks.get(pRankSymbol);
    }
    
    public static String getRankName(int pRankNum) {
        for (Map.Entry<String, Integer> entry : cardRanks.entrySet()) {
            if (entry.getValue()== pRankNum) {
                return entry.getKey();
            }
        }
    return("No such card");
    }

}
