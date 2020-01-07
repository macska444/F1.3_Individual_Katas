package poker;

/**
 *
 * @author Macska
 */
public class Card  implements Comparable {
    String rankName;
    String suit;
    int rankLowValue;
    int rankHighValue;
    
   public Card (int suitCode, int rankCode) {
        this(suitOrder.getSuitNameByValue(suitCode),rankOrder.getRankNameByValue(rankCode));
   }
   
   public Card (String suit, String rankName) {
       this.rankName = rankName;
       this.suit = suit;       
       this.rankHighValue = rankOrder.getRankValueByName(rankName);
       setLowValueOfRank(rankName);
   }    

    private void setLowValueOfRank(String rankName1) {
        if (rankName1.equalsIgnoreCase("Ace")) {
            this.rankLowValue = 1;
        } else {
            this.rankLowValue = this.rankHighValue;
        }
    }


    @Override
    public int compareTo(Object o) {
        int suitDifference = suitOrder.getSuitValueByName(((Card)this).suit) - suitOrder.getSuitValueByName(((Card)o).suit);
        int rankDifference = rankOrder.getRankValueByName(((Card)this).rankName) - rankOrder.getRankValueByName(((Card)o).rankName);
        if (rankDifference == 0) {
            return suitDifference;
        } else {
            return rankDifference;
        }
    }
    
    @Override
    public String toString() {
        return this.suit + " " + this.rankName;
    }
    
    @Override
    public boolean equals(Object obj) {
        return (this.rankName.equals(((Card)obj).rankName)
                && this.suit.equals(((Card)obj).suit));
    }

}

