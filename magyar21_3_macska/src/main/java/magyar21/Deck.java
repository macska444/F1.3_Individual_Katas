package magyar21;

import java.util.LinkedList;
import java.util.Random;


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

    public Integer getNextCard() {
        int deckSize = deck.size();
        int nextIndex = new Random().nextInt(deckSize - 1);
        Integer nextCard = deck.get(nextIndex);
        deck.remove(nextIndex);
        return nextCard;
    }
}
