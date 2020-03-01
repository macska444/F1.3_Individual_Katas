package magyar21;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeckTest {

    @Test
    public void generateDeckTest() {
        Deck myDeck = new Deck();
        Integer expectedCard = 10;
        assertEquals(expectedCard, myDeck.deck.get(20));
        int expectedNumOfCards = 4 * HunCardRanks.values().length;
        assertEquals(expectedNumOfCards, myDeck.deck.size());
    }

}