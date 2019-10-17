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
public class Hand {
    ArrayList<Card> cards;
    TreeMap<Integer,Integer> countRank;
    TreeMap<Integer,Integer> countSuit;
    int lowestRank;
    int highestRank;
    int maxSuit;
    int maxRank;
    int numPair;
    int numDrill;
    int numPoker;
    int pokerRank;

    

    public Hand(){
        cards = new ArrayList<Card>();
        countRank = new TreeMap<Integer,Integer>();
        countRank.put(1,0);
        countRank.put(2,0);
        countRank.put(3,0);
        countRank.put(4,0);
        countRank.put(5,0);
        countRank.put(6,0);
        countRank.put(7,0);
        countRank.put(8,0);
        countRank.put(9,0);
        countRank.put(10,0);
        countRank.put(11,0);
        countRank.put(12,0);
        countRank.put(13,0);
        countRank.put(14,0);

        countSuit = new TreeMap<Integer,Integer>();
        countSuit.put(1,0);
        countSuit.put(2,0);
        countSuit.put(3,0);
        countSuit.put(4,0);
        lowestRank = 15;
        highestRank = 0;
        maxSuit = 0;
        maxRank = 0;
                
    }
    
    public void AddCard(String pSuit, String pRank){
        //check if there is no more than 5 cards
        if (cards.size() > 4) {
            System.out.println("Csak 5 lap lehet egy kézben");
            return;
        }
        Card nextCard = new Card(pSuit,pRank);
        cards.add(nextCard);        
    }
    
    public String eval() {
        for(Card nextCard:cards) {
            countRank.put(nextCard.rankHighValue,countRank.get(nextCard.rankHighValue)+1);
            countSuit.put(suitOrder.getSuitValue(nextCard.suit),countSuit.get(suitOrder.getSuitValue(nextCard.suit))+1); 
            // lowest and highest rank. Aces are skipped.
            if (lowestRank > nextCard.rankHighValue) {lowestRank = nextCard.rankHighValue;}
            if (highestRank < nextCard.rankLowValue) {highestRank = nextCard.rankLowValue;}            
        }
        // compute pairs, drills and poker
        for(Map.Entry<Integer,Integer> entry : countRank.entrySet()) {
            int value = entry.getValue();
            if (value == 2) {
                 numPair++;
            }
            else if (value == 3) {
                 numDrill++;
            }
            else if (value == 4) {
                 numPoker++;
                 pokerRank = entry.getKey();
            }
        }
        // compute maxSuit
        for (Map.Entry<Integer,Integer> entry: countSuit.entrySet()) {
            int value = entry.getValue();
            if (value > maxSuit) {maxSuit = value;}               
        }
        
        // we know everything for the evaluation
        // computing backward except straights: its simplier to eval together

    // Straight Flush + Straight: 
        // case 1: without Ace
        if (highestRank - lowestRank == 4){
            return ("Straight " + (maxSuit == 5 ? "flush ":"") + "starting with " + lowestRank + (maxSuit == 5 ?" in " + cards.get(0).suit:""));
        }
        // case 2: it begins with Ace (first counted card is 2)
        if (highestRank - lowestRank == 3 && lowestRank == 2 && countRank.get(13)==1) {
            return ("Straight " + (maxSuit == 5 ? "flush ":"") + "starting with ACE"+ (maxSuit == 5 ?" in " + cards.get(0).suit:""));        
        }
        //case 3: it lasts with Ace (last counted card is King(13)
        if (highestRank - lowestRank == 3 && highestRank == 13 && countRank.get(13)==1) {
             return ("Straight " + (maxSuit == 5 ? "flush ":"") + "starting with 10" + (maxSuit == 5 ?" in " + cards.get(0).suit:""));        
        }
    // poker
        if (numPoker == 1){
            return ("Poker in " + rankOrder.getRankName(pokerRank));
        }
    // full
        if (numPair == 1 && numDrill == 1){
            // TODO: compute ranks also
            return ("Full");
        }
    // Flush (all cards in same suit, but not straight
        if (maxSuit == 5){
            // TODO: compute ranks also
            return ("Flush in "+ cards.get(0).suit);
        }
    // Drill
        if (numDrill == 1){
            // TODO: compute ranks also
            return ("Drill");
        }
    // Two Pairs
        if (numPair == 2){
            // TODO: compute ranks also
            return ("Two pairs");
        }
    // Pair
        if (numPair == 1){
            // TODO: compute ranks also
            return ("Pair");
        }
    
        return("Unable to evaluate");
        
    }
    
    
}
