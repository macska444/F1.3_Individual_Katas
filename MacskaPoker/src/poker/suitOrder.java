/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

import java.util.HashMap;

/**
 *
 * @author Macska
 */
public class suitOrder {
    public static HashMap<String, Integer> cardSuits= new HashMap<String, Integer>();
    
    /**
     *
     */
    public static void inic () {
        System.out.println("suitOrder inic");
                
        cardSuits.put( "Spade",1);
        cardSuits.put( "Heart",2);
        cardSuits.put( "Diamond",3);
        cardSuits.put( "Club",4);
     }
    
    public static int getSuitValue(String pSuitSymbol) {
        return cardSuits.get(pSuitSymbol);
    }
   
    
}
