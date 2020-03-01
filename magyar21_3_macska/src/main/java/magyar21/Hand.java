package magyar21;


import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Integer> hand = new ArrayList<>();
    int numberOfCards = 0;
    Integer sumOfCards = 0;
    String actualScore = "Not evaluated yet";
    boolean isWithoutAce = false;

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

    public boolean isWithoutAce() {
        return isWithoutAce;
    }

    public void playerSaysWithoutAce() {
        if (numberOfCards >= 2 && sumOfCards == 11) {
            isWithoutAce = true;
        } else {
            throw new WrongWithoutAce();
        }
    }

    private void calculateScore() {
        if (sumOfCards == 21) {
            actualScore = HandScores.BLACKJACK.toString();
        } else if (sumOfCards < 15) {
            actualScore = HandScores.MUST_HIT.toString();
        } else if (sumOfCards < 21) {
            actualScore = HandScores.MAY_HIT_OR_STAND.toString();
        } else if (sumOfCards > 21) {
            if (numberOfCards == 2 && handHas2Aces()) {
                actualScore = HandScores.BLACKJACK.toString();
            } else if (isWithoutAce() && lastCardIsAce()) {
                actualScore = HandScores.MAY_GET_NEW_HAND.toString();
            } else {
                actualScore = HandScores.BUST.toString();
            }
        }
    }

    private boolean lastCardIsAce() {
        if (hand == null || hand.size() == 0) {
            return false;
        } else {
            return hand.get(hand.size() - 1) == HunCardRanks.ASZ.getValue();
        }
    }

    private boolean handHas2Aces() {
        return hand.get(0) == 11 && hand.get(1) == 11;
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
