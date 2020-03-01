package magyar21;


import java.util.ArrayList;
import java.util.List;

public class Hand {
    List<Integer> hand = new ArrayList<>();
    int numberOfCards = 0;
    Integer sumOfCards = 0;

    public void addCard(Integer cardRank) {
        hand.add(cardRank);
    }

    public void evaluateHand() {
        validateHand();
        numberOfCards = hand.size();
        sumOfCards = sumUpCards();
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

    public Integer getSumOfCards() {
        return sumOfCards;
    }

    public Integer getNumberOfCards() {
        return numberOfCards;
    }
}
