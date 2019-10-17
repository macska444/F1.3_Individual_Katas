/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poker;

/**
 *
 * @author Macska
 */
public class Card {
    int rankLowValue;
    int rankHighValue;
    String rankSymbol;
    String suit;
// construktors    
   public Card (int pRLV, int pRHV, String pS, String pRS) {
       this.rankHighValue = pRHV;
       this.rankLowValue = pRLV;
       this.rankSymbol = pRS;
       this.suit = pS;
   }
   public Card (String pS, String pRS) {
       this.rankSymbol = pRS;
       this.suit = pS;       
       this.rankHighValue = rankOrder.getRankValue(pRS);
       if (pRS.equalsIgnoreCase("A")){
          this.rankLowValue = 1; 
       }
       else {
        this.rankLowValue = this.rankHighValue;
       }
       
   }   
   
}
