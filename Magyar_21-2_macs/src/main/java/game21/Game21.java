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
        } else if (score > MAXIMUM_OF_HAND_VALUE) {
            return HandType.OVER;
        } else if (score == MAXIMUM_OF_HAND_VALUE) {
            return HandType.BLACKJACK;
        } else {
            return HandType.CAN_STOP_OR_ASK_MORE;
        }
    }
}
