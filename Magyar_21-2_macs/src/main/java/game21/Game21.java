package game21;

import java.util.List;

public class Game21 {
    public Integer eval(List<Integer> hand) {
        Integer score = 0;
        for (Integer card : hand) {
            score += card;
        }
        return score;
    }
}
