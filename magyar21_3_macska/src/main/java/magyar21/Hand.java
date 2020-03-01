package magyar21;

import java.util.List;

public class Hand {
    public Integer evaluateHand(List<Integer> hand) {
        return sum(hand);
    }

    private Integer sum(List<Integer> hand) {
        Integer score = 0;
        for (Integer cardRank : hand) {
            score += cardRank;
        }
        return score;
    }

}
