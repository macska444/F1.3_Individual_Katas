package magyar21;


import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Integer> hand = new ArrayList<>();
    int numberOfCards = 0;
    Integer sumOfCards = 0;
    String actualScore = "Not evaluated yet";

    public void addCard(Integer card) {
        hand.add(card);
    }

    public void evaluateHand() {
        validateHand();
        numberOfCards = hand.size();
        sumOfCards = sumUpCards();
        calculateScore();
    }

    public Integer getSumOfCards() {
        return sumOfCards;
    }

    public Integer getNumberOfCards() {
        return numberOfCards;
    }

    public String getActualScore() {
        return actualScore;
    }

    private void calculateScore() {
        if (sumOfCards == 21) {
            actualScore = HandScores.BLACKJACK.toString();
        } else if (sumOfCards < 21) {
            actualScore = HandScores.MAY_HIT_OR_STAND.toString();
        } else if (sumOfCards > 21) {
            actualScore = HandScores.BUST.toString();
        }
    }

    private void validateHand() {
        if (hand == null || hand.size() == 0) {
            throw new EmptyHandException();
        }
        for (Integer cardRank : hand) {
            if (!HunCardRanks.hasCard(cardRank)) {
                throw new InvalidCardRank();
            }
        }
    }

    private Integer sumUpCards() {
        Integer score = 0;
        for (Integer cardRank : hand) {
            score += cardRank;
        }
        return score;
    }

}
