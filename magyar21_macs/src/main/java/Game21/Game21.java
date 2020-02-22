package Game21;

import java.util.List;

public class Game21 {

    public Integer evaluate (List<Integer> hand) {
        Integer result = 0;
        for (Integer card : hand) {
            result += card;
        }
        return result;
    }
}
