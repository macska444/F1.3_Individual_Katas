package poker;
import java.util.*;

/**
 *
 * @author Macska
 */
public class Hand {
    ArrayList<Card> cards;
    TreeMap<Integer,Integer> countPerRanks;
    TreeMap<Integer,Integer> countPerSuits;
    int lowestRankHighValue;
    int highestRankLowValue;
    int maximumOfCardsInSameSuit;
    int numberOfPairs;
    int numberOfDrill;
    int numberOfPoker;
    ArrayList<Integer> countedRanks;
    int longestSuit;
    boolean isEvaluated;
    String handValue;

    public Hand(){
        cards = new ArrayList<>();
        countPerRanks = new TreeMap<>();
        countPerSuits = new TreeMap<>();
        countedRanks = new ArrayList<>();
        cleanStatistics();      
    }
    
    private void cleanStatistics() {
        countPerRanks.clear();
        countPerSuits.clear();
        lowestRankHighValue = 15;
        highestRankLowValue = 0;
        maximumOfCardsInSameSuit = 0;
        numberOfPairs = 0;
        numberOfDrill = 0;
        numberOfPoker = 0;
        countedRanks.clear();
        longestSuit = 0;
        handValue = "";
        isEvaluated = false;
        
   }

    public void AddCard(String suit, String rank){
        if (cards.size() > 4) {
            System.out.println("Caution: One hand should have no more than 5 cards");
            return;
        }
        Card nextCard = new Card(suit,rank);
        if (cards.contains(nextCard)){
            System.out.println("Caution: This card is in hand already");
            return;
        }
        cards.add(nextCard); 
        analyzeHand();
    }
    
    public void analyzeHand() {
        cleanStatistics();
        for(Card nextCard:cards) {
            addCardToStatistics(nextCard); 
            if (lowestRankHighValue > nextCard.rankHighValue) {lowestRankHighValue = nextCard.rankHighValue;}
            if (highestRankLowValue < nextCard.rankLowValue) {highestRankLowValue = nextCard.rankLowValue;}            
        }
    }

    private void addCardToStatistics(Card nextCard) {
        addCardToRankStatistics(nextCard);
        addCardToSuitStatistics(nextCard);
    }

    private void addCardToSuitStatistics(Card card) {
        int suitCode = suitOrder.getSuitValueByName(card.suit);
        int countOfThisSuit = countPerSuits.containsKey(suitCode) ? countPerSuits.get(suitCode) : 0;
        countPerSuits.put(suitCode,countOfThisSuit+1);
    }

    private void addCardToRankStatistics(Card card) {
        int countOfThisRank = countPerRanks.containsKey(card.rankHighValue) ? countPerRanks.get(card.rankHighValue) : 0;
        countPerRanks.put(card.rankHighValue,countOfThisRank+1);
    }
    
    
    public String eval() {
        searchForSameRanks();
        searchForSameSuits();

        // Q♥ J♥ 10♥ 9♥ 8♥       
        checkStraightFlush();

        // poker 9♣ 9♠ 9♦ 9♥ J♥       
        checkPoker();
        
        // full 1 pair + 1 drill 3♣ 3♠ 3♦ 6♣ 6♥
        checkFull();
         
        // Flush K♣ 10♣ 7♣ 6♣ 4♣
        checkFlush();
        
        // Straight A♦ K♣ Q♣ J♦ 10♠,  or 5♣ 4♦ 3♥ 2♥ A♠
        checkStraight();
        
        // Drill 3♦ 3♠ 3♣ J♣ 7♥
        checkDrill();
        
        // Two Pair 5♣ 5♠ 4♦ 4♥ 10♥
        checkTwoPair();
        
        // Pair 4♥ 4♠ K♠ 10♦ 5♠
        checkOnePair();
        
        // High card hand K♥ J♥ 8♣ 7♦ 4♠ 
        checkHighCardHand ();
        
        return(handValue);
        
    }

    private void searchForSameRanks() {
        for(Map.Entry<Integer,Integer> entry : countPerRanks.entrySet()) {
            int value = entry.getValue();
            switch (value) {
                case 2:
                    numberOfPairs++;
                    break;
                case 3:
                    numberOfDrill++;
                    break;
                case 4:
                    numberOfPoker++;
                    break;
                default:
                    break;
            }
            if (value > 1) {
                countedRanks.add(entry.getKey());
            }
        }
    }

    private void searchForSameSuits() {
        // compute maximumOfCardsInSameSuit
        for (Map.Entry<Integer,Integer> entry: countPerSuits.entrySet()) {
            int value = entry.getValue();
            if (value > maximumOfCardsInSameSuit) {
                maximumOfCardsInSameSuit = value;
                longestSuit = entry.getKey();
            }
        }
    }
    
    private boolean checkStraightFlush() {
        if (maximumOfCardsInSameSuit == 5 && checkStraight()) {
            if (lowestRankHighValue == 10){
                handValue = "Royal flush in " + cards.get(0).suit;
            }
            else  {
                handValue = handValue + " flush in " + cards.get(0).suit;
            }
        }
        return isEvaluated;
    }
    
    private boolean checkStraight () {
    // ez a feltétel hiányzott, hogy ne detektáljon hamis sorrokat!!!!
    // testHandEvalFalseQueenHighStraight   
        if (countPerRanks.size()==5) {
            checkAceHighStraight ();
            checkFiveHighStraight ();
            if (!isEvaluated && highestRankLowValue - lowestRankHighValue == 4){
                handValue = rankOrder.getRankNameByValue(highestRankLowValue) + "-high straight";
                isEvaluated = true;
            }
        }
        return isEvaluated;
    }
    
    private boolean checkAceHighStraight () {
        if (!isEvaluated && lowestRankHighValue == 10){
            handValue = "Ace-high straight";
            isEvaluated = true;
        }
        return isEvaluated;
    }
    private boolean checkFiveHighStraight () {
        if (!isEvaluated && highestRankLowValue == 5){
            handValue = "Five-high straight";
            isEvaluated = true;
        }
        return isEvaluated;
    }

    
    private boolean checkPoker() {
        if (numberOfPoker == 1){
            handValue = "Poker, " + rankOrder.getRankNameByValue(countedRanks.get(0)) + "s";
            isEvaluated = true;
        } 
        return isEvaluated;
    }
    
    private boolean checkFull() {
        if (numberOfPairs == 1 && numberOfDrill == 1){
            int rank3 = countedRanks.get(0);
            int rank2 = countedRanks.get(1);
            if (countPerRanks.get(rank3)== 2) {
                rank3 = countedRanks.get(1);
                rank2 = countedRanks.get(0);                
            }
            handValue = "Full house, " + rankOrder.getRankNameByValue(rank3) + "s over " + rankOrder.getRankNameByValue(rank2) +"s";
            isEvaluated = true;
         }
        return isEvaluated;
    }
    
    private boolean checkFlush() {
        if (!isEvaluated && maximumOfCardsInSameSuit == 5){
            if (countPerRanks.containsKey(rankOrder.getRankValueByName("Ace"))) {
                handValue = "Ace-high flush in " + cards.get(0).suit;
            } else {
                handValue = rankOrder.getRankNameByValue(highestRankLowValue) + "-high flush in " + cards.get(0).suit;               
            }
            isEvaluated = true;
        }
        return isEvaluated;   
    }
        
    private boolean checkDrill () {
        if (!isEvaluated && numberOfDrill == 1){
            handValue = "Drill of " + rankOrder.getRankNameByValue(countedRanks.get(0)) + "s";
            isEvaluated = true; 
        } 
        return isEvaluated;
    }
    
    private boolean checkTwoPair () {
        if (!isEvaluated && numberOfPairs == 2){
            int rank1 = countedRanks.get(0);
            int rank2 = countedRanks.get(1);
            String higherRank = rank1 > rank2 ? rankOrder.getRankNameByValue(rank1) : rankOrder.getRankNameByValue(rank2);
            String lowerRank  = rank1 > rank2 ? rankOrder.getRankNameByValue(rank2) : rankOrder.getRankNameByValue(rank1);           
            handValue = "Two pair, " + higherRank + "s over " + lowerRank + "s";
            isEvaluated= true;
        }  
        return isEvaluated;
    }
    
    private boolean checkOnePair () {
       if (!isEvaluated && numberOfPairs == 1){
            handValue = "Pair of " + rankOrder.getRankNameByValue(countedRanks.get(0)) + "s";
            isEvaluated = true;
        }
       return isEvaluated;        
    }
    
    private boolean checkHighCardHand () {
        if (!isEvaluated) {
            if (countPerRanks.containsKey(rankOrder.getRankValueByName("Ace"))) {
                handValue = "High card, Ace";
            } else {
                handValue = "High card, " + rankOrder.getRankNameByValue(highestRankLowValue);
            }
            isEvaluated = true;
        }
        return isEvaluated;
    }
    
    public void print() {
        Collections.sort(this.cards);
        final int numberOfCards = getNumberOfCards();
        System.out.println("This hand has " + numberOfCards + " card" + (numberOfCards > 1 ? "s" : "") );
        System.out.println("As follows:");
        for (Card card: this.cards) {
            System.out.println(card.toString());
        }
        if (isEvaluated ) {
            System.out.println("The value of Hand: " + handValue);
        }
        System.out.println("======================================================");
    }
    

    public int getNumberOfCards() {
        final int numberOfCards = this.cards.size();
        return numberOfCards;
    }
    
    
}
