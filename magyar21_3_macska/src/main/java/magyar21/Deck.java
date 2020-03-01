package magyar21;

import java.util.LinkedList;


public class Deck {
    public LinkedList<Integer> deck;

    public Deck() {
        deck = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            for (HunCardRanks rank : HunCardRanks.values()) {
                deck.add(rank.getValue());
            }
        }
    }
}
