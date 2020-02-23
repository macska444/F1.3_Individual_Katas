package game21;

import java.util.List;

public class Game21 {
    private static final Integer MINIMUM_OF_HAND_VALUE = 15;
    private static final Integer MAXIMUM_OF_HAND_VALUE = 21;

    public Integer evalHandValue(List<Integer> hand) {
        Integer score = 0;
        for (Integer card : hand) {
            score += card;
        }
        return score;
    }

    public HandType evalHandType(List<Integer> hand) {
        Integer score = evalHandValue(hand);
        if (score < MINIMUM_OF_HAND_VALUE) {
            return HandType.NOT_ENOUGH;
        } else if (score == MAXIMUM_OF_HAND_VALUE + 1
                && isHandHas2Ace(hand)) {
            return HandType.BLACKJACK;
        } else if (score > MAXIMUM_OF_HAND_VALUE) {
            return HandType.BUST;
        } else if (score == MAXIMUM_OF_HAND_VALUE) {
            return HandType.BLACKJACK;
        } else {
            return HandType.MAY_STAND_OR_HIT;
        }
    }

    private boolean isHandHas2Ace(List<Integer> hand) {
        return (hand.size() == 2 && hand.stream().allMatch(rank -> rank == MagyarkartyaRank.ASZ.value));
    }
}
