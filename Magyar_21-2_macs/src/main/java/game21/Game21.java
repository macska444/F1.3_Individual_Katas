package game21;

import java.util.List;

public class Game21 {
    private static final Integer MINIMUM_VALUE_OF_HAND = 15;

    public Integer evalHand(List<Integer> hand) {
        Integer score = 0;
        for (Integer card : hand) {
            score += card;
        }
        return score;
    }

    public HandType evalHandType(List<Integer> hand) {
        Integer score = evalHand(hand);
        if (score < MINIMUM_VALUE_OF_HAND) {
            return HandType.NOT_ENOUGH;
        } else {
            return HandType.CAN_STOP_OR_ASK_MORE;
        }
    }
}
