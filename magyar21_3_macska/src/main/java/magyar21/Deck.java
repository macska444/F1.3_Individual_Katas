package magyar21;

import java.util.LinkedList;
import java.util.Random;


public class Deck {
    public LinkedList<Integer> deck;

    public Deck(int numberOfDecks) {
        deck = new LinkedList<>();
        for (int i = 0; i < 4 * numberOfDecks; i++) {
            for (HunCardRanks rank : HunCardRanks.values()) {
                deck.add(rank.getValue());
            }
        }
    }

    public Integer getNextCard() {
        int deckSize = deck.size();
        if (deckSize == 0) {
            throw new NoMoreCardInDeck();
        }
        int nextIndex = new Random().nextInt(deckSize);
        Integer nextCard = deck.remove(nextIndex);
        return nextCard;
    }
}
