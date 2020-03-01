package magyar21;

import java.util.List;

public class Hand {
    public Integer evaluateHand(List<Integer> hand) {
        validateHand(hand);
        return sum(hand);
    }

    private void validateHand(List<Integer> hand) {
        if (hand == null || hand.size() == 0) {
            throw new EmptyHandException();
        }

    }

    private Integer sum(List<Integer> hand) {
        Integer score = 0;
        for (Integer cardRank : hand) {
            score += cardRank;
        }
        return score;
    }

}
